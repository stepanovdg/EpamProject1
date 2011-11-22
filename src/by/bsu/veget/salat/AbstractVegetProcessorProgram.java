/**
 *
 */
package by.bsu.veget.salat;

/**
 * @author Stepanov Dmitriy
 */
public abstract class AbstractVegetProcessorProgram {
    private VegetProcessorEnvironmentIF environment;

    public void setEnvironment(VegetProcessorEnvironmentIF environment) {
        this.environment = environment;

    }

    /**
     * @return the environment
     */
    protected VegetProcessorEnvironmentIF getEnvironment() {
        return environment;
    }

    public abstract String getName();

    public abstract void start();

}
