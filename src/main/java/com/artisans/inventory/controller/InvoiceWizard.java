/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.helper.UIMessageHelper;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
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
			
	@Autowired
	private ApplicationConfiguration configUtil;
			
	private Double totalInvoicePaidAmount;
	
	private Double totalInvoiceToPayAmount;
	
	private boolean enableAddInvoice;
		//	
	private Integer selectedInvoiceId;
	
	private SupplierVO selectedSupplierVO;
	
	private InvoiceVO selectedInvoiceVO;
	
	private List<InvoiceVO> supplierInvoiceList;
	
	private boolean invoicePaymentComplete;
	
			
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
    		PrimeFaces.current().executeScript(queryScript);  
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
		setTotalInvoicePaidAmount(paidAmount);
		setTotalInvoiceToPayAmount(invoiceAmount==0 ? invoiceAmountUSD :invoiceAmount);
		
		if(invoiceAmount == 0) {
			//Was paid in USD
			if (paidAmountUSD < invoiceAmountUSD){
				setEnableAddInvoice(true);
			}else {
				setEnableAddInvoice(false);
			}			
		}
		else
		{
			if(paidAmount < invoiceAmount ){
				setEnableAddInvoice(true);
			}else {
				setEnableAddInvoice(false);
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
     * Update Group Name
     * @param event
     */
    public void onPaymentsEdit(RowEditEvent event) 
    {
    	PaymentVO paymentVO = (PaymentVO) event.getObject();  
    	if(paymentVO.getPaymentId() == 0)
    	{
    		//New payment, add to invoice payments
    		getSelectedInvoiceVO().getPayment().add(paymentVO);
    	}    	
    	calculatePaymentsAndAddPayButton();
    }	
    
    /**
     * Update Group Name
     * @param event
     */
    public void onPaymentsCancel(RowEditEvent event) 
    {
    }    
    
    /**
     * Save Invoice,Invoice Payments
     */
    public void saveInvoiceData() 
    {    	
    	if(isInvoicePaymentComplete()) {
    		getSelectedInvoiceVO().setDatePaid(BeanHelper.getToday());
    	}
    	InvoiceVO savedInvoiceVO = invoiceService.SaveInvoiceAndPayments(getSelectedInvoiceVO());
    	UIMessageHelper.getInstance().displayUIMessage("invoice_saved", FacesMessage.SEVERITY_INFO);
    }
    
    /**
     * Method to convert USD TO GBP and update the total payment Amount
     */
    public void updateInvoiceAmountBasedoUSD() 
    {
    	Double invAmount = 0.0;
    	
    	for(PaymentVO payment : getSelectedInvoiceVO().getPayment()) {
    		if (payment.getPaymentId() == 0  && payment.getPaymentType().equalsIgnoreCase(PAY_TYPE_INVOICE)) {
    			//Updating only unsaved Data    			
				if(null != payment.getAmountUsd() && null != payment.getGbpToUsd()) {
					payment.setAmount(payment.getAmountUsd()/payment.getGbpToUsd());    				
    			}    			
    		}
    		invAmount += payment.getAmount();
    	}
    	setTotalInvoicePaidAmount(invAmount);
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
	 * @return the configUtil
	 */
	public ApplicationConfiguration getConfigUtil() {
		return configUtil;
	}


	/**
	 * @param configUtil the configUtil to set
	 */
	public void setConfigUtil(ApplicationConfiguration configUtil) {
		this.configUtil = configUtil;
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
	 * @return the enableAddInvoice
	 */
	public boolean isEnableAddInvoice() {
		return enableAddInvoice;
	}

	/**
	 * @param enableAddInvoice the enableAddInvoice to set
	 */
	public void setEnableAddInvoice(boolean enableAddInvoice) {
		this.enableAddInvoice = enableAddInvoice;
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
