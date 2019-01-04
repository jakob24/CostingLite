// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="product")
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "productId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id", unique=true, nullable=false, length=10)
    private int productId;
    
    @Column(length=45)
    private String name;
    
    @Column(name="ASIN", length=45)
    private String asin;
    
    @Column(length=10)
    private int inventory;
    
    @Column(name="min_inventory", length=10)
    private int minInventory;
    
    @Column(length=500)
    private String description;
    
    @Column(length=500)
    private String image;
    
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    
    @Column(name="postage_charges", precision=22)
    private Double postageCharges;	
    
    @Column(name="packing_charges", precision=22)
    private Double packingCharges;	
    
    @Column(name="other_charges", precision=22)
    private Double otherCharges;	
    
    @Column(name="web_rrp", precision=22)
    private Double webRrp;	
    
    @Column(name="web_pp_charge", precision=22)
    private Double webPpCharge;	
    
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
    
    @Column(name="ean", length=45)
    private String ean;
                  
    @OneToMany(mappedBy="product")
    private List<ShipmentProduct> shipmentProduct;
    
    @Column(name="sku", length=400)
    private String sku;
    
    @Column(name="cost_price_usd", precision=22)
    private double costPriceUsd;
    
    @Column(name="cost_price_gbp", precision=22)
    private double costPriceGbp;    
    
    @Column(name="inactive_from")
    private Timestamp inactiveFrom;
    
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;

    /** Default constructor. */
    public Product() {
        super();
    }

    /**
     * Access method for productId.
     *
     * @return the current value of productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Setter method for productId.
     *
     * @param aProductId the new value for productId
     */
    public void setProductId(int aProductId) {
        productId = aProductId;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for asin.
     *
     * @return the current value of asin
     */
    public String getAsin() {
        return asin;
    }

    /**
     * Setter method for asin.
     *
     * @param aAsin the new value for asin
     */
    public void setAsin(String aAsin) {
        asin = aAsin;
    }

    /**
     * Access method for inventory.
     *
     * @return the current value of inventory
     */
    public int getInventory() {
        return inventory;
    }

    /**
     * Setter method for inventory.
     *
     * @param aInventory the new value for inventory
     */
    public void setInventory(int aInventory) {
        inventory = aInventory;
    }

    /**
     * Access method for minInventory.
     *
     * @return the current value of minInventory
     */
    public int getMinInventory() {
        return minInventory;
    }

    /**
     * Setter method for minInventory.
     *
     * @param aMinInventory the new value for minInventory
     */
    public void setMinInventory(int aMinInventory) {
        minInventory = aMinInventory;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }
 

    /**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the postageCharges
	 */
	public Double getPostageCharges() {
		return postageCharges;
	}

	/**
	 * @param postageCharges the postageCharges to set
	 */
	public void setPostageCharges(Double postageCharges) {
		this.postageCharges = postageCharges;
	}

	/**
	 * @return the packingCharges
	 */
	public Double getPackingCharges() {
		return packingCharges;
	}

	/**
	 * @param packingCharges the packingCharges to set
	 */
	public void setPackingCharges(Double packingCharges) {
		this.packingCharges = packingCharges;
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
	 * @return the webPpCharge
	 */
	public Double getWebPpCharge() {
		return webPpCharge;
	}

	/**
	 * @param webPpCharge the webPpCharge to set
	 */
	public void setWebPpCharge(Double webPpCharge) {
		this.webPpCharge = webPpCharge;
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
	 * @return the ean
	 */
	public String getEan() {
		return ean;
	}

	/**
	 * @param ean the ean to set
	 */
	public void setEan(String ean) {
		this.ean = ean;
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
	 * @return the shipmentProduct
	 */
	public List<ShipmentProduct> getShipmentProduct() {
		return shipmentProduct;
	}

	/**
	 * @param shipmentProduct the shipmentProduct to set
	 */
	public void setShipmentProduct(List<ShipmentProduct> shipmentProduct) {
		this.shipmentProduct = shipmentProduct;
	}
	
	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
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
	 * @return the inactiveFrom
	 */
	public Timestamp getInactiveFrom() {
		return inactiveFrom;
	}

	/**
	 * @param inactiveFrom the inactiveFrom to set
	 */
	public void setInactiveFrom(Timestamp inactiveFrom) {
		this.inactiveFrom = inactiveFrom;
	}
	
	
	

	/**
	 * @return the costPriceUsd
	 */
	public double getCostPriceUsd() {
		return costPriceUsd;
	}

	/**
	 * @param costPriceUsd the costPriceUsd to set
	 */
	public void setCostPriceUsd(double costPriceUsd) {
		this.costPriceUsd = costPriceUsd;
	}

	/**
	 * @return the costPriceGbp
	 */
	public double getCostPriceGbp() {
		return costPriceGbp;
	}

	/**
	 * @param costPriceGbp the costPriceGbp to set
	 */
	public void setCostPriceGbp(double costPriceGbp) {
		this.costPriceGbp = costPriceGbp;
	}

	/**
     * Compares the key for this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Product and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product that = (Product) other;
        if (this.getProductId() != that.getProductId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Product.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Product)) return false;
        return this.equalKeys(other) && ((Product)other).equalKeys(this);
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
        i = getProductId();
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
        StringBuffer sb = new StringBuffer("[Product |");
        sb.append(" productId=").append(getProductId());
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
        ret.put("productId", Integer.valueOf(getProductId()));
        return ret;
    }

}
