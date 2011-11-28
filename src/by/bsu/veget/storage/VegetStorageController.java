/**
 *
 */
package by.bsu.veget.storage;

import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.ierarh.Vegetable;

/**
 * @author Stepanov Dmitriy
 */
public class VegetStorageController {
    private VegetStorage vg = VegetStorageSingletone.getInstance()
            .getVegStorage();

    public void addVeget(Vegetable veg) {
        VegetStorageIF vegst = vg.addVeget(veg);
        double deltMass = veg.getWeightPerKg();
        VegetStorageSingletone.getInstance().refresh(deltMass, 0,
                (VegetStorage) vegst);
    }
    public void sortVeget(String sortBy) {
        VegetStorageIF vegst = vg.sort(sortBy);
        VegetStorageSingletone.getInstance().refresh(0, 0,
                (VegetStorage) vegst);
    }

    public void removeVeget(Vegetable veg) {
        VegetStorageIF vegst = vg.deleteVeget(veg.getId());
        double deltMass = veg.getWeightPerKg();
        VegetStorageSingletone.getInstance().refresh(-deltMass, 0,
                (VegetStorage) vegst);
    }

    public void removeVeget(int id) {
        int i = vg.searchVeget(id);
        if (i >= 0 && i < vg.size()) {
            double deltMass = vg.get(i).getWeightPerKg();
            VegetStorageIF vegst = vg.deleteVeget(id);

            VegetStorageSingletone.getInstance().refresh(-deltMass, 0,
                    (VegetStorage) vegst);
        }
    }

    public void changeVeget(int id, Vegetable veget) {

        this.removeVeget(id);
        this.addVeget(veget);
    }


    public Vegetable searchNeedVeget(VegetEnum veg) {
        int index = vg.searchFirstEnterOfVeget(veg);
        Vegetable vgt = null;
        if (index == -1) {

            return vgt;

        } else {
            vgt = vg.get(index);
            removeVeget(index);
        }
        return vgt;

    }

}
