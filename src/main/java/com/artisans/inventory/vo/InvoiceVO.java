/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    
    private List<PaymentVO> payment;

    private List<ShipmentVO> shipment;

    private SupplierVO supplier;
    
    private String comments;    
    
    private Short shipmentComplete;
    
    
    /**
     * Method to format the invoice number + date to be 
     * shown in dropdown
     * @return
     */
    public String getFormattedLabel() {
    	Format formatter = new SimpleDateFormat("dd/MM/yyyy"); 
    	return getInvoiceNumber() + " - " + formatter.format(getInvoiceDate());
    }

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
	 * @return the payment
	 */
	public List<PaymentVO> getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(List<PaymentVO> payment) {
		this.payment = payment;
	}

	/**
	 * @return the shipment
	 */
	public List<ShipmentVO> getShipment() {
		return shipment;
	}

	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(List<ShipmentVO> shipment) {
		this.shipment = shipment;
	}

	/**
	 * @return the supplier
	 */
	public SupplierVO getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(SupplierVO supplier) {
		this.supplier = supplier;
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
	
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof InvoiceVO)) {
            return false;
        }

        InvoiceVO invoiceVO = (InvoiceVO) o;
        return invoiceVO.getInvoiceId() == getInvoiceId();
    }		

}
