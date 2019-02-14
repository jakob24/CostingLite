/**
 * 
 */
package com.artisans.inventory.service.api;

import java.util.List;

import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ShipmentProductVO;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author Jacob
 *
 */

/**
 *Get all the shipments for the selected Invoice
 * @author Jacob
 *
 */
public interface ShipmentService {

	public List<ShipmentVO> findAllShipmentsForInvoice(InvoiceVO invoiceVO);
		
	public ShipmentVO findShipment(Integer shipmentId);
		
	public InvoiceVO saveShipments(InvoiceVO invoiceVO);
	
	public boolean deleteShipment(ShipmentVO shipmentVO);

	
	public List<ShipmentProductVO> findAllproductsForShipment(Integer shipmentId);

	public ShipmentVO saveShipment(ShipmentVO shipmentVO);		
	
	/**
	 * Method to delete an existing Shipment Payment
	 * @param paymentVO
	 */
	public void deleteShipmentPayment(PaymentVO paymentVO)	;
	
	/**
	 * Method to update an existing Shipment Payment
	 * @param paymentVO
	 */
	public void updateShipmentPayment(PaymentVO paymentVO)	;	
	
	
	public void saveShipmentProduct(List<ShipmentProductVO> shipmentProductVOList);
	
	public void deleteShipmentProduct(ShipmentProductVO shipmentProductVO);
	
}
