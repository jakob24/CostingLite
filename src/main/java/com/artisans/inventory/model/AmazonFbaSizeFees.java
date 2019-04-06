// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="amazon_fba_size_fees")
public class AmazonFbaSizeFees implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "amazonFbaSizeFeesId";

    @Id
    @Column(name="amazon_fba_size_fees_id", unique=true, nullable=false, length=10)
    private int amazonFbaSizeFeesId;
    
    @Column(length=100)
    private String size;
    
    @Column(name="uk_fees", precision=22)
    private double ukFees;
    
    @Column(name="de_fees", precision=22)
    private double deFees;
    
    @Column(name="fr_fees", precision=22)
    private double frFees;

    /** Default constructor. */
    public AmazonFbaSizeFees() {
        super();
    }

    /**
     * Access method for amazonFbaSizeFeesId.
     *
     * @return the current value of amazonFbaSizeFeesId
     */
    public int getAmazonFbaSizeFeesId() {
        return amazonFbaSizeFeesId;
    }

    /**
     * Setter method for amazonFbaSizeFeesId.
     *
     * @param aAmazonFbaSizeFeesId the new value for amazonFbaSizeFeesId
     */
    public void setAmazonFbaSizeFeesId(int aAmazonFbaSizeFeesId) {
        amazonFbaSizeFeesId = aAmazonFbaSizeFeesId;
    }

    /**
     * Access method for size.
     *
     * @return the current value of size
     */
    public String getSize() {
        return size;
    }

    /**
     * Setter method for size.
     *
     * @param aSize the new value for size
     */
    public void setSize(String aSize) {
        size = aSize;
    }

    /**
     * Access method for ukFees.
     *
     * @return the current value of ukFees
     */
    public double getUkFees() {
        return ukFees;
    }

    /**
     * Setter method for ukFees.
     *
     * @param aUkFees the new value for ukFees
     */
    public void setUkFees(double aUkFees) {
        ukFees = aUkFees;
    }

    /**
     * Access method for deFees.
     *
     * @return the current value of deFees
     */
    public double getDeFees() {
        return deFees;
    }

    /**
     * Setter method for deFees.
     *
     * @param aDeFees the new value for deFees
     */
    public void setDeFees(double aDeFees) {
        deFees = aDeFees;
    }

    /**
     * Access method for frFees.
     *
     * @return the current value of frFees
     */
    public double getFrFees() {
        return frFees;
    }

    /**
     * Setter method for frFees.
     *
     * @param aFrFees the new value for frFees
     */
    public void setFrFees(double aFrFees) {
        frFees = aFrFees;
    }

    /**
     * Compares the key for this instance with another AmazonFbaSizeFees.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class AmazonFbaSizeFees and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof AmazonFbaSizeFees)) {
            return false;
        }
        AmazonFbaSizeFees that = (AmazonFbaSizeFees) other;
        if (this.getAmazonFbaSizeFeesId() != that.getAmazonFbaSizeFeesId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another AmazonFbaSizeFees.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AmazonFbaSizeFees)) return false;
        return this.equalKeys(other) && ((AmazonFbaSizeFees)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getAmazonFbaSizeFeesId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[AmazonFbaSizeFees |");
        sb.append(" amazonFbaSizeFeesId=").append(getAmazonFbaSizeFeesId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("amazonFbaSizeFeesId", Integer.valueOf(getAmazonFbaSizeFeesId()));
        return ret;
    }

}
