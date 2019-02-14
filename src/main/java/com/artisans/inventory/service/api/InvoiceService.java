/**
 * 
 */
package com.artisans.inventory.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.SupplierVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

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
	 * Method to generate the Invoice report
	 * @param jasperReport
	 * @param parameterMap
	 * @return
	 * @throws SQLException
	 * @throws JRException
	 * @throws IOException
	 */
	public JasperPrint exportInvoicePdfFile(JasperReport jasperReport, Map<String, Object> parameterMap) 
			throws SQLException, JRException, IOException ;

}
