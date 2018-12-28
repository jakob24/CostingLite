/**
 * 
 */
package com.artisans.inventory.service.api;

import java.util.List;

import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 */
public interface InvoiceService 
{
	
	/**
	 * Get the specified Invoice Details
	 * @param invoiceId
	 * @return
	 */
	public InvoiceVO findInvoice(int invoiceId);
	
	 /** Returns all invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	public List<InvoiceVO> findAllInvoicesForSupplier(SupplierVO supplierVO);
	
	/**
	 * Returns all active invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	public List<InvoiceVO> findAllActiveInvoicesForSupplier(SupplierVO supplierVO);
	
	
	/**
	 * Save the invoice and all its invoice payments
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	public InvoiceVO SaveInvoiceAndPayments(InvoiceVO invoiceVO);
}
