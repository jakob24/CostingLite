/**
 * 
 */
package com.artisans.inventory.helper;

/**
 * @author bjacob
 *
 */
public enum ReportEnum {

	INVOICE("_Invoice_", "invoice.jasper"),
	
	FULL_INVENTORY("_Full_Inventory", "inventoryReport.jasper"),
	
	SHIPMENT_COSTING("_Shipment_Costing_", "costings.jasper");
	
			
	
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
