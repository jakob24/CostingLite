// Generated with g9.

package com.artisans.inventory.model;

import java.io.Serializable;
import java.sql.Date;
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

@Entity(name="invoice")
public class Invoice implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "invoiceId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="invoice_id", unique=true, nullable=false, length=10)
    private int invoiceId;
    
    @Column(name="invoice_number", length=45)
    private String invoiceNumber;
    
    @Column(name="invoice_date")
    private Date invoiceDate;
    
    @Column(name="date_paid")
    private Date datePaid;
    
    @Column(name="inv_amount", precision=5, scale=2)
    private double invAmount;
    
    @Column(name="inv_amount_usd", precision=5, scale=2)
    private double invAmountUsd;
    
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    
    @OneToMany(mappedBy="invoice")
    private List<Payment> payment;
    
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;
    
    @OneToMany(mappedBy="invoice")
    private List<Shipment> shipment;
    
    @ManyToOne
    @JoinColumn(name="supplier")
    private Supplier supplier;
    
    @Column(name="comments", length=500)
    private String comments;     
    
    @Column(length=2)
    private Short shipmentComplete;

    /** Default constructor. */
    public Invoice() {
        super();
    }

    /**
     * Access method for invoiceId.
     *
     * @return the current value of invoiceId
     */
    public int getInvoiceId() {
        return invoiceId;
    }

    /**
     * Setter method for invoiceId.
     *
     * @param aInvoiceId the new value for invoiceId
     */
    public void setInvoiceId(int aInvoiceId) {
        invoiceId = aInvoiceId;
    }

    /**
     * Access method for invoiceNumber.
     *
     * @return the current value of invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Setter method for invoiceNumber.
     *
     * @param aInvoiceNumber the new value for invoiceNumber
     */
    public void setInvoiceNumber(String aInvoiceNumber) {
        invoiceNumber = aInvoiceNumber;
    }

    /**
     * Access method for invoiceDate.
     *
     * @return the current value of invoiceDate
     */
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Setter method for invoiceDate.
     *
     * @param aInvoiceDate the new value for invoiceDate
     */
    public void setInvoiceDate(Date aInvoiceDate) {
        invoiceDate = aInvoiceDate;
    }

    /**
     * Access method for datePaid.
     *
     * @return the current value of datePaid
     */
    public Date getDatePaid() {
        return datePaid;
    }

    /**
     * Setter method for datePaid.
     *
     * @param aDatePaid the new value for datePaid
     */
    public void setDatePaid(Date aDatePaid) {
        datePaid = aDatePaid;
    }

    /**
     * Access method for invAmount.
     *
     * @return the current value of invAmount
     */
    public double getInvAmount() {
        return invAmount;
    }

    /**
     * Setter method for invAmount.
     *
     * @param aInvAmount the new value for invAmount
     */
    public void setInvAmount(double aInvAmount) {
        invAmount = aInvAmount;
    }

    /**
     * Access method for invAmountUsd.
     *
     * @return the current value of invAmountUsd
     */
    public double getInvAmountUsd() {
        return invAmountUsd;
    }

    /**
     * Setter method for invAmountUsd.
     *
     * @param aInvAmountUsd the new value for invAmountUsd
     */
    public void setInvAmountUsd(double aInvAmountUsd) {
        invAmountUsd = aInvAmountUsd;
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
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
     * Access method for supplier.
     *
     * @return the current value of supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Setter method for supplier.
     *
     * @param aSupplier the new value for supplier
     */
    public void setSupplier(Supplier aSupplier) {
        supplier = aSupplier;
    }
        

    /**
	 * @return the shipmentComplete
	 */
	public Short getShipmentComplete() {
		return shipmentComplete;
	}

	/**
	 * @param shipmentComplete the shipmentComplete to set
	 */
	public void setShipmentComplete(Short shipmentComplete) {
		this.shipmentComplete = shipmentComplete;
	}

	/**
     * Compares the key for this instance with another Invoice.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Invoice and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Invoice)) {
            return false;
        }
        Invoice that = (Invoice) other;
        if (this.getInvoiceId() != that.getInvoiceId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Invoice.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Invoice)) return false;
        return this.equalKeys(other) && ((Invoice)other).equalKeys(this);
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
        i = getInvoiceId();
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
        StringBuffer sb = new StringBuffer("[Invoice |");
        sb.append(" invoiceId=").append(getInvoiceId());
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
        ret.put("invoiceId", Integer.valueOf(getInvoiceId()));
        return ret;
    }

}
