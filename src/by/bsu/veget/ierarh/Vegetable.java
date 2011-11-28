package by.bsu.veget.ierarh;

import by.bsu.veget.enums.QualityEnum;

import java.util.GregorianCalendar;

/**
 * @author Stepanov Dmitriy
 */
@SuppressWarnings({"ALL"})
public abstract class Vegetable implements VegetableIF{
    private int id;
    private int vegetEnumId;
    private String produceCountry;
    private GregorianCalendar colectDate;
    private Double weightPerKg;
    private Double pricePerKg;
    private QualityEnum qualityOfVeget;

    /**
     * @param id
     * @param vegetId
     * @param produceCountry
     * @param colectDate
     * @param weightPerKg
     * @param pricePerKg
     * @param qualityOfVeget
     */
    protected Vegetable(int id, int vegetId, String produceCountry,
                        GregorianCalendar colectDate, Double weightPerKg, Double pricePerKg,
                        QualityEnum qualityOfVeget) {
        this.setId(id);
        this.setVegetEnumId(vegetId);
        this.setProduceCountry(produceCountry);
        this.setColectDate(colectDate);
        this.setWeightPerKg(weightPerKg);
        this.setPricePerKg(pricePerKg);
        this.setQualityOfVeget(qualityOfVeget);
    }

    /**
     */
    protected Vegetable(Vegetable veget) {
        this.setId(veget.getId());
        this.setVegetEnumId(veget.getVegetEnumId());
        this.setProduceCountry(veget.getProduceCountry());
        this.setColectDate(veget.getColectDate());
        this.setWeightPerKg(veget.getWeightPerKg());
        this.setPricePerKg(veget.getPricePerKg());
        this.setQualityOfVeget(veget.getQualityOfVeget());
    }

    @Override
    public int hashCode() {
        int result = 7;
        int hashId = this.getId();
        result = 17 * result + hashId;
        int hashVegEnId = this.getVegetEnumId();
        result = 17 * result + hashVegEnId;
        int hashCountry = this.getProduceCountry().hashCode();
        result = 17 * result + hashCountry;
        int hashDate = this.getColectDate().hashCode();
        result = 17 * result + hashDate;
        long lon = this.getWeightPerKg().longValue();
        int hashWeight = (int) (lon - (lon >>> 32));
        result = 17 * result + hashWeight;
        lon = this.getPricePerKg().longValue();
        int hashPrice = (int) (lon - (lon >>> 32));
        result = 17 * result + hashPrice;
        int hashQual = this.getQualityOfVeget().hashCode();
        result = 17 * result + hashQual;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Vegetable))
            return false;
        Vegetable otherVeg = (Vegetable) obj;
        return (this.getId() == otherVeg.getId());
    }
    /**
     * @return the qualityOfVeget
     */
    public QualityEnum getQualityOfVeget() {
        return qualityOfVeget;
    }

    /**
     * @param qualityOfVeget the qualityOfVeget to set
     */
    protected void setQualityOfVeget(QualityEnum qualityOfVeget) {
        this.qualityOfVeget = qualityOfVeget;
    }

    /**
     * @param id the id to set
     */
    protected void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    protected void setVegetEnumId(int name) {
        this.vegetEnumId = name;
    }

    /**
     * @param produceCountry the produceCountry to set
     */
    protected void setProduceCountry(String produceCountry) {
        this.produceCountry = produceCountry;
    }

    /**
     * @param colectDate the colectDate to set
     */
    protected void setColectDate(GregorianCalendar colectDate) {
        this.colectDate = colectDate;
    }

    /**
     * @param weightPerKg the weightPerKg to set
     */
    protected void setWeightPerKg(Double weightPerKg) {
        this.weightPerKg = weightPerKg;
    }

    /**
     * @param pricePerKg the pricePerKg to set
     */
    protected void setPricePerKg(Double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public int getVegetEnumId() {
        return vegetEnumId;
    }

    /**
     * @return the produceCountry
     */
    public String getProduceCountry() {
        return produceCountry;
    }

    /**
     * @return the colectDate
     */
    public GregorianCalendar getColectDate() {
        return colectDate;
    }

    /**
     * @return the weightPerKg
     */
    public Double getWeightPerKg() {
        return weightPerKg;
    }



    /**
     * @return the pricePerKg
     */
    public Double getPricePerKg() {
        return pricePerKg;
    }
}
