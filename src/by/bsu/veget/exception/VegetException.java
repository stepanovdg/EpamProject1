/**
 *
 */
package by.bsu.veget.exception;

import by.bsu.veget.out.VegetOutManager;

/**
 * @author Stepanov Dmitriy
 */

public class VegetException extends Exception {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */

    public VegetException(String msg, Exception e) {
        VegetOutManager.getInstance().println(e + " " + msg);
    }

}
