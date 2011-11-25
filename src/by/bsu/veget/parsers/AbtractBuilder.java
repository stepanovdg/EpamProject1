package by.bsu.veget.parsers;

/**
 * Created by IntelliJ IDEA.
 * User: Stepanov Dmitriy
 * Date: 25.11.11
 * Time: 21:51
 *
 */
abstract class AbstractBuilder {
    static AbstractBuilder getInstance(String st){
           switch (st) {
            case "txt":
                return new TxtBuilder();
            case "sax":
                return new SaxBuilder();
            case "stax":
                return new StAXBuilder();
            default:
                return new DomBuilder();
        }
    }
    abstract void buildVeget();
}
