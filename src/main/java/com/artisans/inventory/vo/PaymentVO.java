/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Jacob
 *
 */
public class PaymentVO extends BaseVO implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int paymentId;

    private double amount;

    private double amountUsd;

    private double bankCharges;

    private double gbpToUsd;

    private double otherCharges;

    private Date datePaid;

    private double vat;

    private double disbursementCharges;

    private String paymentType;

    private short paid;

    private InvoiceVO invoiceVO;

    private ShipmentVO shipmentVO;

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the amountUsd
	 */
	public double getAmountUsd() {
		return amountUsd;
	}

	/**
	 * @param amountUsd the amountUsd to set
	 */
	public void setAmountUsd(double amountUsd) {
		this.amountUsd = amountUsd;
	}

	/**
	 * @return the bankCharges
	 */
	public double getBankCharges() {
		return bankCharges;
	}

	/**
	 * @param bankCharges the bankCharges to set
	 */
	public void setBankCharges(double bankCharges) {
		this.bankCharges = bankCharges;
	}

	/**
	 * @return the gbpToUsd
	 */
	public double getGbpToUsd() {
		return gbpToUsd;
	}

	/**
	 * @param gbpToUsd the gbpToUsd to set
	 */
	public void setGbpToUsd(double gbpToUsd) {
		this.gbpToUsd = gbpToUsd;
	}

	/**
	 * @return the otherCharges
	 */
	public double getOtherCharges() {
		return otherCharges;
	}

	/**
	 * @param otherCharges the otherCharges to set
	 */
	public void setOtherCharges(double otherCharges) {
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
	public double getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(double vat) {
		this.vat = vat;
	}

	/**
	 * @return the disbursementCharges
	 */
	public double getDisbursementCharges() {
		return disbursementCharges;
	}

	/**
	 * @param disbursementCharges the disbursementCharges to set
	 */
	public void setDisbursementCharges(double disbursementCharges) {
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
	 * @return the invoiceVO
	 */
	public InvoiceVO getInvoiceVO() {
		return invoiceVO;
	}

	/**
	 * @param invoiceVO the invoiceVO to set
	 */
	public void setInvoiceVO(InvoiceVO invoiceVO) {
		this.invoiceVO = invoiceVO;
	}

	/**
	 * @return the shipmentVO
	 */
	public ShipmentVO getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(ShipmentVO shipmentVO) {
		this.shipmentVO = shipmentVO;
	}	
    
    

}
