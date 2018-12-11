/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import com.artisans.inventory.model.User;

/**
 * @author Jacob
 *
 */
public class InvoiceVO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int invoiceId;

    private String invoiceNumber;

    private Date invoiceDate;

    private Date datePaid;

    private double invAmount;

    private double invAmountUsd;

    private Timestamp modifiedOn;

    private Set<PaymentsVO> paymentsVO;

    private User user;

    private Set<ShipmentVO> shipmentVO;

    private SupplierVO supplierVO;

	/**
	 * @return the invoiceId
	 */
	public int getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * @return the invoiceDate
	 */
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
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
	 * @return the invAmount
	 */
	public double getInvAmount() {
		return invAmount;
	}

	/**
	 * @param invAmount the invAmount to set
	 */
	public void setInvAmount(double invAmount) {
		this.invAmount = invAmount;
	}

	/**
	 * @return the invAmountUsd
	 */
	public double getInvAmountUsd() {
		return invAmountUsd;
	}

	/**
	 * @param invAmountUsd the invAmountUsd to set
	 */
	public void setInvAmountUsd(double invAmountUsd) {
		this.invAmountUsd = invAmountUsd;
	}

	/**
	 * @return the modifiedOn
	 */
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the paymentsVO
	 */
	public Set<PaymentsVO> getPaymentsVO() {
		return paymentsVO;
	}

	/**
	 * @param paymentsVO the paymentsVO to set
	 */
	public void setPaymentsVO(Set<PaymentsVO> paymentsVO) {
		this.paymentsVO = paymentsVO;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the shipmentVO
	 */
	public Set<ShipmentVO> getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(Set<ShipmentVO> shipmentVO) {
		this.shipmentVO = shipmentVO;
	}

	/**
	 * @return the supplierVO
	 */
	public SupplierVO getSupplierVO() {
		return supplierVO;
	}

	/**
	 * @param supplierVO the supplierVO to set
	 */
	public void setSupplierVO(SupplierVO supplierVO) {
		this.supplierVO = supplierVO;
	}	
    

}
