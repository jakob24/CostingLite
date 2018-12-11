// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
    private byte[] image;
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    @OneToMany(mappedBy="product")
    private Set<ShipmentProduct> shipmentProduct;
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
     * Access method for image.
     *
     * @return the current value of image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * Setter method for image.
     *
     * @param aImage the new value for image
     */
    public void setImage(byte[] aImage) {
        image = aImage;
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
     * Access method for shipmentProduct.
     *
     * @return the current value of shipmentProduct
     */
    public Set<ShipmentProduct> getShipmentProduct() {
        return shipmentProduct;
    }

    /**
     * Setter method for shipmentProduct.
     *
     * @param aShipmentProduct the new value for shipmentProduct
     */
    public void setShipmentProduct(Set<ShipmentProduct> aShipmentProduct) {
        shipmentProduct = aShipmentProduct;
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
