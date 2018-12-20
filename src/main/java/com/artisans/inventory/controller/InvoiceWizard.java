/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.ShipmentVO;
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
	private ReferenceDataController referenceDataController;	
	
	@Autowired
	private ApplicationConfiguration configUtil;
		
	private List<SupplierVO> supplierVOList;
	
	private List<CourierVO> courierVOList;
	
	private InvoiceVO invoiceVO;
	
	private List<PaymentVO> invoicePaymentVOList;
		
	private List<ShipmentVO> shipmentVOList;	
	
	private List<PaymentVO> shipmentPaymentVOList;
	
	private List<ProductVO> productVOList;
	
	private boolean skip;
	
	private int selectedSupplierId; 
	
	private Double totalInvoicePaymentAmount;
	
	
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{
		createNewInvoice();
				
		//Get all Suppliers
		setSupplierVOList(referenceDataController.getSupplierVOList());
		
		//Get All Couriers
		setCourierVOList(referenceDataController.getCourierVOList());
		
		//Get All Products
		setProductVOList(referenceDataController.getProductVOList());		
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
		invoiceVO = new InvoiceVO();
		
		PaymentVO paymentVO  = new PaymentVO();
		ShipmentVO shipmentVO = new ShipmentVO();	
		shipmentVO.setShipmentNumber(null != invoiceVO.getShipmentsVO() ? invoiceVO.getShipmentsVO().size()+1 : 1);
		
		LinkedHashSet<PaymentVO> invPayments = new LinkedHashSet<PaymentVO>();		
		paymentVO.setPaymentType("INVOICE");
		invPayments.add(paymentVO);		
		invoiceVO.setPaymentsVO(new HashSet<PaymentVO>(invPayments));
		
		LinkedHashSet<ShipmentVO> invShipments = new LinkedHashSet<ShipmentVO>();
		invShipments.add(shipmentVO);		
		invoiceVO.setShipmentsVO(new HashSet<ShipmentVO>(invShipments));			
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
     * Save Invoice,Invoice Payments And shipments Data
     */
    public void saveInvoiceData() 
    {
    	System.out.println(invoiceVO);
    }
    
    /**
     * Methos to convert USD TO GBP and update the total payment Amount
     */
    public void updateInvoiceAmountBasedoUSD() 
    {
    	Double invAmount = 0.0;
    	
    	for(PaymentVO payment : getInvoiceVO().getPaymentsVO()) {
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
	 * @return the courierVOList
	 */
	public List<CourierVO> getCourierVOList() {
		return courierVOList;
	}


	/**
	 * @param courierVOList the courierVOList to set
	 */
	public void setCourierVOList(List<CourierVO> courierVOList) {
		this.courierVOList = courierVOList;
	}


	/**
	 * @return the invoiceVO
	 */
	public InvoiceVO getInvoiceVO() {
		return invoiceVO;
	}


	/**
	 * @param invoiceVO the invoiceVO to set
	 */
	public void setInvoiceVO(InvoiceVO invoiceVO) {
		this.invoiceVO = invoiceVO;
	}


	/**
	 * @return the invoicePaymentVOList
	 */
	public List<PaymentVO> getInvoicePaymentVOList() {
		return invoicePaymentVOList;
	}


	/**
	 * @param invoicePaymentVOList the invoicePaymentVOList to set
	 */
	public void setInvoicePaymentVOList(List<PaymentVO> invoicePaymentVOList) {
		this.invoicePaymentVOList = invoicePaymentVOList;
	}


	/**
	 * @return the shipmentVOList
	 */
	public List<ShipmentVO> getShipmentVOList() {
		return shipmentVOList;
	}


	/**
	 * @param shipmentVOList the shipmentVOList to set
	 */
	public void setShipmentVOList(List<ShipmentVO> shipmentVOList) {
		this.shipmentVOList = shipmentVOList;
	}


	/**
	 * @return the shipmentPaymentVOList
	 */
	public List<PaymentVO> getShipmentPaymentVOList() {
		return shipmentPaymentVOList;
	}


	/**
	 * @param shipmentPaymentVOList the shipmentPaymentVOList to set
	 */
	public void setShipmentPaymentVOList(List<PaymentVO> shipmentPaymentVOList) {
		this.shipmentPaymentVOList = shipmentPaymentVOList;
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
	 * @return the selectedSupplierId
	 */
	public int getSelectedSupplierId() {
		return selectedSupplierId;
	}


	/**
	 * @param selectedSupplierId the selectedSupplierId to set
	 */
	public void setSelectedSupplierId(int selectedSupplierId) {
		this.selectedSupplierId = selectedSupplierId;
	}


	/**
	 * @return the productVOList
	 */
	public List<ProductVO> getProductVOList() {
		return productVOList;
	}


	/**
	 * @param productVOList the productVOList to set
	 */
	public void setProductVOList(List<ProductVO> productVOList) {
		this.productVOList = productVOList;
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
	
	

}
