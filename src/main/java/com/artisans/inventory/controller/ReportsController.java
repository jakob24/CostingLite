/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.helper.ReportEnum;
import com.artisans.inventory.vo.ReportParameters;

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
	 
	 
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{	
		
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
    public void generateReport(ReportParameters reportParameters) {

		try {
								
			String reportName= reportParameters.getReportPrefix() + 
					reportParameters.getReportEnum().getReportName() + reportParameters.getReportSuffix() + PDF_REPORT;
			
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();   
			response.reset();
			response.setContentType("application/pdf");	
			response.setHeader("Content-disposition", "attachment; filename= "+ reportName);
			String jasperFilePath = resourceLoader.getResource("classpath:" + reportParameters.getReportEnum().getReportTemplateName()).getURI().getPath();
			JasperPrint jasperPrint = reportService.generateJasperPrint(jasperFilePath, reportParameters.getReportParameterMap());			
			ServletOutputStream stream = response.getOutputStream();			
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			
			FacesContext.getCurrentInstance().responseComplete();	
			
		} catch (Exception e) {
			log.error("Error while generating the report " + e.getMessage(), e);
		}		
    }		
}
