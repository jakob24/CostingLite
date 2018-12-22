/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.repository.InvoiceRepository;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.transformers.InvoiceTransformer;
import com.artisans.inventory.vo.InvoiceVO;
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
	
	/**
	 * Get the specified Invoice Details
	 * @param invoiceId
	 * @return
	 */
	public InvoiceVO findInvoice(int invoiceId)
	{
		Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
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
}
