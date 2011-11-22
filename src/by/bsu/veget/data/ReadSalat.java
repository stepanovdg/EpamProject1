/**
 *
 */
package by.bsu.veget.data;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.salat.VegetProcessorEnvironment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * @author Stepanov Dmitriy
 */
public class ReadSalat {
    private VegetProcessorEnvironment veg = new VegetProcessorEnvironment();

    /**
     * @throws VegetException
     */
    public Map<Vegetable, String> readSalatToProgram() throws VegetException {
        Map<Vegetable, String> salat;
        try {
            salat = veg.makeSalat(new FileReader(VegetReceptJFrame.RECIPE_BIN));
        } catch (FileNotFoundException e) {
            String msg = "Don't exist such file of recipe in this directory";
            throw new VegetException(msg, e);
        }
        return salat;


    }

}
