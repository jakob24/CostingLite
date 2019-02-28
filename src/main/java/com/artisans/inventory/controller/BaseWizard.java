/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.service.api.ReportsService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.SupplierVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

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
	
	@Autowired
	private ApplicationConfiguration configUtil;	
	
	 @Autowired
	 private ResourceLoader resourceLoader;		
	
	public static final Short SHIPMENT_COMPLETE = 1;
	
	public static final Short SHIPMENT_NOT_COMPLETE = 0;
	
	public static final String PAY_TYPE_INVOICE = "INVOICE";
	
	public static final String PAY_TYPE_SHIPMENT = "SHIPMENT";
	
	public static final String SHIPMENT_ENTRY_PAGE="/ui/shipments.xhtml";
	
	public static final String SHIPMENT_ENTRY_METHOD="#{ShipmentWizard.invokedFromMenu}";
	
	public static final String INVOICE_ENTRY_PAGE="/ui/invoices.xhtml";
	
	public static final String INVOICE_ENTRY_METHOD="#{InvoiceWizard.invokedFromMenu}";	
	
	
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
	    
}
