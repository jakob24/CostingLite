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
public class ShipmentVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int shipmentId;

	private int shipmentNumber;
	
    private Date shipmentDate;

    private int payment;

    private String trackingNumber;

    private Date deliveryDate;

    private CourierVO courierVO;

    private InvoiceVO invoiceVO;

    private Set<ShipmentProductVO> shipmentProductVO;

    private Set<PaymentVO> paymentVO;

	/**
	 * @return the shipmentId
	 */
	public int getShipmentId() {
		return shipmentId;
	}

	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
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
	 * @return the shipmentDate
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * @param shipmentDate the shipmentDate to set
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * @return the payment
	 */
	public int getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(int payment) {
		this.payment = payment;
	}

	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the deliveryDate
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @return the courierVO
	 */
	public CourierVO getCourierVO() {
		return courierVO;
	}

	/**
	 * @param courierVO the courierVO to set
	 */
	public void setCourierVO(CourierVO courierVO) {
		this.courierVO = courierVO;
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
	 * @return the shipmentProductVO
	 */
	public Set<ShipmentProductVO> getShipmentProductVO() {
		return shipmentProductVO;
	}

	/**
	 * @param shipmentProductVO the shipmentProductVO to set
	 */
	public void setShipmentProductVO(Set<ShipmentProductVO> shipmentProductVO) {
		this.shipmentProductVO = shipmentProductVO;
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
}
