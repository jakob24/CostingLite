/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.helper.ProductShipmentHelper;
import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.model.Payment;
import com.artisans.inventory.model.Product;
import com.artisans.inventory.model.Shipment;
import com.artisans.inventory.model.ShipmentProduct;
import com.artisans.inventory.repository.InvoiceRepository;
import com.artisans.inventory.repository.PaymentsRepository;
import com.artisans.inventory.repository.ProductRepository;
import com.artisans.inventory.repository.ShipmentProductRepository;
import com.artisans.inventory.repository.ShipmentRepository;
import com.artisans.inventory.service.api.ShipmentService;
import com.artisans.inventory.transformers.ShipmentProductTransformer;
import com.artisans.inventory.transformers.ShipmentTransformer;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.ShipmentProductVO;
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
	private ShipmentProductRepository shipmentProductRepository;	
	
	@Autowired
	private PaymentsRepository paymentsRepository;	
	
	@Autowired
	private InvoiceRepository invoiceRepository;	
	
	@Autowired
	private ProductRepository productRepository;
	
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
			for(Payment payment : Optional.ofNullable(shipment.getPayment()).orElse(Collections.emptyList()) ) {
				payment.setShipment(shipment);
				paymentsRepository.saveAndFlush(payment);				
			}			
		}
		InvoiceVO invoiceVOObj = new DozerBeanMapper().map(invoice, InvoiceVO.class); 
		return invoiceVOObj;		
	}
	
	/**
	 * Method to delete a shipment
	 */
	@Transactional(readOnly=false)
	public void deleteShipment(ShipmentVO shipmentVO) {
		Shipment shipment = new DozerBeanMapper().map(shipmentVO, Shipment.class);
		
		//Get All shipments for invoice
		Invoice invoice = shipment.getInvoice();		
		Integer deletedShipmentId = shipment.getShipmentId();
				
		shipmentRepository.delete(shipment);
		
		//Get all Shipments for the invoice and update with new shipment numbers
		int shipmentNumber = 1;
		List<Shipment>shipments = invoice.getShipment();	
		for(Shipment thisShipment : shipments) {
			if(thisShipment.getShipmentId() != deletedShipmentId) {
				thisShipment.setShipmentNumber(shipmentNumber);				
				shipmentRepository.saveAndFlush(thisShipment);
				shipmentNumber++;
			}
		}		
	}
	
	/**
	 * Method to save the list of ShipmentProductVO
	 */
	@Transactional(readOnly=false)
	public void saveShipmentProduct(List<ShipmentProductVO> shipmentProductVOList) {
				
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			
			ShipmentProduct shipmentProduct = new DozerBeanMapper().map(shipmentProductVO, ShipmentProduct.class);
			shipmentProduct = shipmentProductRepository.saveAndFlush(shipmentProduct);
					
			//Update inventory Stock in Product
			Product thisProduct = productRepository.findById(shipmentProductVO.getProduct().getProductId()).orElse(null);		
			Integer newQty = thisProduct.getInventory() + shipmentProductVO.getProductQty();
			thisProduct.setInventory(newQty);
			productRepository.saveAndFlush(thisProduct);
		}			
	}
	
	/**
	 * Method to get all ShipmentProductVO for a shipment
	 */
	@SuppressWarnings("unchecked")
	public List<ShipmentProductVO> findAllproductsForShipment(ShipmentVO shipmentVO) {
		
		List<ShipmentProductVO> shipmentProductVOList = new ArrayList<ShipmentProductVO>();
		List<?> shipmentProductList = shipmentProductRepository.findAllproductsForShipment(shipmentVO.getShipmentId());
		CollectionUtils.transform(shipmentProductList, new ShipmentProductTransformer());
		shipmentProductVOList =  (List<ShipmentProductVO>) shipmentProductList;
		
		//Set the USD Conversion Rate from the invoice on the ShipmentProductVO
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			shipmentProductVO.setGbpToUsd(ProductShipmentHelper.getInvoiceConversionRate(shipmentProductVO));
		}		
		return shipmentProductVOList;		
	}
	
}
