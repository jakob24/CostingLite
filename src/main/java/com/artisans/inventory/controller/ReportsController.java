/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.event.MenuActionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.helper.ReportEnum;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.ReportParameters;
import com.artisans.inventory.vo.SupplierVO;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author bjacob
 *
 */

@Scope(value="session")
@Component(value = "ReportsController")
public class ReportsController extends BaseWizard implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ResourceLoader resourceLoader;	
	 
	final Logger log = LoggerFactory.getLogger(ReportsController.class);
	 
	private static final String PDF_REPORT= ".pdf";
	
	private ReportEnum reportType;
	
	private Integer selectedInvoiceId;
	
	private InvoiceVO selectedInvoiceVO;
	
	private SupplierVO selectedSupplierVO;
	
	private List<InvoiceVO> supplierInvoiceList;
	 
	 
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{	
		
	}		
	
	/**
	 * Method to reset session and navigate to the link page
	 */
	public void setPageForReport(MenuActionEvent menuActionEvent) {
		String x = menuActionEvent.getMenuItem().getParams().get("reportType").get(0);
		setReportType(ReportEnum.valueOf(x));
		
		switch (reportType) {
		    case FULL_INVENTORY:				
		        break;
		    case SHIPMENT_COSTING:		    	
				setSelectedInvoiceVO(null);				
		        
		    case INVOICE:	
		    	setSelectedInvoiceVO(null);	        
		}		
		navigateTo(REPORTS_ENTRY_PAGE);
	}
	
	
	/**
	 * Method to capture parameters and Print report
	 */
	public void generatePrint() {
		
		switch (reportType) {
		    case FULL_INVENTORY:
		    	generateInventoryReport();
		        break;
		    case SHIPMENT_COSTING:
		    	generateCostingsReport();
		        break;
		        
		    case INVOICE:
		    	generateInvoiceReport();
		        break;		        
		}		
	}
		
	public void findAllInvoicesForSupplier()
	{
		setSelectedInvoiceVO(null);
		setSupplierInvoiceList(findAllInvoicesForSupplier(getSelectedSupplierVO()));
	}
	
	public void getInvoiceDetails() {
		//Get Selected Invoice details
		if(null != getSelectedInvoiceId()) {
			selectedInvoiceVO = invoiceService.findInvoice(getSelectedInvoiceId());
		}
	}
	
	
	/**
	 * Full inventory Report 
	 */
	public void generateInventoryReport() {
		ReportParameters reportParameters = new ReportParameters();
 		reportParameters.setReportEnum(ReportEnum.FULL_INVENTORY); 
 		reportParameters.setReportPrefix(BeanHelper.getDisplayDate(new Date()));
 		reportParameters.setReportParameterMap(new LinkedHashMap<>());    		
 		generateReport(reportParameters);
	}	 
	
	
	/**
    * Generate Invoice Report
    */
    private void generateCostingsReport() {
    	
    	if(null != getSelectedInvoiceVO() && getSelectedInvoiceVO().getInvoiceId() > 0 ) {    		
    		ReportParameters reportParameters = new ReportParameters();
    		reportParameters.setReportEnum(ReportEnum.SHIPMENT_COSTING);
    		reportParameters.setReportPrefix(getSelectedInvoiceVO().getInvoiceNumber());
    		reportParameters.setReportSuffix(BeanHelper.getDisplayDate(getSelectedInvoiceVO().getInvoiceDate()));
    		
    		LinkedHashMap<String, Object> reportParams = new LinkedHashMap<>();    		
    		reportParams.put("invoice_id", getSelectedInvoiceVO().getInvoiceId());
    		reportParameters.setReportParameterMap(reportParams);    		
    		generateReport(reportParameters);
    	}
    }

    
	/**
	* Generate Invoice Report
	*/
	 private void generateInvoiceReport() {
	 	
	 	if(null != getSelectedInvoiceVO() && getSelectedInvoiceVO().getInvoiceId() > 0 ) {    		
	 		ReportParameters reportParameters = new ReportParameters();
	 		reportParameters.setReportEnum(ReportEnum.INVOICE);
	 		reportParameters.setReportPrefix(getSelectedInvoiceVO().getInvoiceNumber());
	 		reportParameters.setReportSuffix(BeanHelper.getDisplayDate(getSelectedInvoiceVO().getInvoiceDate()));
	 		
	 		LinkedHashMap<String, Object> reportParams = new LinkedHashMap<>();    		
	 		reportParams.put("invoice_id", getSelectedInvoiceVO().getInvoiceId());
	 		reportParameters.setReportParameterMap(reportParams);    		
	 		generateReport(reportParameters);
	 	}
	 }
    
	 	 
    /**
     * Generate Invoice Report
     */
    public void generateReport(ReportParameters reportParameters) {

		try {
								
			String reportName= reportParameters.getReportPrefix() + 
					reportParameters.getReportEnum().getReportName() + reportParameters.getReportSuffix() + PDF_REPORT;
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();   
			response.reset();
			response.setContentType("application/pdf");	
			response.setHeader("Content-disposition", "attachment; filename= "+ reportName);						
			Resource resource = resourceLoader.getResource("classpath:" + reportParameters.getReportEnum().getReportTemplateName());			
			log.info("jasperFilePath : " + resource.getFilename() + "::" + resource.getInputStream().toString());
			
			JasperPrint jasperPrint = reportService.generateJasperPrint(resource.getInputStream(), reportParameters.getReportParameterMap());			
			ServletOutputStream stream = response.getOutputStream();			
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();		
			FacesContext.getCurrentInstance().responseComplete();	
		} catch (Exception e) {
			log.error("Error while generating the report " + e.getMessage(), e);
		}		
    }

	/**
	 * @return the reportType
	 */
	public ReportEnum getReportType() {
		return this.reportType;
	}

	/**
	 * @param reportType the reportType to set
	 */
	public void setReportType(ReportEnum reportType) {
		this.reportType = reportType;
	}

	/**
	 * @return the selectedInvoiceVO
	 */
	public InvoiceVO getSelectedInvoiceVO() {
		return selectedInvoiceVO;
	}

	/**
	 * @param selectedInvoiceVO the selectedInvoiceVO to set
	 */
	public void setSelectedInvoiceVO(InvoiceVO selectedInvoiceVO) {
		this.selectedInvoiceVO = selectedInvoiceVO;
	}

	/**
	 * @return the supplierInvoiceList
	 */
	public List<InvoiceVO> getSupplierInvoiceList() {
		return supplierInvoiceList;
	}

	/**
	 * @param supplierInvoiceList the supplierInvoiceList to set
	 */
	public void setSupplierInvoiceList(List<InvoiceVO> supplierInvoiceList) {
		this.supplierInvoiceList = supplierInvoiceList;
	}

	/**
	 * @return the selectedSupplierVO
	 */
	public SupplierVO getSelectedSupplierVO() {
		return selectedSupplierVO;
	}

	/**
	 * @param selectedSupplierVO the selectedSupplierVO to set
	 */
	public void setSelectedSupplierVO(SupplierVO selectedSupplierVO) {
		this.selectedSupplierVO = selectedSupplierVO;
	}

	/**
	 * @return the selectedInvoiceId
	 */
	public Integer getSelectedInvoiceId() {
		return selectedInvoiceId;
	}

	/**
	 * @param selectedInvoiceId the selectedInvoiceId to set
	 */
	public void setSelectedInvoiceId(Integer selectedInvoiceId) {
		this.selectedInvoiceId = selectedInvoiceId;
	}
	
	
	
}
