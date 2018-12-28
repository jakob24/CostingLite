/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.model.Payment;
import com.artisans.inventory.model.Shipment;
import com.artisans.inventory.repository.InvoiceRepository;
import com.artisans.inventory.repository.PaymentsRepository;
import com.artisans.inventory.repository.ShipmentRepository;
import com.artisans.inventory.service.api.ShipmentService;
import com.artisans.inventory.transformers.ShipmentTransformer;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author Jacob
 *
 */
@Component(value="shipmentService")
@Transactional(readOnly=true)
public class ShipmentServiceImpl implements ShipmentService {
	
	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
	private PaymentsRepository paymentsRepository;	
	
	@Autowired
	private InvoiceRepository invoiceRepository;		
	
	/**
	 * Get all the shipments for the selected Invoice
	 * @param invoiceVO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShipmentVO> findAllShipmentsForInvoice(InvoiceVO invoiceVO){
		
		List<ShipmentVO> shipmentVOList = new ArrayList<ShipmentVO>();
		List<?> shipmentList = shipmentRepository.findAllShipmentsForInvoice(invoiceVO.getInvoiceId());
		CollectionUtils.transform(shipmentList, new ShipmentTransformer());
		shipmentVOList = (List<ShipmentVO>) shipmentList;
		return shipmentVOList;		
	}
	
	/**
	 * Find shipment details
	 */
	public ShipmentVO findShipment(Integer shipmentId) {
		
		Shipment shipment = shipmentRepository.findById(shipmentId).orElse(null);
		ShipmentVO shipmentVO = new DozerBeanMapper().map(shipment, ShipmentVO.class); 		
		return shipmentVO;		
	}
	
	/**
	 * Method to save all shipments for the Invoice
	 */
	@Transactional(readOnly=false)
	public InvoiceVO saveShipments(InvoiceVO invoiceVO) {
		
		Invoice invoice = new DozerBeanMapper().map(invoiceVO, Invoice.class);		
		if(null != invoice.getShipmentComplete() && invoice.getShipmentComplete() == 1) {
			
			//Update Invoice
			invoiceRepository.saveAndFlush(invoice);
		}		
		
		for(Shipment shipment : invoice.getShipment()) {
			
			//Save Shipment
			shipment = shipmentRepository.saveAndFlush(shipment);	
			
			//Save the Shipment Payments
			for(Payment payment : shipment.getPayment()) {
				payment.setShipment(shipment);//TODO -update shipment with paymentid - check
				paymentsRepository.saveAndFlush(payment);
				
				
			}			
		}
		
		
		InvoiceVO invoiceVOObj = new DozerBeanMapper().map(invoice, InvoiceVO.class); 
		return invoiceVOObj;		
	}

}
