package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.init.VegetableFactory;
import by.bsu.veget.storage.VegetStorageController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 25.11.11
 * Time: 21:37
 *
 */
public class TxtBuilder extends AbstractBuilder {
    private VegetStorageController vsc = new VegetStorageController();
    @Override
    public void buildVeget(String filePath) throws VegetException {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(filePath));
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
