package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.out.VegetOutManager;
import by.bsu.veget.storage.VegetStorageController;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 19.11.11
 * Time: 19:45
 */
public class StAXBuilder extends AbstractBuilder {
    private VegetStorageController vsc = new VegetStorageController();
    private String[] s;
    private String currentElement;

    private void parse(InputStream input) {
        XMLInputFactory inputFactory =
                XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings({"ConstantConditions"})
    private void process(XMLStreamReader reader)
            throws XMLStreamException {
        String qName;
        while (reader.hasNext()) {

            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    qName = reader.getLocalName();
                    if (qName.equals("vegetable")) {
                        s = new String[9];
                        s[0] = reader.getAttributeValue(null, "name");
                    } else {
                        currentElement = qName;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    qName = reader.getLocalName();
                    if (qName.equals("vegetable")) {
                        VegetableFactory vegf = null;
                        try {
                            vegf = new VegetableFactory(s);
                            vsc.addVeget((Vegetable) vegf.createVeget());
                            s = null;
                            currentElement = null;
                        } catch (VegetException e) {
                            VegetOutManager.getInstance().println("Read and try to correct mistakes");
                        }

                    }
                    break;
                case XMLStreamConstants.CHARACTERS: {
                    if (currentElement != null) {
                        switch (currentElement) {
                            case "uid":
                                break;
                            case "country":
                                if (s[1] == null) {
                                    s[1] = reader.getText();
                                }
                                break;
                            case "year":
                                if (s[2] == null) {
                                    s[2] = reader.getText();
                                }
                                break;
                            case "month":
                                if (s[3] == null) {
                                    s[3] = reader.getText().replace("-","");
                                }
                                break;
                            case "day":
                                if (s[4] == null) {
                                    s[4] = reader.getText().replace("-","");
                                }
                                break;
                            case "weight-per-kg":
                                if (s[5] == null) {
                                    s[5] = reader.getText();
                                }
                                break;
                            case "price-per-kg":
                                if (s[6] == null) {
                                    s[6] = reader.getText();
                                }
                                break;
                            case "quality-of-veget":
                                if (s[7] == null) {
                                    s[7] = reader.getText();
                                }
                                break;
                            case "uniq-parameter":
                                if (s != null && s[8] == null) {
                                    s[8] = reader.getText();

                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                default:
                    break;
            }
        }
    }

    @Override
    public void buildVeget(String filePath) throws VegetException {
        try {

            InputStream input = null;
            input = new FileInputStream(filePath);
            this.parse(input);
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of initVeget.xml in this directory";
            throw new VegetException(msg, e);
        }
    }
}

