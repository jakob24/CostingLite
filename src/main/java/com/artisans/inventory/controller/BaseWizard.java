/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 */
public class BaseWizard implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	InvoiceService invoiceService;
	
	
	public static final Short SHIPMENT_COMPLETE = 1;
	
	public static final Short SHIPMENT_NOT_COMPLETE = 0;
	
	public static final String PAY_TYPE_INVOICE = "INVOICE";
	
	public static final String PAY_TYPE_SHIPMENT = "SHIPMENT";
	
	/**
	 * Get All Invoices for the supplier
	 */
	public List<InvoiceVO> findAllInvoicesForSupplier(SupplierVO supplierVO)
	{
		List<InvoiceVO> invoiceVOList = invoiceService.findAllActiveInvoicesForSupplier(supplierVO);
		return invoiceVOList;
	}
}
