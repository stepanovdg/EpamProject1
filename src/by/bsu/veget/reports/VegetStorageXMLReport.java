package by.bsu.veget.reports;

import by.bsu.veget.enums.VegetClassEnum;
import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.*;
import by.bsu.veget.storage.VegetStorage;
import by.bsu.veget.storage.VegetStorageSingletone;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 19.11.11
 * Time: 21:39
 */
public class VegetStorageXMLReport {
    private VegetStorage vglist = VegetStorageSingletone.getInstance()
            .getVegStorage();

    public VegetStorageXMLReport(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;

    private String idToString(Vegetable veget) {
        Integer id = veget.getId();
        String result = "d";
        if (id <= 9) return "d" + "0000000" + id.toString();
        if (id <= 99) return "d" + "000000" + id.toString();
        if (id <= 999) return "d" + "00000" + id.toString();
        if (id <= 9999) return "d" + "0000" + id.toString();
        if (id <= 99999) return "d" + "000" + id.toString();
        if (id <= 999999) return "d" + "00" + id.toString();
        if (id <= 9999999) return "d" + "0" + id.toString();
        if (id <= 99999999) return "d" + id.toString();
        return id.toString();
    }

    public void allVeget() throws VegetException {

        try {
            DocumentBuilderFactory dbf =
                    DocumentBuilderFactory.newInstance();


            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElementNS(null, "vegetables"); // Create Root Element
            for (Vegetable veget : vglist) {
                Element veg = doc.createElementNS(null, "vegetable");
                Element item = doc.createElementNS(null, "vegetable");  // Create element
                VegetEnum vegen = VegetEnum.values()[veget.getVegetEnumId()];
                veg.setAttribute("name", vegen.toString().toLowerCase());
                item = doc.createElementNS(null, "uid");            // Create another Element
                item.appendChild(doc.createTextNode(idToString(veget)));
                veg.appendChild(item);
                item = doc.createElementNS(null, "country");            // Create another Element
                item.appendChild(doc.createTextNode((veget.getProduceCountry())));
                veg.appendChild(item);
                Element data = doc.createElementNS(null, "data");
                item = doc.createElementNS(null, "year");            // Create another Element
                item.appendChild(doc.createTextNode((new Integer(veget.getColectDate().get(Calendar.YEAR))).toString()));
                data.appendChild(item);
                item = doc.createElementNS(null, "month");
                if(veget.getColectDate().get(Calendar.MONTH)<=9) {
                item.appendChild(doc.createTextNode("--0"+(new Integer(veget.getColectDate().get(Calendar.MONTH))).toString()+"--"));
                }else{
                item.appendChild(doc.createTextNode("--"+(new Integer(veget.getColectDate().get(Calendar.MONTH))).toString()+"--"));
                }
                data.appendChild(item);
                item = doc.createElementNS(null, "day");            // Create another Element
                item.appendChild(doc.createTextNode("---"+(new Integer(veget.getColectDate().get(Calendar.DAY_OF_MONTH))).toString()));
                data.appendChild(item);
                veg.appendChild(data);
                item = doc.createElementNS(null, "weight-per-kg");            // Create another Element
                item.appendChild(doc.createTextNode((veget.getWeightPerKg()).toString()));
                veg.appendChild(item);
                item = doc.createElementNS(null, "price-per-kg");            // Create another Element
                item.appendChild(doc.createTextNode(veget.getPricePerKg().toString()));
                veg.appendChild(item);
                item = doc.createElementNS(null, "quality-of-veget");            // Create another Element
                item.appendChild(doc.createTextNode(veget.getQualityOfVeget().toString()));
                veg.appendChild(item);
                item = doc.createElementNS(null, "uniq-parameter");
                // Create another Element
                switch (VegetClassEnum.valueOf(vegen.vegetKind())) {
                    case LV:
                        item.appendChild(doc.createTextNode(String.valueOf((((LeafsVeget) veget).getListUniqParametr()))));
                        break;
                    case BV:
                        item.appendChild(doc.createTextNode(String.valueOf((((BeansVeget) veget).getBeansUniqParametr()))));
                        break;
                    case OV:
                        item.appendChild(doc.createTextNode(String.valueOf((((OnionVeget) veget).getOnionUniqParametr()))));
                        break;
                    case RV:
                        item.appendChild(doc.createTextNode(String.valueOf((((RootVeget) veget).getRootUniqParametr()))));
                        break;
                    case PV:
                        item.appendChild(doc.createTextNode(String.valueOf((((PumkinVeget) veget).getPumkinUniqParametr()))));
                        break;
                    default:
                        String msg = "Unknown Vegetable Constructor: " + vegen;
                        throw new IllegalArgumentException(msg);
                }
                veg.appendChild(item);
                root.appendChild(veg);
            }// Attach another Element - grandaugther
            doc.appendChild(root);                            // Add Root to Document
            DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            DOMImplementationLS domImplLS = (DOMImplementationLS) registry.getDOMImplementation("LS");
            LSSerializer ser = domImplLS.createLSSerializer();  // Create a serializer for the DOM
            LSOutput out = domImplLS.createLSOutput();
            StringWriter stringOut = new StringWriter();
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(filePath));// Writer will be a String
            out.setCharacterStream(printWriter);
            ser.write(doc, out);                                // Serialize the DOM

            //   printWriter.println(stringOut.toString());                   // Spit out the DOM as a String


        } catch (ParserConfigurationException e) {
            String msg = "The mistake of Parser configurate in xml writing";
            throw new VegetException(msg, e);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            String msg = "The mistake in xml writing ";
            throw new VegetException(msg, e);
        } catch (FileNotFoundException e) {
            String msg = "The mistake of finding file in xml writing ";
            throw new VegetException(msg, e);
        }


    }
}
