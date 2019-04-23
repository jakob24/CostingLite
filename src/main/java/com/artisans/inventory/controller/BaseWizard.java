/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.service.api.ReportsService;
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
	
	@Autowired
	ReportsService reportService;
	
		
	public static final Short SHIPMENT_COMPLETE = 1;
	
	public static final Short SHIPMENT_NOT_COMPLETE = 0;
	
	public static final String PAY_TYPE_INVOICE = "INVOICE";
	
	public static final String PAY_TYPE_SHIPMENT = "SHIPMENT";
	
	public static final String SHIPMENT_ENTRY_PAGE="/ui/shipments.xhtml";
	
	public static final String SHIPMENT_ENTRY_METHOD="#{ShipmentWizard.invokedFromMenu}";
	
	public static final String INVOICE_ENTRY_PAGE="/ui/invoices.xhtml";
	
	public static final String INVOICE_ENTRY_METHOD="#{InvoiceWizard.invokedFromMenu}";	
	
	public static final String REPORTS_ENTRY_PAGE="/ui/reports.xhtml";
	
	
	/**
	 * Get All Invoices for the supplier
	 */
	public List<InvoiceVO> findAllInvoicesForSupplier(SupplierVO supplierVO)
	{
		List<InvoiceVO> invoiceVOList = invoiceService.findAllActiveInvoicesForSupplier(supplierVO);
		return invoiceVOList;
	}
	
	/**
	 * Method invoked when called from menu.Reset the session
	 * @param url
	 */
	public void resetAndNavigateTo(String url) {
	    try {
		    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    ec.invalidateSession();	    	
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}	
	
	/**
	 * Method invoked when called from menu.Reset the session
	 * @param url
	 */
	public void navigateTo(String url) {
	    try {
		    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext(); 	
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}	
	
	
	/**
	 * If invoice is paid in USD, return true;
	 * @param invoiceVO
	 * @return
	 */
	public boolean isInvoiceInUSD(InvoiceVO invoiceVO) {
    	if(null != invoiceVO.getInvAmountUsd() && invoiceVO.getInvAmountUsd().doubleValue() > 0) 
    		return true;
    	else
    		return false;
	}
	    
}
