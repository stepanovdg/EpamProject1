package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.out.VegetOutManager;
import by.bsu.veget.storage.VegetStorageController;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 19.11.11
 * Time: 16:27
 */
public class VegetHandler implements ContentHandler {
    private VegetStorageController vsc = new VegetStorageController();
    private String[] s;
    private String currentElement;


    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (qName.equals("vegetable")) {

            s = new String[9];
            s[0] = atts.getValue(0);
        } else {
            currentElement = qName;
        }



        //получение и вывод информации об атрибутах элемента


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
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
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentElement != null) {
            switch (currentElement) {
                case "uid":
                    break;
                case "country":
                    if (s[1] == null) {
                        s[1] = new String(ch, start, length);
                    }
                    break;
                case "year":
                    if (s[2] == null) {
                        s[2] = new String(ch, start, length);
                    }
                    break;
                case "month":
                    if (s[3] == null) {
                        s[3] = new String(ch, start, length).replace("-","");
                    }
                    break;
                case "day":
                    if (s[4] == null) {
                        s[4] = new String(ch, start, length).replace("-","");
                    }
                    break;
                case "weight-per-kg":
                    if (s[5] == null) {
                        s[5] = new String(ch, start, length);
                    }
                    break;
                case "price-per-kg":
                    if (s[6] == null) {
                        s[6] = new String(ch, start, length);
                    }
                    break;
                case "quality-of-veget":
                    if (s[7] == null) {
                        s[7] = new String(ch, start, length);
                    }
                    break;
                case "uniq-parameter":
                    if (s != null && s[8] == null) {
                        s[8] = new String(ch, start, length);

                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
