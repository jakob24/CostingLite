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
public class ShipmentVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer shipmentId;

	private int shipmentNumber;
	
    private Date shipmentDate;

    private String trackingNumber;

    private Date deliveryDate;

    private CourierVO courier;

    private InvoiceVO invoice;

    private List<ShipmentProductVO> shipmentProduct;

    private List<PaymentVO> payment;
        
        
    /**
     * Method to format the Shipment number + date to be 
     * shown in dropdown
     * @return
     */
    public String getFormattedLabel() {
    	Format formatter = new SimpleDateFormat("dd/MM/yyyy"); 
    	return getShipmentNumber() + " - " + formatter.format(getShipmentDate());
    }
	/**
	 * @return the shipmentId
	 */
	public Integer getShipmentId() {
		return shipmentId;
	}

	/**
	 * @param shipmentId the shipmentId to set
	 */
	public void setShipmentId(Integer shipmentId) {
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
	 * @return the courier
	 */
	public CourierVO getCourier() {
		return courier;
	}

	/**
	 * @param courier the courier to set
	 */
	public void setCourier(CourierVO courier) {
		this.courier = courier;
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
	 * @return the shipmentProduct
	 */
	public List<ShipmentProductVO> getShipmentProduct() {
		return shipmentProduct;
	}
	/**
	 * @param shipmentProduct the shipmentProduct to set
	 */
	public void setShipmentProduct(List<ShipmentProductVO> shipmentProduct) {
		this.shipmentProduct = shipmentProduct;
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

	@Override
    public boolean equals(Object newShipment) { 	   
       if (this != null && newShipment != null && null !=((ShipmentVO)newShipment).getShipmentId() && null != this.getShipmentId() &&
    		   this.getShipmentId().intValue() == ((ShipmentVO)newShipment).getShipmentId().intValue()) {
           return true;
       } 
       else {
    	   return false;
       }

    } 	
}
