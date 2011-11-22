/**
 *
 */
package by.bsu.veget.salat;

/**
 * @author Stepanov Dmitriy
 */
public interface VegetProcessorEnvironmentIF {
    /**
     * Slicing or cutting vegetables
     *
     * @return
     */
    public String slice();

    /**
     * Mixing vegetables
     *
     * @return
     */
    public String mix();

    /**
     * Frying vegetables for certain time
     *
     * @return
     */
    public String fry();

    /**
     * Pickling vegetables for certain time
     *
     * @return
     */
    public String pickle();

    /**
     * Steaming vegetables for certain time
     *
     * @return
     */


    public String steam();

}
