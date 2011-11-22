package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;

public final class PumkinVeget extends Vegetable {
    // cucumber zucchini squash
    private String pumkinUniqParametr;

    /**
     * @param id
     * @param vegetId
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     * @param pumkinUniqParametr
     */
    public PumkinVeget(int id, int vegetId, String produceCountry,
                       GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                       QualityEnum qualityOfVeget, String pumkinUniqParametr) {
        super(id, vegetId, produceCountry, colectDate, weightPerKg, pricePerKg,
                qualityOfVeget);
        this.setPumkinUniqParametr(pumkinUniqParametr);
    }

    /**
     * @param veget
     */
    public PumkinVeget(Vegetable veget, String pumkinUniqParametr) {
        super(veget);
        this.setPumkinUniqParametr(pumkinUniqParametr);
    }

    /**
     * @param pumkinUniqParametr the pumkinUniqParametr to set
     */
    void setPumkinUniqParametr(String pumkinUniqParametr) {
        this.pumkinUniqParametr = pumkinUniqParametr;
    }

    /**
     * @return the pumkinUniqParametr
     */
    public String getPumkinUniqParametr() {
        return pumkinUniqParametr;
    }

}
