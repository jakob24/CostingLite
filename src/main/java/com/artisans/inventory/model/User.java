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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="user")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "userId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", unique=true, nullable=false, length=10)
    private int userId;
    @Column(length=45)    
    private String username;
    
    @Column(name="modified_by", length=10)    
    private int modifiedBy;
    
    @Column(name="modified_on")    
    private Timestamp modifiedOn;
    
    @Column(length=3)
    private short admin;
    
    @OneToMany(mappedBy="user")
    private Set<Courier> courier;
    
    @OneToMany(mappedBy="user")
    private Set<Invoice> invoice;
    
    @OneToMany(mappedBy="user")
    private Set<Payments> payments;
    
    @OneToMany(mappedBy="user")
    private Set<Product> product;
    
    @OneToMany(mappedBy="user")
    private Set<ShipmentProduct> shipmentProduct;
    
    @OneToMany(mappedBy="user")
    private Set<Shipment> shipment;
    
    @OneToMany(mappedBy="user")
    private Set<Supplier> supplier;

    /** Default constructor. */
    public User() {
        super();
    }
    
    /** Default constructor. */
    public User(String userName) {
        setUsername(userName);
    }    

    /**
     * Access method for userId.
     *
     * @return the current value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter method for userId.
     *
     * @param aUserId the new value for userId
     */
    public void setUserId(int aUserId) {
        userId = aUserId;
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for modifiedBy.
     *
     * @return the current value of modifiedBy
     */
    public int getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Setter method for modifiedBy.
     *
     * @param aModifiedBy the new value for modifiedBy
     */
    public void setModifiedBy(int aModifiedBy) {
        modifiedBy = aModifiedBy;
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
     * Access method for admin.
     *
     * @return the current value of admin
     */
    public short getAdmin() {
        return admin;
    }

    /**
     * Setter method for admin.
     *
     * @param aAdmin the new value for admin
     */
    public void setAdmin(short aAdmin) {
        admin = aAdmin;
    }

    /**
     * Access method for courier.
     *
     * @return the current value of courier
     */
    @JsonIgnore
    public Set<Courier> getCourier() {
        return courier;
    }

    /**
     * Setter method for courier.
     *
     * @param aCourier the new value for courier
     */
    public void setCourier(Set<Courier> aCourier) {
        courier = aCourier;
    }

    /**
     * Access method for invoice.
     *
     * @return the current value of invoice
     */
    @JsonIgnore
    public Set<Invoice> getInvoice() {
        return invoice;
    }

    /**
     * Setter method for invoice.
     *
     * @param aInvoice the new value for invoice
     */
    public void setInvoice(Set<Invoice> aInvoice) {
        invoice = aInvoice;
    }

    /**
     * Access method for payments.
     *
     * @return the current value of payments
     */
    @JsonIgnore
    public Set<Payments> getPayments() {
        return payments;
    }

    /**
     * Setter method for payments.
     *
     * @param aPayments the new value for payments
     */
    public void setPayments(Set<Payments> aPayments) {
        payments = aPayments;
    }

    /**
     * Access method for product.
     *
     * @return the current value of product
     */
    @JsonIgnore
    public Set<Product> getProduct() {
        return product;
    }

    /**
     * Setter method for product.
     *
     * @param aProduct the new value for product
     */
    public void setProduct(Set<Product> aProduct) {
        product = aProduct;
    }

    /**
     * Access method for shipmentProduct.
     *
     * @return the current value of shipmentProduct
     */
    @JsonIgnore
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
     * Access method for shipment.
     *
     * @return the current value of shipment
     */
    @JsonIgnore
    public Set<Shipment> getShipment() {
        return shipment;
    }

    /**
     * Setter method for shipment.
     *
     * @param aShipment the new value for shipment
     */
    public void setShipment(Set<Shipment> aShipment) {
        shipment = aShipment;
    }

    /**
     * Access method for supplier.
     *
     * @return the current value of supplier
     */
    @JsonIgnore
    public Set<Supplier> getSupplier() {
        return supplier;
    }

    /**
     * Setter method for supplier.
     *
     * @param aSupplier the new value for supplier
     */
    public void setSupplier(Set<Supplier> aSupplier) {
        supplier = aSupplier;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        if (this.getUserId() != that.getUserId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
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
        i = getUserId();
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
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" userId=").append(getUserId());
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
        ret.put("userId", Integer.valueOf(getUserId()));
        return ret;
    }

}
