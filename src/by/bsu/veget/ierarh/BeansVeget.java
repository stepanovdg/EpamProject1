package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;


public final class BeansVeget extends Vegetable {
    private String beansUniqParametr;

    /**
     * @param id
     * @param vegetId
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     * @param beansUniqParametr
     */
    public BeansVeget(int id, int vegetId, String produceCountry,
                      GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                      QualityEnum qualityOfVeget, String beansUniqParametr) {
        super(id, vegetId, produceCountry, colectDate, weightPerKg, pricePerKg,
                qualityOfVeget);

        setBeansUniqParametr(beansUniqParametr);
    }

    /**
     * @param beansUniqParametr
     */
    public BeansVeget(Vegetable veg, String beansUniqParametr) {
        super(veg);

        this.beansUniqParametr = beansUniqParametr;
    }

    //  pea


    /**
     * @param beansUniqParametr the beansUniqParametr to set
     */
    void setBeansUniqParametr(String beansUniqParametr) {
        this.beansUniqParametr = beansUniqParametr;
    }

    /**
     * @return the beansUniqParametr
     */
    public String getBeansUniqParametr() {
        return beansUniqParametr;
    }

}
