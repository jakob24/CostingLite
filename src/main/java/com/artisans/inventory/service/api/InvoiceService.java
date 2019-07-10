/**
 * 
 */
package com.artisans.inventory.service.api;


import java.util.Date;
import java.util.List;

import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
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
	public InvoiceVO saveInvoiceAndPayments(InvoiceVO invoiceVO);
	
	/**
	 * Update an Invoice Payment
	 * @param PaymentVO
	 * @return PaymentVO
	 */
	public PaymentVO updateInvoicePayment(PaymentVO paymentVO);
	
	/**
	 * Update the invoice 
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	public void updateInvoice(InvoiceVO invoiceVO);

	/**
	 * Delete an Invoice Payment
	 * @param PaymentVO
	 * @return PaymentVO
	 */
	public void deleteInvoicePayment(PaymentVO paymentVO);	
	
	/**
	 * Get count of Supplier Invoices in the current Year
	 * @param supplierId
	 * @return
	 */
	public Integer findCountOfSupplierInvoiceForYear(Integer supplierId, Date sqlDate);

}
