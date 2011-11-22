/**
 *
 */
package by.bsu.veget.data;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.parsers.Analyzer;
import by.bsu.veget.parsers.StAXVegetParser;
import by.bsu.veget.parsers.VegetHandler;
import by.bsu.veget.storage.VegetStorageController;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;

/**
 * @author Stepanov Dmitriy
 */
public class ReadVeget {
    private static final String INIT_VEGET_XML = "initVeget.xml";
    private VegetStorageController vsc = new VegetStorageController();

    /**
     * @throws VegetException
     */
    public void readVegetToProgram(String st) throws VegetException {

        switch (st) {
            case "txt":
                readVegetFromTxt();
                break;
            case "sax":
                readVegetWithSAX();
                break;
            case "stax":
                readVegetWithSTAX();
                break;
            default:
                readVegetWithXerces();
                break;

        }

    }

    private void readVegetWithXerces() throws VegetException {
        try {


            DOMParser parser = new DOMParser();
            parser.parse(INIT_VEGET_XML);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            Analyzer.analyzeVeget(root);

        } catch (SAXException e) {
            String msg = "The mistake of SAX Parser in xerces";
            throw new VegetException(msg, e);
        } catch (IOException e) {
            String msg = "The mistake of I/O stream in xerces analyzing ";
            throw new VegetException(msg, e);
        }
    }


    private void readVegetWithSTAX() throws VegetException {

        try {
            StAXVegetParser parser = new StAXVegetParser();

            InputStream input = null;
            input = new FileInputStream(INIT_VEGET_XML);

            parser.parse(input);
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of initVeget.xml in this directory";
            throw new VegetException(msg, e);
        }

    }

    private void readVegetWithSAX() throws VegetException {

        try {

            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser");

            VegetHandler contentHandler = new VegetHandler();
            reader.setContentHandler(contentHandler);
            reader.parse(INIT_VEGET_XML);
        } catch (SAXException e) {
            String msg = "The mistake of SAX Parser in SAX ";
            throw new VegetException(msg, e);
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of initVeget.xml in this directory";
            throw new VegetException(msg, e);
        } catch (IOException e) {
            String msg = "The mistake of I/O stream in sax analyzing initVeget.xml ";
            throw new VegetException(msg, e);
        }
    }

    private void readVegetFromTxt() throws VegetException {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("listveget.txt"));
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of listvegetables in this directory";
            throw new VegetException(msg, e);
        }

        String record;
        try {
            while ((record = in.readLine()) != null) {
                String[] s = record.split("/");
                VegetableFactory vegf = new VegetableFactory(s);
                vsc.addVeget((Vegetable) vegf.createVeget());

            }
        } catch (IOException e) {
            String msg = "List of Vegetables file uses unknovn format for data";
            throw new VegetException(msg, e);
        }
    }

}