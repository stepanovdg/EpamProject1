package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.storage.VegetStorageController;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 19.11.11
 * Time: 21:00
 */
public class DomBuilder extends AbstractBuilder {

    private  VegetStorageController vsc = new VegetStorageController();


    private void analyzeVeget(Element root) throws VegetException {
        NodeList vegetNodes = root.getElementsByTagName("vegetable");
        String[] s;
        for (int i = 0; i < vegetNodes.getLength(); i++) {
            s = new String[9];
            Element vegetElement =
                    (Element) vegetNodes.item(i);

            s[0] = (vegetElement.getAttribute("name"));
            s[1] = getBabyValue(vegetElement, ("country"));
            Element dateElement =
                    getBaby(vegetElement, "data");
            s[2] = getBabyValue(dateElement, ("year"));
            s[3] = getBabyValue(dateElement, ("month")).replace("-","");
            s[4] = getBabyValue(dateElement, ("day")).replace("-","");

            s[5] = getBabyValue(vegetElement, ("weight-per-kg"));
            s[6] = getBabyValue(vegetElement, ("price-per-kg"));
            s[7] = getBabyValue(vegetElement, ("quality-of-veget"));
            s[8] = getBabyValue(vegetElement, ("uniq-parameter"));
            VegetableFactory vegf = new VegetableFactory(s);
            vsc.addVeget((Vegetable) vegf.createVeget());

        }
    }


    private  Element getBaby(Element parent, String childName) {
        NodeList nlist =
                parent.getElementsByTagName(childName);
        return (Element) nlist.item(0);
    }


    private  String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        return node.getNodeValue();
    }


    @Override
    public void buildVeget(String filePath) throws VegetException {
         try {


            DOMParser parser = new DOMParser();
            parser.parse(filePath);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            this.analyzeVeget(root);

        } catch (SAXException e) {
            String msg = "The mistake of SAX Parser in xerces";
            throw new VegetException(msg, e);
        } catch (IOException e) {
            String msg = "The mistake of I/O stream in xerces analyzing ";
            throw new VegetException(msg, e);
        }
    }
}
