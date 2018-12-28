// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="shipment")
public class Shipment implements Serializable, Comparable<Shipment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "shipmentId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="shipment_id", unique=true, nullable=false, length=10)
    private int shipmentId;
    
    @Column(length=2)
    private int shipmentNumber;
    
    @Column(name="shipment_date")
    private Date shipmentDate;
    
    @Column(name="tracking_number", length=45)
    private String trackingNumber;
    
    @Column(name="delivery_date")
    private Date deliveryDate;
    
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    
    @ManyToOne
    @JoinColumn(name="courier")
    private Courier courier;
    
    @ManyToOne
    @JoinColumn(name="invoice")
    private Invoice invoice;
    
    @OneToMany(mappedBy="shipment")
    private List<ShipmentProduct> shipmentProduct;
    
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;
    
    @OneToMany(mappedBy="shipment")
    private List<Payment> payment;
            

    /** Default constructor. */
    public Shipment() {
        super();
    }

    /**
     * Access method for shipmentId.
     *
     * @return the current value of shipmentId
     */
    public int getShipmentId() {
        return shipmentId;
    }

    /**
     * Setter method for shipmentId.
     *
     * @param aShipmentId the new value for shipmentId
     */
    public void setShipmentId(int aShipmentId) {
        shipmentId = aShipmentId;
    }

    /**
     * Access method for shipmentDate.
     *
     * @return the current value of shipmentDate
     */
    public Date getShipmentDate() {
        return shipmentDate;
    }

    /**
     * Setter method for shipmentDate.
     *
     * @param aShipmentDate the new value for shipmentDate
     */
    public void setShipmentDate(Date aShipmentDate) {
        shipmentDate = aShipmentDate;
    }



    /**
     * Access method for trackingNumber.
     *
     * @return the current value of trackingNumber
     */
    public String getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Setter method for trackingNumber.
     *
     * @param aTrackingNumber the new value for trackingNumber
     */
    public void setTrackingNumber(String aTrackingNumber) {
        trackingNumber = aTrackingNumber;
    }

    /**
     * Access method for deliveryDate.
     *
     * @return the current value of deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Setter method for deliveryDate.
     *
     * @param aDeliveryDate the new value for deliveryDate
     */
    public void setDeliveryDate(Date aDeliveryDate) {
        deliveryDate = aDeliveryDate;
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
	 * @return the shipmentNumber
	 */
	public int getShipmentNumber() {
		return shipmentNumber;
	}

	/**
	 * @param shipmentNumber the shipmentNumber to set
	 */
	public void setShipmentNumber(int shipmentNumber) {
		this.shipmentNumber = shipmentNumber;
	}

	/**
     * Access method for courier.
     *
     * @return the current value of courier
     */
    public Courier getCourier() {
        return courier;
    }

    /**
     * Setter method for courier.
     *
     * @param aCourier the new value for courier
     */
    public void setCourier(Courier aCourier) {
        courier = aCourier;
    }

    /**
     * Access method for invoice.
     *
     * @return the current value of invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Setter method for invoice.
     *
     * @param aInvoice the new value for invoice
     */
    public void setInvoice(Invoice aInvoice) {
        invoice = aInvoice;
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
     * Compares the key for this instance with another Shipment.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Shipment and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Shipment)) {
            return false;
        }
        Shipment that = (Shipment) other;
        if (this.getShipmentId() != that.getShipmentId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Shipment.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Shipment)) return false;
        return this.equalKeys(other) && ((Shipment)other).equalKeys(this);
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
        i = getShipmentId();
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
        StringBuffer sb = new StringBuffer("[Shipment |");
        sb.append(" shipmentId=").append(getShipmentId());
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
        ret.put("shipmentId", Integer.valueOf(getShipmentId()));
        return ret;
    }

	@Override
	public int compareTo(Shipment o) {
	   if (this.getShipmentDate() == null && o.getShipmentDate() == null)
		   return 0;            // make null==null
	   if (this.getShipmentDate() == null)
		   return 1;     // this null < other not null
	   if (o.getShipmentDate() == null)
		   return 1;  // this not null > other null				
		return this.getShipmentDate().compareTo(o.getShipmentDate());
	}

}
