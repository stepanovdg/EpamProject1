/**
 *
 */
package by.bsu.veget.init;

import by.bsu.veget.enums.QualityEnum;
import by.bsu.veget.enums.VegetClassEnum;
import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.*;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;


/**
 * @author Stepanov Dmitriy
 */
public class VegetableFactory implements VegetableFactoryIF {
    public final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static int vegIdCounter = 0;
    private String[] input;
    private VegetEnum vegEnum;

    public VegetableFactory(String... in) throws IllegalArgumentException,
            VegetException {
        try {
            if (in != null) {
                vegEnum = VegetEnum.valueOf(in[0].toUpperCase());
                vegIdCounter++;
            }
        } catch (IllegalArgumentException e) {
            String msg = "Unknown Vegetable type in vegetFactory: " + in[0];
            throw new VegetException(msg, e);
        }

        input = in;
    }

    @Override
    public VegetableIF createVeget() throws VegetException {
        Vegetable veget;
        try {


            veget = new Vegetable(vegIdCounter, vegEnum.ordinal(),
                    input[1], new GregorianCalendar(new Integer(input[2]),
                    new Integer(input[3]), new Integer(input[4])),
                    new Double(input[5]), new Double(input[6]),
                    QualityEnum.valueOf(input[7].toUpperCase())) {

            };
        } catch (java.lang.NumberFormatException e) {
            String msg = "Unknown Vegetable Constructor: " + vegEnum;
            throw new VegetException(msg, e);
        }
        switch (VegetClassEnum.valueOf(vegEnum.vegetKind())) {
            case LV:
                return constructListVeget(veget, new Integer(input[8]));
            case BV:
                return constructBeansVeget(veget, input[8]);
            case OV:
                return constructOnionVeget(veget, input[8]);
            case RV:
                return constructRootVeget(veget, new Double(input[8]));
            case PV:
                return constructPumkinVeget(veget, input[8]);
            default:
                String msg = "Unknown Vegetable Constructor: " + vegEnum;
                throw new IllegalArgumentException(msg);
        }
        /*
           * if (LISTVEGETABLE.equals(vegEnum.vegetKind())) { return
           * constructListVeget(veget, new Integer(input[6])); } else if
           * (BEANSVEGETABLE.equals(vegEnum.vegetKind())) { return
           * constructBeansVeget(veget, input[6]); } else if
           * (ONIONVEGETABLE.equals(vegEnum.vegetKind())) { return
           * constructOnionVeget(veget, input[6]); } else if
           * (PUMPKINVEGETABLE.equals(vegEnum.vegetKind())) { return
           * constructPumkinVeget(veget, input[6]); } else if
           * (ROOTVEGETABLE.equals(vegEnum.vegetKind())) { return
           * constructRootVeget(veget, new Double(input[6])); } else { String msg
           * = "Unknown Vegetable Constructor: " + vegEnum; throw new
           * IllegalArgumentException(msg); }
           */

    }

    private LeafsVeget constructListVeget(Vegetable veget, int listUniqParametr)
            throws NoSuchElementException {
        return new LeafsVeget(veget, listUniqParametr);

    }

    private BeansVeget constructBeansVeget(Vegetable veget,
                                           String beansUniqParametr) {
        return new BeansVeget(veget, beansUniqParametr);

    }

    private OnionVeget constructOnionVeget(Vegetable veget,
                                           String onionUniqParametr) {
        return new OnionVeget(veget, onionUniqParametr);

    }

    private RootVeget constructRootVeget(Vegetable veget,
                                         double rootUniqParametr) {
        return new RootVeget(veget, rootUniqParametr);

    }

    private PumkinVeget constructPumkinVeget(Vegetable veget,
                                             String pumkinUniqParametr) {
        return new PumkinVeget(veget, pumkinUniqParametr);

    }

}
