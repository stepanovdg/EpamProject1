package by.bsu.veget.storage;

/**
 * @author Stepanov Dmitriy
 */
@SuppressWarnings({"ALL"})
public final class VegetStorageSingletone {
    private static final double BEGINNINGFREESPACE = 50.;
    private static final double BEGINNINGTEMPERATURE = 4.;
    private double freeSpace;
    private double storageTemperature;
    private VegetStorage vegStorage;
    private static VegetStorageSingletone instance = new VegetStorageSingletone();

    public void refresh(double deltaFreeSpace, double deltaStorageTemperature,
                        VegetStorage vegetStorage) {
        setInstance(new VegetStorageSingletone(getFreeSpace() - deltaFreeSpace,
                (getStorageTemperature() + deltaStorageTemperature),
                vegetStorage));
    }

    /**
     *
     */
    private VegetStorageSingletone() {
        setFreeSpace(BEGINNINGFREESPACE);
        setStorageTemperature(BEGINNINGTEMPERATURE);
        vegStorage = new VegetStorage();
    }

    private VegetStorageSingletone(double freeSpace, double storageTemperature,
                                   VegetStorage vegStorage) {
        setFreeSpace(freeSpace);
        setStorageTemperature(storageTemperature);
        setVegStorage(vegStorage);
    }

    /**
     * @return the instance
     */
    public static VegetStorageSingletone getInstance() {
        return instance;
    }

    /**
     * @param instance the instance to set
     */
    private static void setInstance(VegetStorageSingletone instance) {
        VegetStorageSingletone.instance = instance;
    }

    /**
     * @return the freeSpacePerKg
     */
    public double getFreeSpace() {
        return freeSpace;
    }

    /**
     * @return the storageTemperature
     */
    public double getStorageTemperature() {
        return storageTemperature;
    }

    /**
     * @return the vegStorage
     */
    public VegetStorage getVegStorage() {
        return vegStorage;
    }

    /**
     */
    private void setFreeSpace(double freeSpace) {
        this.freeSpace = freeSpace;
    }

    /**
     * @param storageTemperature the storageTemperature to set
     */
    private void setStorageTemperature(double storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    /**
     * @param vegStorage the vegStorage to set
     */
    private void setVegStorage(VegetStorage vegStorage) {
        this.vegStorage = vegStorage;
    }

}
