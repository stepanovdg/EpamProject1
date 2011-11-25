/**
 *
 */
package by.bsu.veget.data;
import by.bsu.veget.parsers.
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.parsers.DomBuilder;
import by.bsu.veget.parsers.StAXBuilder;
import by.bsu.veget.parsers.SaxBuilder;
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
public class ReadVegetDirector {
    private String initVegetXml;
    private String listVegetTxt;
    private VegetStorageController vsc = new VegetStorageController();
    private AbstractBuilder builder;

    public ReadVegetDirector(String initVegetXml, String listVegetTxt) {
        this.initVegetXml = initVegetXml;
        this.listVegetTxt = listVegetTxt;
    }

    /**
     * @throws VegetException
     */

    public void buildVeget(String st) throws VegetException {



    }

    private void readVegetWithDom() throws VegetException {
        try {


            DOMParser parser = new DOMParser();
            parser.parse(initVegetXml);
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            DomBuilder.analyzeVeget(root);

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
            StAXBuilder parser = new StAXBuilder();
            InputStream input = null;
            input = new FileInputStream(initVegetXml);
            parser.parse(input);
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of initVeget.xml in this directory";
            throw new VegetException(msg, e);
        }

    }

    private void readVegetWithSAX() throws VegetException {

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader("com.sun.org.apache.xerces.internal.parsers.SAXParser");
            SaxBuilder contentHandler = new SaxBuilder();
            reader.setContentHandler(contentHandler);
            reader.parse(initVegetXml);
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
            in = new BufferedReader(new FileReader(listVegetTxt));
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