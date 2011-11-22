/**
 *
 */
package by.bsu.veget.storage;

import by.bsu.veget.ierarh.Vegetable;

/**
 * @author Stepanov Dmitriy
 */
public interface VegetStorageIF {
    public VegetStorageIF addVeget(Vegetable veget);

    public VegetStorageIF deleteVeget(int id);

    public VegetStorageIF changeVeget(int id, Vegetable veget);


}
