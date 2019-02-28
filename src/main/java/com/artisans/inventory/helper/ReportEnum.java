/**
 * 
 */
package com.artisans.inventory.helper;

/**
 * @author bjacob
 *
 */
public enum ReportEnum {

	INVOICE("_invoice_", "invoice.jasper"),
	
	FULL_INVENTORY("_full_inventory_", "inventoryReport.jasper");
	
	
	
	
	String reportName;
	
	String reportTemplateName;
	
	
	ReportEnum(String name, String templateName) {
		this.reportName=name;
		this.reportTemplateName= templateName;
	}

	/**
	 * @return the reportName
	 */
	public String getReportName() {
		return reportName;
	}


	/**
	 * @return the reportTemplateName
	 */
	public String getReportTemplateName() {
		return reportTemplateName;
	}
	
	
	
}
