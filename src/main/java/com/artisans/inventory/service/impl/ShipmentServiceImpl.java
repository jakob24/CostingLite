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

import com.artisans.inventory.helper.ApplicationConfiguration;
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
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.service.api.ShipmentService;
import com.artisans.inventory.transformers.ShipmentProductTransformer;
import com.artisans.inventory.transformers.ShipmentTransformer;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ProductVO;
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
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private ApplicationConfiguration configUtil;
		
	
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
		
		for(ShipmentVO shipmentVO : shipmentVOList) {			
			//Get the products, not through lazy loading
			shipmentVO.setShipmentProduct(findAllproductsForShipment(shipmentVO.getShipmentId()));			
		}		
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
		//Update Invoice Paid Date
		if(null != invoice.getDatePaid()) {			
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
	 * Method to save a shipment
	 */
	@Transactional(readOnly=false)
	public ShipmentVO saveShipment(ShipmentVO shipmentVO) {		
		Shipment shipment = new DozerBeanMapper().map(shipmentVO, Shipment.class); 		
		//Save Shipment
		shipment = shipmentRepository.saveAndFlush(shipment);	
		
		//Update Invoice Paid Date
		if(null != shipmentVO.getInvoice().getDatePaid()) {			
			invoiceRepository.save(shipment.getInvoice());
		}
		return new DozerBeanMapper().map(shipment, ShipmentVO.class); 
		
	}	
	
	/**
	 * Method to delete a shipment
	 * returns false if shipment cannot be deleted
	 */
	@Transactional(readOnly=false)
	public boolean deleteShipment(ShipmentVO shipmentVO) {
		Shipment shipment = new DozerBeanMapper().map(shipmentVO, Shipment.class);
		
		List<Shipment> existingShipments = shipmentRepository.findAllShipmentsForInvoice(shipmentVO.getInvoice().getInvoiceId());
		
		for(Shipment aShipment : existingShipments) {
			if(aShipment.getShipmentId() == shipmentVO.getShipmentId()) {
				return false;
			}
		}
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
		return true;
	}
	
	/**
	 * Method to update an existing Shipment Payment
	 * @param paymentVO
	 */
	@Transactional(readOnly=false)
	public void updateShipmentPayment(PaymentVO paymentVO) {
		Payment payment = new DozerBeanMapper().map(paymentVO, Payment.class);
		paymentsRepository.saveAndFlush(payment);		
	}	
	
	
	/**
	 * Method to delete an existing Shipment Payment
	 * @param paymentVO
	 */
	@Transactional(readOnly=false)
	public void deleteShipmentPayment(PaymentVO paymentVO) {
		Payment payment = new DozerBeanMapper().map(paymentVO, Payment.class);
		paymentsRepository.delete(payment);
	}
	
	
	
	/**
	 * Method to save Shipment Product and re calculate all the landing costs and update them
	 */
	@Transactional(readOnly=false)
	public void saveShipmentProduct(List<ShipmentProductVO> shipmentProductVOList) {
				
		//Calculate Landing Costs
		ProductShipmentHelper.setConfigUtil(configUtil);
		ProductShipmentHelper.calculateShipmentProductprices(shipmentProductVOList);
		
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			
			ShipmentProduct shipmentProduct = new DozerBeanMapper().map(shipmentProductVO, ShipmentProduct.class);
			shipmentProduct = shipmentProductRepository.saveAndFlush(shipmentProduct);
					
			//Update inventory Stock in Product
			Product thisProduct = productRepository.findById(shipmentProductVO.getProduct().getProductId()).orElse(null);	
			
			//Shipment qty was subtracted from inventory when loading data
			Integer newQty = shipmentProductVO.getInventory() + shipmentProductVO.getProductQty();
			thisProduct.setInventory(newQty);
			productRepository.saveAndFlush(thisProduct);
		}			
	}
	

	/**
	 * Method to delete an existing shipment Product and re calculate 
	 * the landing costs for remaining products within the shipment and update them
	 */
	@Transactional(readOnly=false)
	public void deleteShipmentProduct(ShipmentProductVO shipmentProductVO) {
		ShipmentProduct shipmentProduct = new DozerBeanMapper().map(shipmentProductVO, ShipmentProduct.class);
		shipmentProductRepository.delete(shipmentProduct);
		
		//Now get all other products within same shipment and recalculate the price
		List<ShipmentProductVO> existingProducts = findAllproductsForShipment(shipmentProductVO.getShipment().getShipmentId());
		
		//Calculate Landing Costs
		ProductShipmentHelper.setConfigUtil(configUtil);
		ProductShipmentHelper.calculateShipmentProductprices(existingProducts);	
		
		//Update the products costs
		saveShipmentProduct(existingProducts);
		
		//Update Product Inventory
		invoiceService.updateInvoice(shipmentProductVO.getShipment().getInvoice());
	}
	
	/**
	 * Method to get all ShipmentProductVO for a shipment
	 */
	@SuppressWarnings("unchecked")
	public List<ShipmentProductVO> findAllproductsForShipment(Integer shipmentId) {
		
		List<ShipmentProductVO> shipmentProductVOList = new ArrayList<ShipmentProductVO>();
		List<?> shipmentProductList = shipmentProductRepository.findAllproductsForShipment(shipmentId);
		CollectionUtils.transform(shipmentProductList, new ShipmentProductTransformer());
		shipmentProductVOList =  (List<ShipmentProductVO>) shipmentProductList;
		
		//Set the USD Conversion Rate from the invoice on the ShipmentProductVO
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			
			shipmentProductVO.setGbpToUsd(ProductShipmentHelper.getInvoiceConversionRate(shipmentProductVO));
			
			Product product = productRepository.findById(shipmentProductVO.getProduct().getProductId()).orElse(new Product());
			ProductVO productVO = new DozerBeanMapper().map(product, ProductVO.class); 
			
			//Reduce the qty from main inventory for the product, when saving will add it to inventory
			shipmentProductVO.setInventory(productVO.getInventory()-shipmentProductVO.getProductQty());
		}		
		return shipmentProductVOList;		
	}
	
}
