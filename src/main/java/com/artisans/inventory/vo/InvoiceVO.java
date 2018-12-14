/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

/**
 * @author Jacob
 *
 */
public class InvoiceVO extends BaseVO implements Serializable {
	
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

    private Set<PaymentVO> paymentVO;

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
	 * @return the paymentsVO
	 */
	public Set<PaymentVO> getPaymentsVO() {
		return paymentVO;
	}

	/**
	 * @param paymentVO the paymentsVO to set
	 */
	public void setPaymentsVO(Set<PaymentVO> paymentVO) {
		this.paymentVO = paymentVO;
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
