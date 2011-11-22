/**
 *
 */
package by.bsu.veget.reports;

import by.bsu.veget.enums.VegetEnum;
import by.bsu.veget.ierarh.Vegetable;
import by.bsu.veget.out.VegetOutManager;
import by.bsu.veget.storage.VegetStorage;
import by.bsu.veget.storage.VegetStorageSingletone;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Stepanov Dmitriy
 */
public class VegetStorageReport {

    private VegetStorage vglist = VegetStorageSingletone.getInstance()
            .getVegStorage();


    public void oneVeget(Vegetable veget, Boolean... bs) {
        Boolean[] bsl = new Boolean[7];

        if (bs.length == 0) {

            Arrays.fill(bsl, true);
        } else {
            bsl = Arrays.copyOf(bs, 7);
            Arrays.fill(bsl, bs.length, bsl.length, false);

        }
        if (bsl[0])
            VegetOutManager.getInstance().print(veget.getId() + " ");
        if (bsl[6])
            VegetOutManager.getInstance()
                    .print(veget.getProduceCountry() + " ");
        if (bsl[2])
            VegetOutManager.getInstance().print(
                    veget.getColectDate().getTime() + " ");
        if (bsl[3])
            VegetOutManager.getInstance().print(veget.getPricePerKg() + " ");
        if (bsl[4])
            VegetOutManager.getInstance().print(veget.getWeightPerKg() + " ");
        if (bsl[5])
            VegetOutManager.getInstance()
                    .print(veget.getQualityOfVeget() + " ");
        if (bsl[1])
            VegetOutManager.getInstance().print(
                    VegetEnum.values()[veget.getVegetEnumId()] + " ");
    }

    public void allVeget(Boolean... bs) {
        VegetOutManager.getInstance().println("Storage statistic: ");
        for (Vegetable veget : vglist) {

            oneVeget(veget, bs);
            VegetOutManager.getInstance().println();

        }

    }

    public void allSalatVeget(Map<Vegetable, String> salat, Boolean... bs) {
        VegetOutManager.getInstance().println("Salat ingridients: ");
        for (Vegetable veget : salat.keySet()) {
            oneVeget(veget, bs);
            VegetOutManager.getInstance().println(salat.get(veget));

        }

    }

    public void freeSpace() {
        VegetOutManager.getInstance().println("Storage freespace: ");
        double fs = VegetStorageSingletone.getInstance().getFreeSpace();
        VegetOutManager.getInstance().println(fs);

    }
}
