/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Jacob
 *
 */
public class PaymentVO extends BaseVO implements Serializable, Comparable<PaymentVO> {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer paymentId;

    private Double amount;

    private Double amountUsd;

    private Double bankCharges;

    private Double gbpToUsd;

    private Double otherCharges;

    private Date datePaid;

    private Double vat;

    private Double disbursementCharges;

    private String paymentType; // INVOICE/SHIPMENT

    private short paid;

    private InvoiceVO invoice;

    private ShipmentVO shipment;

	/**
	 * @return the paymentId
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountUsd
	 */
	public Double getAmountUsd() {
		return amountUsd;
	}

	/**
	 * @param amountUsd the amountUsd to set
	 */
	public void setAmountUsd(Double amountUsd) {
		this.amountUsd = amountUsd;
	}

	/**
	 * @return the bankCharges
	 */
	public Double getBankCharges() {
		return bankCharges;
	}

	/**
	 * @param bankCharges the bankCharges to set
	 */
	public void setBankCharges(Double bankCharges) {
		this.bankCharges = bankCharges;
	}

	/**
	 * @return the gbpToUsd
	 */
	public Double getGbpToUsd() {
		return gbpToUsd;
	}

	/**
	 * @param gbpToUsd the gbpToUsd to set
	 */
	public void setGbpToUsd(Double gbpToUsd) {
		this.gbpToUsd = gbpToUsd;
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
	 * @return the datePaid
	 */
	public Date getDatePaid() {
		return datePaid;
	}

	/**
	 * @param datePaid the datePaid to set
	 */
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	/**
	 * @return the vat
	 */
	public Double getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(Double vat) {
		this.vat = vat;
	}

	/**
	 * @return the disbursementCharges
	 */
	public Double getDisbursementCharges() {
		return disbursementCharges;
	}

	/**
	 * @param disbursementCharges the disbursementCharges to set
	 */
	public void setDisbursementCharges(Double disbursementCharges) {
		this.disbursementCharges = disbursementCharges;
	}

	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * @return the paid
	 */
	public short getPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(short paid) {
		this.paid = paid;
	}

	/**
	 * @return the invoice
	 */
	public InvoiceVO getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(InvoiceVO invoice) {
		this.invoice = invoice;
	}

	/**
	 * @return the shipment
	 */
	public ShipmentVO getShipment() {
		return shipment;
	}

	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(ShipmentVO shipment) {
		this.shipment = shipment;
	}

	@Override
	public int compareTo(PaymentVO o) {		
	   if (this.getDatePaid() == null && o.getDatePaid() == null)
		   return 0;            // make null==null
	   if (this.getDatePaid() == null)
		   return 1;     // this null < other not null
	   if (o.getDatePaid() == null)
		   return 1;  // this not null > other null				
		return this.getDatePaid().compareTo(o.getDatePaid());
	}
	
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof PaymentVO)) {
            return false;
        }

        PaymentVO paymentVO = (PaymentVO) o;
        return paymentVO.getPaymentId().intValue() == getPaymentId().intValue();
    }	
}
