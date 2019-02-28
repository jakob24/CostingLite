package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.artisans.inventory.helper.ReportEnum;

public class ReportParameters implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String reportSuffix;
	
	private String reportPrefix;
	
	private ReportEnum reportEnum;
	
	private LinkedHashMap<String, Object> reportParameterMap;
	
	
	public ReportParameters() {
		reportSuffix = "";
		reportPrefix = "";
	}

	/**
	 * @return the reportSuffix
	 */
	public String getReportSuffix() {
		return reportSuffix;
	}

	/**
	 * @param reportSuffix the reportSuffix to set
	 */
	public void setReportSuffix(String reportSuffix) {
		this.reportSuffix = reportSuffix;
	}

	/**
	 * @return the reportPrefix
	 */
	public String getReportPrefix() {
		return reportPrefix;
	}

	/**
	 * @param reportPrefix the reportPrefix to set
	 */
	public void setReportPrefix(String reportPrefix) {
		this.reportPrefix = reportPrefix;
	}

	/**
	 * @return the reportEnum
	 */
	public ReportEnum getReportEnum() {
		return reportEnum;
	}

	/**
	 * @param reportEnum the reportEnum to set
	 */
	public void setReportEnum(ReportEnum reportEnum) {
		this.reportEnum = reportEnum;
	}

	/**
	 * @return the reportParameterMap
	 */
	public LinkedHashMap<String, Object> getReportParameterMap() {
		return reportParameterMap;
	}

	/**
	 * @param reportParameterMap the reportParameterMap to set
	 */
	public void setReportParameterMap(LinkedHashMap<String, Object> reportParameterMap) {
		this.reportParameterMap = reportParameterMap;
	}	
		
}
