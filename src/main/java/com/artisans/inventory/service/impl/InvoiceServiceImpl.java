/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.model.Payment;
import com.artisans.inventory.repository.InvoiceRepository;
import com.artisans.inventory.repository.PaymentsRepository;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.transformers.InvoiceTransformer;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 */
@Component(value="invoiceService")
@Transactional(readOnly=true)

public class InvoiceServiceImpl implements InvoiceService
{

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private PaymentsRepository paymentRepository;	
	
 	/**
	 * Get the specified Invoice Details
	 * @param invoiceId
	 * @return
	 */
	public InvoiceVO findInvoice(int invoiceId)
	{
		Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
		InvoiceVO invoiceVO = new DozerBeanMapper().map(invoice, InvoiceVO.class); 		
		return invoiceVO;		
	}
	
	
	 /** Returns all invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceVO> findAllInvoicesForSupplier(SupplierVO supplierVO)
	{
		List<InvoiceVO> invoiceVOList = new ArrayList<InvoiceVO>();
		List<?> invoiceList = invoiceRepository.findAllInvoicesForSupplier(supplierVO.getSupplierId());
		CollectionUtils.transform(invoiceList, new InvoiceTransformer());
		invoiceVOList = (List<InvoiceVO>) invoiceList;
		return invoiceVOList;		
	}
	
	/**
	 * Returns all active invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceVO> findAllActiveInvoicesForSupplier(SupplierVO supplierVO)
	{
		List<InvoiceVO> invoiceVOList = new ArrayList<InvoiceVO>();
		List<?> invoiceList = invoiceRepository.findAllInvoicesForSupplier(supplierVO.getSupplierId());
		CollectionUtils.transform(invoiceList, new InvoiceTransformer());
		invoiceVOList = (List<InvoiceVO>) invoiceList;
		return invoiceVOList;		
	}
	
	/**
	 * Save the invoice and all its invoice payments
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@Transactional(readOnly=false)
	public InvoiceVO saveInvoiceAndPayments(InvoiceVO invoiceVO)
	{
		Invoice invoice = null;
		
		if(invoiceVO.getInvoiceId() == 0) { //New Invoice
			invoice = new DozerBeanMapper().map(invoiceVO, Invoice.class); 			
			invoice = invoiceRepository.saveAndFlush(invoice);	
	    	for(Payment payment :invoice.getPayment())
	    	{
	    		payment.setInvoice(invoice);
	    	}		
			paymentRepository.saveAll(invoice.getPayment());		
		} else { //Update
			invoice = new DozerBeanMapper().map(invoiceVO, Invoice.class); 	
	    	for(Payment payment :invoice.getPayment()) {
	    		payment.setInvoice(invoice);
	    	}	
	    	paymentRepository.saveAll(invoice.getPayment());
	    	invoice = invoiceRepository.saveAndFlush(invoice);	
		}		
		return new DozerBeanMapper().map(invoice, InvoiceVO.class);
	}
	
	
	/**
	 * Update the invoice 
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@Transactional(readOnly=false)
	public void updateInvoice(InvoiceVO invoiceVO)
	{
		Invoice invoice = new DozerBeanMapper().map(invoiceVO, Invoice.class); 			
		invoiceRepository.saveAndFlush(invoice);	
	}	
	
	/**
	 * Update an Invoice Payment
	 * @param PaymentVO
	 * @return PaymentVO
	 */
	@Transactional(readOnly=false)
	public PaymentVO updateInvoicePayment(PaymentVO paymentVO)
	{
		Payment payment = new DozerBeanMapper().map(paymentVO, Payment.class); 			
		paymentRepository.saveAndFlush(payment);		
		return new DozerBeanMapper().map(payment, PaymentVO.class);
	}
	
	
	/**
	 * Delete an Invoice Payment
	 * @param PaymentVO
	 * @return PaymentVO
	 */
	@Transactional(readOnly=false)
	public void deleteInvoicePayment(PaymentVO paymentVO) {
		Payment payment = new DozerBeanMapper().map(paymentVO, Payment.class); 	
		paymentRepository.delete(payment);
	}
	
	
	public Integer findCountOfSupplierInvoiceForYear(Integer supplierId, Date invoiceDate) {
		return invoiceRepository.findCountOfSupplierInvoiceForYear(supplierId, new java.sql.Date(invoiceDate.getTime()));
	}
}
