package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;


public final class LeafsVeget extends Vegetable {
    private int listUniqParametr;

    /**
     * @param id
     * @param vegetId
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     */
    public LeafsVeget(int id, int vegetId, String produceCountry,
                      GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                      QualityEnum qualityOfVeget, int listUniqParametr) {
        super(id, vegetId, produceCountry, colectDate, weightPerKg, pricePerKg,
                qualityOfVeget);
        setListUniqParametr(listUniqParametr);
    }

    /**
     * @param veget
     */
    public LeafsVeget(Vegetable veget, int listUniqParametr) {
        super(veget);
        setListUniqParametr(listUniqParametr);
    }

    /**
     * @param listUniqParametr the listUniqParametr to set
     */
    void setListUniqParametr(int listUniqParametr) {
        this.listUniqParametr = listUniqParametr;
    }

    /**
     * @return the listUniqParametr
     */
    public int getListUniqParametr() {
        return listUniqParametr;
    }

    // cabbage dill mint


}
