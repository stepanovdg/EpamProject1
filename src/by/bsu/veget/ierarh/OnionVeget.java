package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;

public final class OnionVeget extends Vegetable {
    // onion garlic asparagus
    private String onionUniqParametr;

    /**
     * @param id
     * @param vegetId
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     * @param onionUniqParametr
     */
    public OnionVeget(int id, int vegetId, String produceCountry,
                      GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                      QualityEnum qualityOfVeget, String onionUniqParametr) {
        super(id, vegetId, produceCountry, colectDate, weightPerKg, pricePerKg,
                qualityOfVeget);
        this.setOnionUniqParametr(onionUniqParametr);
    }

    /**
     * @param veget
     */
    public OnionVeget(Vegetable veget, String onionUniqParametr) {
        super(veget);
        this.setOnionUniqParametr(onionUniqParametr);
    }

    /**
     * @param onionUniqParametr the onionUniqParametr to set
     */
    void setOnionUniqParametr(String onionUniqParametr) {
        this.onionUniqParametr = onionUniqParametr;
    }

    /**
     * @return the onionUniqParametr
     */
    public String getOnionUniqParametr() {
        return onionUniqParametr;
    }


}
