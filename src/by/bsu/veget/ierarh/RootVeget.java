package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;

public final class RootVeget extends Vegetable {
    //  potatoes carrots beets
    private Double rootUniqParametr;

    /**
     * @param id
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     * @param rootUniqParametr
     */
    public RootVeget(int id, int vegetId, String produceCountry,
                     GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                     QualityEnum qualityOfVeget, Double rootUniqParametr) {
        super(id, vegetId, produceCountry, colectDate, weightPerKg, pricePerKg,
                qualityOfVeget);
        this.setRootUniqParametr(rootUniqParametr);
    }

    /**
     * @param veget
     */
    public RootVeget(Vegetable veget, Double rootUniqParametr) {
        super(veget);
        this.setRootUniqParametr(rootUniqParametr);
    }

    /**
     * @param rootUniqParametr the rootUniqParametr to set
     */
    void setRootUniqParametr(Double rootUniqParametr) {
        this.rootUniqParametr = rootUniqParametr;
    }

    /**
     * @return the rootUniqParametr
     */
    public Double getRootUniqParametr() {
        return rootUniqParametr;
    }

}
