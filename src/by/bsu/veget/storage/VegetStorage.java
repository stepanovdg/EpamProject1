/**
 *
 */
package by.bsu.veget.storage;

import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.out.VegetOutManager;

import java.util.ArrayList;

/**
 * @author Stepanov Dmitriy
 */
public class VegetStorage extends ArrayList<Vegetable> implements
        VegetStorageIF {

    private static final int INDEXOFNULLVEGETABLE = -1;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public VegetStorage() {
        super();
    }

    @Override
    public VegetStorageIF addVeget(Vegetable veget) {

        this.add(veget);
        return this;
    }

    public VegetStorageIF sort(String by) {
        VegetComparators vc = new VegetComparators(this);
        vc.sortBy(by);
        return this;
    }

    @Override
    public VegetStorageIF deleteVeget(int id) {
        int index = searchVeget(id);
        if (index != INDEXOFNULLVEGETABLE) {
            this.remove(index);
        } else
            VegetOutManager.getInstance().println(
                    "There is not such vegetable in storage");
        return this;
    }

    @Override
    public VegetStorageIF changeVeget(int id, Vegetable veget) {
        int index = searchVeget(id);
        if (index != INDEXOFNULLVEGETABLE) {
            this.remove(index);
            this.add(index, veget);
        } else
            VegetOutManager.getInstance().println(
                    "There is not such vegetable in storage");
        return this;

    }

    public int searchVeget(int id) {
        int index = INDEXOFNULLVEGETABLE;
        for (Vegetable veget : this) {
            index++;
            if (veget.getId() == id) {
                return index;
            }
        }
        return INDEXOFNULLVEGETABLE;
    }

    public int searchFirstEnterOfVeget(VegetEnum vegen) {
        int index = INDEXOFNULLVEGETABLE;

        for (Vegetable veget : this) {
            index++;
            if (veget.getVegetEnumId() == vegen.ordinal()) {
                return index;
            }
        }
        return INDEXOFNULLVEGETABLE;
    }




}
