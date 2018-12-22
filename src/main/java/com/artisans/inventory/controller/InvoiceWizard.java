/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author bjacob
 *
 */
@Scope(value = "session") 
@Component(value = "InvoiceWizard")
public class InvoiceWizard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	StandingDataService standingDataService;	
	
	@Autowired
	InvoiceService invoiceService;
	
	//@Autowired
	//private ReferenceDataController referenceDataController;	
	
	@Autowired
	private ApplicationConfiguration configUtil;
		
	
	private boolean skip;
	
	private Double totalInvoicePaymentAmount;
		//	
	private Integer selectedInvoiceId;
	
	private SupplierVO selectedSupplierVO;
	
	private InvoiceVO selectedInvoiceVO;
	
	private List<SupplierVO> supplierVOList;
	
	private List<InvoiceVO> supplierInvoiceList;
	
			
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{
		createNewInvoice();
				
		//Get all Suppliers
		//setSupplierVOList(referenceDataController.getSupplierVOList());
		
		//Get All Couriers
		//setCourierVOList(referenceDataController.getCourierVOList());
		
		//Get All Products
		//setProductVOList(referenceDataController.getProductVOList());		
	}
	
	
	public boolean isSkip() {
        return skip;
    }
 	
	public String onFlowProcess(FlowEvent flowEvent) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {        	
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
        	else 
        	{
        		PrimeFaces.current().executeScript(queryScript);  
        		return flowEvent.getNewStep();        		
        	}
        }
    }
	
	private void createNewInvoice() 
	{
		//invoiceVO = new InvoiceVO();
		
/*		//Create new Invoice Payment
		LinkedHashSet<PaymentVO> invoicePayments = new LinkedHashSet<PaymentVO>();
		
		PaymentVO invoicePaymentVO  = new PaymentVO();
		invoicePaymentVO.setPaymentType("INVOICE");
		invoicePaymentVO.setInvoiceVO(invoiceVO);		
		invoicePayments.add(invoicePaymentVO);			
		invoiceVO.setPaymentsVO(invoicePayments);
		
		//Create new Shipment	
		LinkedHashSet<ShipmentVO> invoiceShipments = new LinkedHashSet<ShipmentVO>();	
		
		ShipmentVO shipmentVO = new ShipmentVO();	
		shipmentVO.setShipmentNumber(null != invoiceVO.getShipmentsVO() ? invoiceVO.getShipmentsVO().size()+1 : 1);
		shipmentVO.setInvoiceVO(invoiceVO);
		invoiceShipments.add(shipmentVO);
		
		invoiceVO.setShipmentsVO(invoiceShipments);
		
		//Create new Shipment Payment
		PaymentVO shipmentPaymentVO  = new PaymentVO();
		shipmentPaymentVO.setPaymentType("SHIPMENT");
		shipmentPaymentVO.setShipmentVO(shipmentVO);
								
		LinkedHashSet<PaymentVO> shipmentPayments = new LinkedHashSet<PaymentVO>();
		shipmentPayments.add(shipmentPaymentVO);		
		shipmentVO.setPaymentVO(shipmentPayments);*/
					
	}
	
    /**
     * Invoked on selection of Invoice
     */
    public void addNewInvoice() {
    	if(null != getSelectedInvoiceId()) {    		
    		if(getSelectedInvoiceId() == 0) {
        		//Add New Invoice
        		selectedInvoiceVO = new InvoiceVO();
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
		List<InvoiceVO> invoiceVOList = invoiceService.findAllActiveInvoicesForSupplier(getSelectedSupplierVO());
		setSupplierInvoiceList(invoiceVOList);
	}
	
    /**
     * Update Group Name
     * @param event
     */
    public void onPaymentsEdit(RowEditEvent event) 
    {
    	PaymentVO paymentVO = (PaymentVO) event.getObject();   
    	System.out.println(paymentVO);
    }	
    
    /**
     * Update Group Name
     * @param event
     */
    public void onPaymentsCancel(RowEditEvent event) 
    {

    }    
    
    /**
     * Update Group Name
     * @param event
     */
    public void onShipmentsEdit(RowEditEvent event) 
    {

    }	
    
    /**
     * Update Group Name
     * @param event
     */
    public void onShipmentsCancel(RowEditEvent event) 
    {

    }  
    
    
    /**
     * Update Group Name
     * @param event
     */
    public void onShipmentPaymentEdit(RowEditEvent event) 
    {

    }	
    
    /**
     * Update Group Name
     * @param event
     */
    public void onShipmentPaymentCancel(RowEditEvent event) 
    {

    }     
    
    /**
     * Save Invoice,Invoice Payments And shipments Data
     */
    public void saveInvoiceData() 
    {
    	//System.out.println(invoiceVO);
    }
    
    /**
     * Methos to convert USD TO GBP and update the total payment Amount
     */
    public void updateInvoiceAmountBasedoUSD() 
    {
    	Double invAmount = 0.0;
    	
    	for(PaymentVO payment : getSelectedInvoiceVO().getPaymentsVO()) {
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
	 * @return the supplierVOList
	 */
	public List<SupplierVO> getSupplierVOList() {
		return supplierVOList;
	}


	/**
	 * @param supplierVOList the supplierVOList to set
	 */
	public void setSupplierVOList(List<SupplierVO> supplierVOList) {
		this.supplierVOList = supplierVOList;
	}

	/**
	 * @param skip the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
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
	
	

}
