/**
 *
 */
package by.bsu.veget.enums;

import by.bsu.veget.ierarh.*;

/**
 * @author Stepanov Dmitriy
 */
public enum VegetClassEnum {
    LV(LeafsVeget.class), PV(PumkinVeget.class), RV(RootVeget.class), OV(OnionVeget.class), BV(BeansVeget.class);

    public Class<?> getVegetClass() {
        return vegetClass;
    }

    private final Class vegetClass;

    VegetClassEnum(Class vegetClass) {
        this.vegetClass = vegetClass;
    }
}
