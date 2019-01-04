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
        
    @Column(name="other_charges", precision=22)
    private Double otherCharges;	
    
    @Column(name="web_rrp", precision=22)
    private Double webRrp;	
    
    @Column(name="ebay_rrp", precision=22)
    private Double ebayRrp;		
    
    @Column(name="ebay_fees", precision=22)
    private Double ebayFees;	
    
    @Column(name="amz_rrp", precision=22)
    private Double amzRrp;	
    
    @Column(name="amz_fees", precision=22)
    private Double amzFees;		
    
    @Column(name="amz_fba_fees", precision=22)
    private Double amzFbaFees;    
        
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
	 * @return the otherCharges
	 */
	public Double getOtherCharges() {
		return otherCharges;
	}

	/**
	 * @param otherCharges the otherCharges to set
	 */
	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}

	/**
	 * @return the webRrp
	 */
	public Double getWebRrp() {
		return webRrp;
	}

	/**
	 * @param webRrp the webRrp to set
	 */
	public void setWebRrp(Double webRrp) {
		this.webRrp = webRrp;
	}

	/**
	 * @return the ebayRrp
	 */
	public Double getEbayRrp() {
		return ebayRrp;
	}

	/**
	 * @param ebayRrp the ebayRrp to set
	 */
	public void setEbayRrp(Double ebayRrp) {
		this.ebayRrp = ebayRrp;
	}

	/**
	 * @return the ebayFees
	 */
	public Double getEbayFees() {
		return ebayFees;
	}

	/**
	 * @param ebayFees the ebayFees to set
	 */
	public void setEbayFees(Double ebayFees) {
		this.ebayFees = ebayFees;
	}

	/**
	 * @return the amzRrp
	 */
	public Double getAmzRrp() {
		return amzRrp;
	}

	/**
	 * @param amzRrp the amzRrp to set
	 */
	public void setAmzRrp(Double amzRrp) {
		this.amzRrp = amzRrp;
	}

	/**
	 * @return the amzFees
	 */
	public Double getAmzFees() {
		return amzFees;
	}

	/**
	 * @param amzFees the amzFees to set
	 */
	public void setAmzFees(Double amzFees) {
		this.amzFees = amzFees;
	}

	/**
	 * @return the amzFbaFees
	 */
	public Double getAmzFbaFees() {
		return amzFbaFees;
	}

	/**
	 * @param amzFbaFees the amzFbaFees to set
	 */
	public void setAmzFbaFees(Double amzFbaFees) {
		this.amzFbaFees = amzFbaFees;
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
