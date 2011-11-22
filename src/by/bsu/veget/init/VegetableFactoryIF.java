/**
 *
 */
package by.bsu.veget.init;

import by.bsu.veget.exception.VegetException;
import by.bsu.veget.ierarh.VegetableIF;

/**
 * @author Stepanov Dmitriy
 */
public interface VegetableFactoryIF {


    public VegetableIF createVeget() throws VegetException;

}
