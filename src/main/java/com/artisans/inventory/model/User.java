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
import javax.persistence.OneToMany;

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
    private List<Courier> courier;
    
    @OneToMany(mappedBy="user")
    private List<Invoice> invoice;
    
    @OneToMany(mappedBy="user")
    private List<Payment> payment;
    
    @OneToMany(mappedBy="user")
    private List<Product> product;
    
    @OneToMany(mappedBy="user")
    private List<ShipmentProduct> shipmentProduct;
    
    @OneToMany(mappedBy="user")
    private List<Shipment> shipment;
    
    @OneToMany(mappedBy="user")
    private List<Supplier> supplier;

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
	 * @return the invoice
	 */
	public List<Invoice> getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}

	/**
	 * @return the payment
	 */
	public List<Payment> getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
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
	 * @return the shipment
	 */
	public List<Shipment> getShipment() {
		return shipment;
	}

	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(List<Shipment> shipment) {
		this.shipment = shipment;
	}

	/**
	 * @return the supplier
	 */
	public List<Supplier> getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(List<Supplier> supplier) {
		this.supplier = supplier;
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
