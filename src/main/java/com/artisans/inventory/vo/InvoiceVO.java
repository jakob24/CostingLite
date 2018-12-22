/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Date;
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

    private Double invAmount;

    private Double invAmountUsd;

    private Set<PaymentVO> paymentsVO;

    private Set<ShipmentVO> shipmentsVO;

    private SupplierVO supplierVO;
    
    private String comments;      

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
	public Double getInvAmount() {
		return invAmount;
	}

	/**
	 * @param invAmount the invAmount to set
	 */
	public void setInvAmount(Double invAmount) {
		this.invAmount = invAmount;
	}

	/**
	 * @return the invAmountUsd
	 */
	public Double getInvAmountUsd() {
		return invAmountUsd;
	}

	/**
	 * @param invAmountUsd the invAmountUsd to set
	 */
	public void setInvAmountUsd(Double invAmountUsd) {
		this.invAmountUsd = invAmountUsd;
	}

	/**
	 * @return the paymentsVO
	 */
	public Set<PaymentVO> getPaymentsVO() {
		return paymentsVO;
	}

	/**
	 * @param paymentsVO the paymentsVO to set
	 */
	public void setPaymentsVO(Set<PaymentVO> paymentsVO) {
		this.paymentsVO = paymentsVO;
	}

	/**
	 * @return the shipmentsVO
	 */
	public Set<ShipmentVO> getShipmentsVO() {
		return shipmentsVO;
	}

	/**
	 * @param shipmentsVO the shipmentsVO to set
	 */
	public void setShipmentsVO(Set<ShipmentVO> shipmentsVO) {
		this.shipmentsVO = shipmentsVO;
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

}
