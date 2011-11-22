package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.storage.VegetStorageController;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 19.11.11
 * Time: 21:00
 */
public class Analyzer {

    private static VegetStorageController vsc = new VegetStorageController();


    public static void analyzeVeget(Element root) throws VegetException {
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

            s[5] = getBabyValue(vegetElement, ("weightPerKg"));
            s[6] = getBabyValue(vegetElement, ("pricePerKg"));
            s[7] = getBabyValue(vegetElement, ("qualityOfVeget"));
            s[8] = getBabyValue(vegetElement, ("uniqParameter"));
            VegetableFactory vegf = new VegetableFactory(s);
            vsc.addVeget((Vegetable) vegf.createVeget());

        }
    }


    private static Element getBaby(Element parent, String childName) {
        NodeList nlist =
                parent.getElementsByTagName(childName);
        return (Element) nlist.item(0);
    }


    private static String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        return node.getNodeValue();
    }


}
