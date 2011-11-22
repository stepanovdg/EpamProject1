/**
 *
 */
package by.bsu.veget.salat;

import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.enums.VegetMethodOfPreparationEnum;
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.storage.VegetStorageController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stepanov Dmitriy
 */
public class VegetProcessorEnvironment implements VegetProcessorEnvironmentIF {

    /*
      * (non-Javadoc)
      *
      *
      *
      *
      * @see by.bsu.task1.vegetsalat.VegetProcessorEnvironmentIF#slice()
      */
    @Override
    public String slice() {
        return "was sliced";

    }

    /*
      * (non-Javadoc)
      *
      * @see by.bsu.task1.vegetsalat.VegetProcessorEnvironmentIF#mix()
      */
    @Override
    public String mix() {
        return "was mixed";

    }

    @Override
    public String fry() {
        return "was fryed";

    }

    @Override
    public String pickle() {
        return "was pickled";

    }

    @Override
    public String steam() {
        return "was steamed";

    }

    public Map<Vegetable, String> makeSalat(FileReader selectedFile)
            throws VegetException {
        Map<Vegetable, String> salat = new HashMap<>();
        BufferedReader in;
        in = new BufferedReader(selectedFile);

        boolean end = false;
        String record;
        do {
            try {
                record = in.readLine();
                if (record == null) {
                    end = true;
                    break;
                }
            } catch (IOException e) {
                String msg = "Recipe file uses unknovn format of data";
                throw new VegetException(msg, e);
            }
            String[] s = record.split("/");
            VegetEnum vegEn;
            try {
                vegEn = VegetEnum.valueOf(s[0]);
            } catch (java.lang.IllegalArgumentException e) {
                String msg = "Recipe file uses unknovn format of data";
                throw new VegetException(msg, e);
            }

            StringBuilder state = new StringBuilder();
            for (int i = 1; i < s.length; i++) {
                state.append(" ");
                switch (VegetMethodOfPreparationEnum.valueOf(s[i])) {
                    case SLICE:
                        state.append(slice());
                        break;
                    case FRY:
                        state.append(fry());
                        break;
                    case MIX:
                        state.append(mix());
                        break;
                    case PICKLE:
                        state.append(pickle());
                        break;
                    case STEAM:
                        state.append(steam());
                        break;
                    default:
                        throw new VegetException("Unknown method of veget preparation",
                                new IllegalArgumentException());
                }
            }
            Vegetable vgn = new VegetStorageController().searchNeedVeget(vegEn);
            salat.put(vgn, state.toString());
        } while (!end);
        return salat;

    }

}
