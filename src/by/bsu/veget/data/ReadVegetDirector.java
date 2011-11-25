/**
 *
 */
package by.bsu.veget.data;
import by.bsu.veget.exception.VegetException;
import by.bsu.veget.parsers.AbstractBuilder;

/**
 * @author Stepanov Dmitriy
 */
public class ReadVegetDirector {
    private String filePath;
    private AbstractBuilder builder;

    public ReadVegetDirector(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @throws VegetException
     */

    public void buildVeget(String st) throws VegetException {
          builder = AbstractBuilder.getInstance(st);
          builder.buildVeget(filePath);

    }



}