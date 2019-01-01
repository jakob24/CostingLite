/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
			
	private Double totalInvoicePaymentAmount;
	
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
 	 * Invoked for Next/Previous step of the flow
 	 * @param flowEvent
 	 * @return
 	 */
	public String onFlowProcess(FlowEvent flowEvent) {      	
    	String queryScriptConfirm= "PF('wizard').backNav.show();PF('wizard').nextNav.hide();PF('wizard').cfg.showNavBar = false;";
    	String queryFirstTab = "PF('wizard').backNav.hide();PF('wizard').nextNav.show();PF('wizard').cfg.showNavBar = true;";
    	String queryScript= "PF('wizard').backNav.show();PF('wizard').nextNav.hide();PF('wizard').cfg.showNavBar = false;$('.ui-datatable-data tr').last().find('span.ui-icon-pencil').each(function(){$(this).click()});";
    	
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
			paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase("INVOICE"));
			
			for(PaymentVO payment : paymentList)
			{
				paidAmountUSD += payment.getAmountUsd()==null? 0:payment.getAmountUsd();
				paidAmount += payment.getAmount()==null? 0:payment.getAmount();
			}			
		}
		setTotalInvoicePaymentAmount(paidAmount);
		
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
			paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase("INVOICE"));
			
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
		invoicePaymentVO.setPaymentType("INVOICE");
		setTotalInvoicePaymentAmount(totalPayment);
		
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
    		if (payment.getPaymentId() == 0  && payment.getPaymentType().equalsIgnoreCase("INVOICE")) {
    			//Updating only unsaved Data    			
				if(null != payment.getAmountUsd() && null != payment.getGbpToUsd()) {
					payment.setAmount(payment.getAmountUsd()/payment.getGbpToUsd());    				
    			}    			
    		}
    		invAmount += payment.getAmount();
    	}
    	setTotalInvoicePaymentAmount(invAmount);
    }

    /**
     * Method to navigate to the shipments page
     */
    public void addShipment() {
    	 try {
    		 ShipmentWizard shipmentWizard = BeanHelper.findBean("ShipmentWizard");
    		 //Pre populate Data for Shipment Wizard 
    		 shipmentWizard.invokeFromInvoice();
    		 shipmentWizard.setInvokedFromInvoiceWizard(true);    		 
    		 FacesContext.getCurrentInstance().getExternalContext().redirect("shipments.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	 * @return the totalInvoicePaymentAmount
	 */
	public Double getTotalInvoicePaymentAmount() {
		return totalInvoicePaymentAmount;
	}


	/**
	 * @param totalInvoicePaymentAmount the totalInvoicePaymentAmount to set
	 */
	public void setTotalInvoicePaymentAmount(Double totalInvoicePaymentAmount) {
		this.totalInvoicePaymentAmount = totalInvoicePaymentAmount;
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
	
}
