// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="shipment_product")
public class ShipmentProduct implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "shipmentProductId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="shipment_product_id", unique=true, nullable=false, length=10)
    private int shipmentProductId;
    
    private Date date;
    
    @Column(name="cost_price_usd", precision=22)
    private double costPriceUsd;
    
    @Column(name="cost_price_gbp", precision=22)
    private double costPriceGbp;
    
    @Column(name="landing_cost_gbp", precision=22)
    private double landingCostGbp;
    
    @Column(name="product_qty", length=10)
    private int productQty;
    
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    
    @ManyToOne
    @JoinColumn(name="product")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name="shipment")
    private Shipment shipment;
    
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;

    /** Default constructor. */
    public ShipmentProduct() {
        super();
    }

    /**
     * Access method for shipmentProductId.
     *
     * @return the current value of shipmentProductId
     */
    public int getShipmentProductId() {
        return shipmentProductId;
    }

    /**
     * Setter method for shipmentProductId.
     *
     * @param aShipmentProductId the new value for shipmentProductId
     */
    public void setShipmentProductId(int aShipmentProductId) {
        shipmentProductId = aShipmentProductId;
    }

    /**
     * Access method for date.
     *
     * @return the current value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    public void setDate(Date aDate) {
        date = aDate;
    }

    /**
     * Access method for costPriceUsd.
     *
     * @return the current value of costPriceUsd
     */
    public double getCostPriceUsd() {
        return costPriceUsd;
    }

    /**
     * Setter method for costPriceUsd.
     *
     * @param aCostPriceUsd the new value for costPriceUsd
     */
    public void setCostPriceUsd(double aCostPriceUsd) {
        costPriceUsd = aCostPriceUsd;
    }

    /**
     * Access method for costPriceGbp.
     *
     * @return the current value of costPriceGbp
     */
    public double getCostPriceGbp() {
        return costPriceGbp;
    }

    /**
     * Setter method for costPriceGbp.
     *
     * @param aCostPriceGbp the new value for costPriceGbp
     */
    public void setCostPriceGbp(double aCostPriceGbp) {
        costPriceGbp = aCostPriceGbp;
    }

    /**
     * Access method for landingCostGbp.
     *
     * @return the current value of landingCostGbp
     */
    public double getLandingCostGbp() {
        return landingCostGbp;
    }

    /**
     * Setter method for landingCostGbp.
     *
     * @param aLandingCostGbp the new value for landingCostGbp
     */
    public void setLandingCostGbp(double aLandingCostGbp) {
        landingCostGbp = aLandingCostGbp;
    }

    /**
     * Access method for productQty.
     *
     * @return the current value of productQty
     */
    public int getProductQty() {
        return productQty;
    }

    /**
     * Setter method for productQty.
     *
     * @param aProductQty the new value for productQty
     */
    public void setProductQty(int aProductQty) {
        productQty = aProductQty;
    }

    /**
     * Access method for modifiedOn.
     *
     * @return the current value of modifiedOn
     */
    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    /**
     * Setter method for modifiedOn.
     *
     * @param aModifiedOn the new value for modifiedOn
     */
    public void setModifiedOn(Timestamp aModifiedOn) {
        modifiedOn = aModifiedOn;
    }

    /**
     * Access method for product.
     *
     * @return the current value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Setter method for product.
     *
     * @param aProduct the new value for product
     */
    public void setProduct(Product aProduct) {
        product = aProduct;
    }

    /**
     * Access method for shipment.
     *
     * @return the current value of shipment
     */
    public Shipment getShipment() {
        return shipment;
    }

    /**
     * Setter method for shipment.
     *
     * @param aShipment the new value for shipment
     */
    public void setShipment(Shipment aShipment) {
        shipment = aShipment;
    }

    /**
     * Access method for user.
     *
     * @return the current value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter method for user.
     *
     * @param aUser the new value for user
     */
    public void setUser(User aUser) {
        user = aUser;
    }

    /**
     * Compares the key for this instance with another ShipmentProduct.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ShipmentProduct and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ShipmentProduct)) {
            return false;
        }
        ShipmentProduct that = (ShipmentProduct) other;
        if (this.getShipmentProductId() != that.getShipmentProductId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ShipmentProduct.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ShipmentProduct)) return false;
        return this.equalKeys(other) && ((ShipmentProduct)other).equalKeys(this);
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
        i = getShipmentProductId();
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
        StringBuffer sb = new StringBuffer("[ShipmentProduct |");
        sb.append(" shipmentProductId=").append(getShipmentProductId());
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
        ret.put("shipmentProductId", Integer.valueOf(getShipmentProductId()));
        return ret;
    }

}
