package by.bsu.veget.parsers;

import by.bsu.veget.exception.VegetException;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 25.11.11
 * Time: 21:51
 */
public abstract class AbstractBuilder {
    public static AbstractBuilder getInstance(String st) {
        switch (st) {
            case "txt":
                return new TxtBuilder();
            case "sax":
                return new SaxBuilder();
            case "stax":
                return new StAXBuilder();
            default:
                return new DomBuilder();
        }
    }

    public abstract void buildVeget(String filePath) throws VegetException;
}
