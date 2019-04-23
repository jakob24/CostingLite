/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.apache.commons.math3.util.Precision;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.helper.ReportEnum;
import com.artisans.inventory.helper.UIMessageHelper;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ReportParameters;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author bjacob
 *
 */
@Scope(value = "session") 
@Component(value = "InvoiceWizard")
public class InvoiceWizard extends BaseWizard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	InvoiceService invoiceService;
						
	private Double totalInvoicePaidAmount;
	
	private Double totalInvoiceToPayAmount;
	
	private boolean enableAddInvoiceButton;
		//	
	private Integer selectedInvoiceId;
	
	private SupplierVO selectedSupplierVO;
	
	private InvoiceVO selectedInvoiceVO;
	
	private List<InvoiceVO> supplierInvoiceList;
	
	private boolean invoicePaymentComplete;
	
	@Autowired
	private ReportsController reportsController;
	
			
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
	public void invokedFromMenu() {
		resetAndNavigateTo(INVOICE_ENTRY_PAGE);
	}
	

 	/**
 	 * Invoked for Next/Previous step of the flow
 	 * @param flowEvent
 	 * @return
 	 */
	public String onFlowProcess(FlowEvent flowEvent) {      	
    	String queryScriptConfirm= "PF('wizard').backNav.show();PF('wizard').nextNav.hide();PF('wizard').cfg.showNavBar = false;";
    	String queryFirstTab = "PF('wizard').nextNav.show();PF('wizard').cfg.showNavBar = true;";
    	String queryScript= "PF('wizard').backNav.show();PF('wizard').nextNav.hide();PF('wizard').cfg.showNavBar = false;";
    	
    	if (flowEvent.getNewStep().equals("confirmTab"))
    	{
    		PrimeFaces.current().executeScript(queryScriptConfirm);  
    		return flowEvent.getNewStep();
    	}
    	else if (flowEvent.getNewStep().equals("InvoiceTab"))
    	{
    		PrimeFaces.current().executeScript(queryFirstTab);  
    		return flowEvent.getNewStep();
    	}      
    	else if (flowEvent.getNewStep().equals("InvoicePaymentTab"))
    	{
    		calculatePaymentsAndAddPayButton();
    		if(null == getSelectedInvoiceVO() || null == getSelectedInvoiceVO().getPayment() || getSelectedInvoiceVO().getPayment().isEmpty()) {
    			PrimeFaces.current().executeScript(queryScript);  
    		} else {
    			PrimeFaces.current().executeScript(queryFirstTab);  
    		}
    		return flowEvent.getNewStep();
    	}     
    	else 
    	{
    		PrimeFaces.current().executeScript(queryScript);  
    		return flowEvent.getNewStep();        		
    	}
        
    }	
	
    /**
     * Invoked on selection of Invoice on Invoice Tab
     */
    public void addNewInvoice() {
    	if(null != getSelectedInvoiceId()) {    		
    		if(getSelectedInvoiceId() == 0) {
        		//Add New Invoice
        		selectedInvoiceVO = new InvoiceVO();
        		selectedInvoiceVO.setInvoiceDate(new Date());
        		selectedInvoiceVO.setSupplier(getSelectedSupplierVO());
        		selectedInvoiceVO.setShipmentComplete(SHIPMENT_NOT_COMPLETE);
        	} else if(null != getSelectedInvoiceId()) {
        		//Get Selected Invoice details
        		selectedInvoiceVO = invoiceService.findInvoice(getSelectedInvoiceId());
        	}     		
    	}
    	else {
    		selectedInvoiceVO = null;
    	}
    }    
    
	/**
	 * Get All Invoices for the supplier
	 */
	public void findAllInvoicesForSupplier()
	{
		setSelectedInvoiceId(null);
		setSelectedInvoiceVO(null);
		setSupplierInvoiceList(findAllInvoicesForSupplier(getSelectedSupplierVO()));		
	}
	
	/**
	 * Method to calculate existing payments for invoice and enable/disable add new payments
	 * 
	 */
	private void calculatePaymentsAndAddPayButton() 
	{
		double invoiceAmount = getSelectedInvoiceVO().getInvAmount()==null? 0: getSelectedInvoiceVO().getInvAmount();
		double invoiceAmountUSD = getSelectedInvoiceVO().getInvAmountUsd() ==null? 0: getSelectedInvoiceVO().getInvAmountUsd();
		
		double paidAmount = 0;
		double paidAmountUSD = 0;
		
		if(null != getSelectedInvoiceVO().getPayment() && ! getSelectedInvoiceVO().getPayment().isEmpty()) {
			List<PaymentVO> paymentList = new ArrayList<PaymentVO>(getSelectedInvoiceVO().getPayment());
			paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase(PAY_TYPE_INVOICE));
			
			for(PaymentVO payment : paymentList)
			{
				paidAmountUSD += payment.getAmountUsd()==null? 0:payment.getAmountUsd();
				paidAmount += payment.getAmount()==null? 0:payment.getAmount();
			}			
		}
				
		setTotalInvoicePaidAmount(invoiceAmountUSD > 0 ? paidAmountUSD : paidAmount);
		setTotalInvoiceToPayAmount(invoiceAmount==0 ? invoiceAmountUSD :invoiceAmount);
		
		if(invoiceAmount == 0) {
			//Was paid in USD
			if (paidAmountUSD < invoiceAmountUSD){
				setEnableAddInvoiceButton(true);
			}else {
				setEnableAddInvoiceButton(false);
			}			
		}
		else
		{
			if(paidAmount < invoiceAmount ){
				setEnableAddInvoiceButton(true);
			}else {
				setEnableAddInvoiceButton(false);
			}			
		}
	}
	
	/**
	 * Method to add a  new Invoice Payment to the Invoice
	 */
	public void addNewInvoicePayment() 
	{
		PaymentVO invoicePaymentVO = new PaymentVO();
		double totalPaidIinvAmountUSD = 0; 
		double totalPaidIinvAmount = 0; 
		double totalPayment = 0;
		
		if(null != getSelectedInvoiceVO().getPayment() && ! getSelectedInvoiceVO().getPayment().isEmpty()) {
			List<PaymentVO> paymentList = new ArrayList<PaymentVO>(getSelectedInvoiceVO().getPayment());
			paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase(PAY_TYPE_INVOICE));
			
			for(PaymentVO payment : paymentList)
			{
				totalPaidIinvAmountUSD += payment.getAmountUsd();
				totalPaidIinvAmount += payment.getAmount();
				totalPayment += payment.getAmount();
			}
			
			//Add the next invoice payment
			getSelectedInvoiceVO().getPayment().add(invoicePaymentVO);
		}
		else
		{
			List<PaymentVO> invoicePayments = new ArrayList<PaymentVO>();
			invoicePayments.add(invoicePaymentVO);
			getSelectedInvoiceVO().setPayment(invoicePayments);
		}
		invoicePaymentVO.setAmountUsd(getSelectedInvoiceVO().getInvAmountUsd()==null? 0:getSelectedInvoiceVO().getInvAmountUsd()-totalPaidIinvAmountUSD);
		invoicePaymentVO.setAmount(getSelectedInvoiceVO().getInvAmount()==null? 0: getSelectedInvoiceVO().getInvAmount()-totalPaidIinvAmount);		
		invoicePaymentVO.setPaymentType(PAY_TYPE_INVOICE);
		setTotalInvoicePaidAmount(totalPayment);
		
		calculatePaymentsAndAddPayButton();
	}
	
	
	
    /**
     * Invoked when user edits the invoice payments row
     * @param event
     */
    public void onPaymentsEdit(RowEditEvent event) 
    {
    	PaymentVO paymentVO = (PaymentVO) event.getObject();  
    	if(null == paymentVO.getPaymentId() || paymentVO.getPaymentId().intValue() == 0) {
    		//New payment, dont do anything
    	} else {
    		
    		//Update Invoice details
    		invoiceService.updateInvoice(paymentVO.getInvoice());
    		
    		//Update the Invoice Payment
    		paymentVO = invoiceService.updateInvoicePayment(paymentVO);
    		refreshSelectedInvoiceData(paymentVO.getInvoice().getInvoiceId());
    	}    	
    	calculatePaymentsAndAddPayButton();
    }	
    
    /**
     * Invoked when user deletes the invoice payments row
     * @param event
     */
    public void onPaymentsCancel(RowEditEvent event) 
    {
    	PaymentVO paymentVO = (PaymentVO) event.getObject();  
    	if(null == paymentVO.getPaymentId() || paymentVO.getPaymentId().intValue() == 0) {
    		//Deletion of unsaved invoice
    		getSelectedInvoiceVO().getPayment().remove(paymentVO);
    	} else {
    		invoiceService.deleteInvoicePayment(paymentVO);
    	}
    	calculatePaymentsAndAddPayButton();
    }    
    
    /**
     * Save Invoice,Invoice Payments
     */
    public void saveInvoiceData() 
    {    	    	
    	if(verifyInvoiceData(getSelectedInvoiceVO())) {    	
        	if(isInvoicePaymentComplete()) {
        		getSelectedInvoiceVO().setDatePaid(BeanHelper.getToday());
        	}        	
        	InvoiceVO invoiceVO = invoiceService.saveInvoiceAndPayments(getSelectedInvoiceVO());
        	UIMessageHelper.getInstance().displayUIMessage("invoice_saved", FacesMessage.SEVERITY_INFO);    		
        	
        	//Refresh Data on screen
        	refreshSelectedInvoiceData(invoiceVO.getInvoiceId());        	
    	}
    }
    
    /**
     * Method to get latest data from db
     * @param invoiceId
     */
    private void refreshSelectedInvoiceData(Integer invoiceId) {
    	setSelectedInvoiceVO(invoiceService.findInvoice(invoiceId));
    }
    
    
    /**
     * Method to check the integrity of the invoice payments data
     */
    private boolean verifyInvoiceData(InvoiceVO invoiceVO) {
    	Double invAmountUSD = 0D;
    	Double invAmount =0D;    	
    	Double totalPaymentAmountUSD = 0D;
    	Double totalPayAmount =0D;    	
    	boolean invoiceInUSD = isInvoiceInUSD(invoiceVO);
    	boolean valid = true;
    	
    	if(null != invoiceVO.getInvAmountUsd() && invoiceVO.getInvAmountUsd().doubleValue() > 0) {
    		invAmountUSD = invoiceVO.getInvAmountUsd();
    	} else {
    		invAmount = invoiceVO.getInvAmount();
    	}
    	
    	//Iterate through Payments
    	for(PaymentVO paymentVO : invoiceVO.getPayment()) {
    		if((invoiceInUSD)) {
    			totalPaymentAmountUSD += paymentVO.getAmountUsd();
    			totalPayAmount += paymentVO.getAmount();
    			
    			if(paymentVO.getAmount() - (paymentVO.getAmountUsd()/paymentVO.getGbpToUsd()) >1 ) {
    				//conversion Difference is greater than 1, Flag up error
    				valid = false;
    				UIMessageHelper.getInstance().displayUIMessage("invoice_payment_incorrect1", FacesMessage.SEVERITY_ERROR);  
    			}
    		}
    	}    	
    	if((invoiceInUSD)) {
        	if(totalPaymentAmountUSD > invAmountUSD) {
        		//Paying more USD, Flag up error 
        		UIMessageHelper.getInstance().displayUIMessage("invoice_payment_incorrect2", FacesMessage.SEVERITY_ERROR);  
        		valid = false;        		
        	}
    	} else if(totalPayAmount > invAmount) { 
    		//Paying more GBP, Flag up error
    		UIMessageHelper.getInstance().displayUIMessage("invoice_payment_incorrect31", FacesMessage.SEVERITY_ERROR);  
    		valid = false;
    	}   	    	
    	return valid;
    }
    
    
    /**
     * Method to convert USD TO GBP and update the total payment Amount
     */
    public void updateInvoiceAmountBasedoUSD() 
    {
    	Double invAmount = 0.0;    	
    	for(PaymentVO payment : getSelectedInvoiceVO().getPayment()) {
    		if ((null == payment.getPaymentId() || payment.getPaymentId().intValue() == 0)  && payment.getPaymentType().equalsIgnoreCase(PAY_TYPE_INVOICE)) {
    			//Updating only unsaved Data    			
				if(null != payment.getAmountUsd() && null != payment.getGbpToUsd()) {
					payment.setAmount(Precision.round(payment.getAmountUsd()/payment.getGbpToUsd(), 2));    				
    			}    			
    		} else if (null != payment.getAmountUsd()) {
    			payment.setAmount(Precision.round(payment.getAmountUsd()/payment.getGbpToUsd(), 2));  
    		}
    		invAmount += payment.getAmount();
    	}
    	setTotalInvoicePaidAmount(Precision.round(invAmount, 2));
    }
    
    
    public void onUpdateGBPPrice() {
    	//TODO
    }
    
    
    /** Logic to decide enabling or disabling of Add SHipments Button
     * Only enabled if invoice and all payments have been saved.
     * @return
     */
    public boolean isEnableAddShipmentsButton() {
    	boolean enable = true;
    	if(getSelectedInvoiceVO().getInvoiceId() == 0 || (null == getSelectedInvoiceVO().getPayment() || getSelectedInvoiceVO().getPayment().isEmpty())) {
    		enable =  false;
    	} else {
    		for(PaymentVO paymentVO : getSelectedInvoiceVO().getPayment()) {
    			if(null == paymentVO.getPaymentId() || paymentVO.getPaymentId().intValue() == 0) {   				
    				enable = false;
    				break;
    			}
    		}
    	}    	
    	return enable;
    }

    /**
     * Method to navigate to the shipments page
     */
    public void addShipment() {
		 ShipmentWizard shipmentWizard = BeanHelper.findBean("ShipmentWizard");
		 //Pre populate Data for Shipment Wizard 
		 shipmentWizard.invokeFromInvoice();
		 shipmentWizard.setInvokedFromInvoiceWizard(true);    		 
    }
    
    
    /**
     * Generate Invoice Report
     */
    public void generateInvoiceReport() {
    	
    	if(null != getSelectedInvoiceId() && getSelectedInvoiceId().intValue() > 0 ) {    		
    		ReportParameters reportParameters = new ReportParameters();
    		reportParameters.setReportEnum(ReportEnum.INVOICE);
    		reportParameters.setReportPrefix(getSelectedInvoiceVO().getInvoiceNumber());
    		reportParameters.setReportSuffix(BeanHelper.getDisplayDate(getSelectedInvoiceVO().getInvoiceDate()));
    		
    		LinkedHashMap<String, Object> reportParams = new LinkedHashMap<>();    		
    		reportParams.put("invoice_id", getSelectedInvoiceVO().getInvoiceId()); 
    		reportParameters.setReportParameterMap(reportParams);    		
    		reportsController.generateReport(reportParameters);
    	}
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

	/**
	 * @return the enableAddInvoiceButton
	 */
	public boolean isEnableAddInvoiceButton() {
		return enableAddInvoiceButton;
	}

	/**
	 * @param enableAddInvoiceButton the enableAddInvoiceButton to set
	 */
	public void setEnableAddInvoiceButton(boolean enableAddInvoiceButton) {
		this.enableAddInvoiceButton = enableAddInvoiceButton;
	}

	/**
	 * @return the invoicePaymentComplete
	 */
	public boolean isInvoicePaymentComplete() {
		return invoicePaymentComplete;
	}

	/**
	 * @param invoicePaymentComplete the invoicePaymentComplete to set
	 */
	public void setInvoicePaymentComplete(boolean invoicePaymentComplete) {
		this.invoicePaymentComplete = invoicePaymentComplete;
	}

	/**
	 * @return the totalInvoicePaidAmount
	 */
	public Double getTotalInvoicePaidAmount() {
		return totalInvoicePaidAmount;
	}

	/**
	 * @param totalInvoicePaidAmount the totalInvoicePaidAmount to set
	 */
	public void setTotalInvoicePaidAmount(Double totalInvoicePaidAmount) {
		this.totalInvoicePaidAmount = totalInvoicePaidAmount;
	}

	/**
	 * @return the totalInvoiceToPayAmount
	 */
	public Double getTotalInvoiceToPayAmount() {
		return totalInvoiceToPayAmount;
	}

	/**
	 * @param totalInvoiceToPayAmount the totalInvoiceToPayAmount to set
	 */
	public void setTotalInvoiceToPayAmount(Double totalInvoiceToPayAmount) {
		this.totalInvoiceToPayAmount = totalInvoiceToPayAmount;
	}		
	
	
	
}
