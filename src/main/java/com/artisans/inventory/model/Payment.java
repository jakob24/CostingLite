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

@Entity(name="payments")
public class Payment implements Serializable, Comparable<Payment>  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** Primary key. */
    protected static final String PK = "paymentId";


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_id", unique=true, nullable=false, length=10)
    private int paymentId;
    
    @Column(precision=22)
    private double amount;
    
    @Column(name="amount_usd", precision=22)
    private double amountUsd;
    
    @Column(name="bank_charges", precision=22)
    private double bankCharges;
    
    @Column(name="gbp_to_usd", precision=22)
    private double gbpToUsd;
    
    @Column(name="other_charges", precision=22)
    private double otherCharges;
    
    @Column(name="date_paid")
    private Date datePaid;
    
    @Column(precision=22)
    private double vat;
    
    @Column(name="disbursement_charges", precision=22)
    private double disbursementCharges;
    
    @Column(name="payment_type", length=45)
    private String paymentType;
    
    @Column(length=3)
    private short paid;
    
    @Column(name="modified_on")
    private Timestamp modifiedOn;
    
    @ManyToOne
    @JoinColumn(name="invoice")
    private Invoice invoice;
    
    @ManyToOne
    @JoinColumn(name="modified_by")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="shipment")
    private Shipment shipment;

    /** Default constructor. */
    public Payment() {
        super();
    }

    /**
     * Access method for paymentId.
     *
     * @return the current value of paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * Setter method for paymentId.
     *
     * @param aPaymentId the new value for paymentId
     */
    public void setPaymentId(int aPaymentId) {
        paymentId = aPaymentId;
    }

    /**
     * Access method for amount.
     *
     * @return the current value of amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter method for amount.
     *
     * @param aAmount the new value for amount
     */
    public void setAmount(double aAmount) {
        amount = aAmount;
    }

    /**
     * Access method for amountUsd.
     *
     * @return the current value of amountUsd
     */
    public double getAmountUsd() {
        return amountUsd;
    }

    /**
     * Setter method for amountUsd.
     *
     * @param aAmountUsd the new value for amountUsd
     */
    public void setAmountUsd(double aAmountUsd) {
        amountUsd = aAmountUsd;
    }

    /**
     * Access method for bankCharges.
     *
     * @return the current value of bankCharges
     */
    public double getBankCharges() {
        return bankCharges;
    }

    /**
     * Setter method for bankCharges.
     *
     * @param aBankCharges the new value for bankCharges
     */
    public void setBankCharges(double aBankCharges) {
        bankCharges = aBankCharges;
    }

    /**
     * Access method for gbpToUsd.
     *
     * @return the current value of gbpToUsd
     */
    public double getGbpToUsd() {
        return gbpToUsd;
    }

    /**
     * Setter method for gbpToUsd.
     *
     * @param aGbpToUsd the new value for gbpToUsd
     */
    public void setGbpToUsd(double aGbpToUsd) {
        gbpToUsd = aGbpToUsd;
    }

    /**
     * Access method for otherCharges.
     *
     * @return the current value of otherCharges
     */
    public double getOtherCharges() {
        return otherCharges;
    }

    /**
     * Setter method for otherCharges.
     *
     * @param aOtherCharges the new value for otherCharges
     */
    public void setOtherCharges(double aOtherCharges) {
        otherCharges = aOtherCharges;
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
     * Access method for vat.
     *
     * @return the current value of vat
     */
    public double getVat() {
        return vat;
    }

    /**
     * Setter method for vat.
     *
     * @param aVat the new value for vat
     */
    public void setVat(double aVat) {
        vat = aVat;
    }

    /**
     * Access method for disbursementCharges.
     *
     * @return the current value of disbursementCharges
     */
    public double getDisbursementCharges() {
        return disbursementCharges;
    }

    /**
     * Setter method for disbursementCharges.
     *
     * @param aDisbursementCharges the new value for disbursementCharges
     */
    public void setDisbursementCharges(double aDisbursementCharges) {
        disbursementCharges = aDisbursementCharges;
    }

    /**
     * Access method for paymentType.
     *
     * @return the current value of paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Setter method for paymentType.
     *
     * @param aPaymentType the new value for paymentType
     */
    public void setPaymentType(String aPaymentType) {
        paymentType = aPaymentType;
    }

    /**
     * Access method for paid.
     *
     * @return the current value of paid
     */
    public short getPaid() {
        return paid;
    }

    /**
     * Setter method for paid.
     *
     * @param aPaid the new value for paid
     */
    public void setPaid(short aPaid) {
        paid = aPaid;
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
     * Compares the key for this instance with another Payments.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Payments and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Payment)) {
            return false;
        }
        Payment that = (Payment) other;
        if (this.getPaymentId() != that.getPaymentId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Payments.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Payment)) return false;
        return this.equalKeys(other) && ((Payment)other).equalKeys(this);
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
        i = getPaymentId();
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
        StringBuffer sb = new StringBuffer("[Payments |");
        sb.append(" paymentId=").append(getPaymentId());
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
        ret.put("paymentId", Integer.valueOf(getPaymentId()));
        return ret;
    }

	@Override
	public int compareTo(Payment o) {
		   if (this.getDatePaid() == null && o.getDatePaid() == null)
			   return 0;            // make null==null
		   if (this.getDatePaid() == null)
			   return 1;     // this null < other not null
		   if (o.getDatePaid() == null)
			   return 1;  // this not null > other null				
			return this.getDatePaid().compareTo(o.getDatePaid());
	}

}
