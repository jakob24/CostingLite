/**
 * 
 */
package com.artisans.inventory.service.api;

import java.util.List;

import com.artisans.inventory.vo.InvoiceVO;
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
	
	public void deleteShipment(ShipmentVO shipmentVO);
	
	public void saveShipmentProduct(List<ShipmentProductVO> shipmentProductVOList);
	
	public List<ShipmentProductVO> findAllproductsForShipment(ShipmentVO shipmentVO);
}
