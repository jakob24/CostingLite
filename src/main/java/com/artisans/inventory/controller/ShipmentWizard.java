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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ProductShipmentHelper;
import com.artisans.inventory.helper.UIMessageHelper;
import com.artisans.inventory.service.api.InvoiceService;
import com.artisans.inventory.service.api.ShipmentService;
import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.ShipmentProductVO;
import com.artisans.inventory.vo.ShipmentVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 */
@Scope(value = "session") 
@Component(value = "ShipmentWizard")
public class ShipmentWizard extends BaseWizard implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	ShipmentService shipmentService;
	
	@Autowired
	InvoiceService invoiceService;
				
	@Autowired
	private InvoiceWizard invoiceWizard;
	
	private SupplierVO selectedSupplierVO;	
		
	private InvoiceVO selectedInvoiceVO;

	private Integer selectedInvoiceId;
	
	private List<InvoiceVO> supplierInvoiceList;
		
	private ShipmentVO selectedShipment;
	
	private boolean invokedFromInvoiceWizard;
	
	private ShipmentVO addNewShipment;
	
	private ProductVO selectedProductVO;
	
	private boolean invokedFromShipmentWizard;
	
	private ShipmentProductVO selectedShipmentProductVO;
	
	
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{	
		addNewShipment = new ShipmentVO();
		addNewShipment.setShipmentId(0);
	}
	
	/**
	 * Method to reset session and navigate to the link page
	 */
	public void invokedFromMenu() {
		resetAndNavigateTo(SHIPMENT_ENTRY_PAGE);
	}
	
	/**
	 * Method called when invoked from the invocie screen.
	 * Most of the data is pre populated
	 */
	public void invokeFromInvoice() {
		//Get selected data from InvoiceWizard
		setSelectedSupplierVO(invoiceWizard.getSelectedSupplierVO());		
		setSupplierInvoiceList(findAllInvoicesForSupplier(getSelectedSupplierVO()));		
		setSelectedInvoiceId(invoiceWizard.getSelectedInvoiceId());		
		setSelectedInvoiceVO(invoiceWizard.getSelectedInvoiceVO());			
		getSelectedInvoiceVO().setShipment(shipmentService.findAllShipmentsForInvoice(getSelectedInvoiceVO()));
		setSelectedShipment(null);
	}
	
	/**
	 * Invoked on selection of supplier
	 */
	public void findAllInvoicesForSupplier() {		
		setSelectedInvoiceVO(null);
		setSelectedInvoiceId(null);		
		setSelectedShipment(null);
		setSelectedShipmentProductVO(null);
		setSupplierInvoiceList(findAllInvoicesForSupplier(getSelectedSupplierVO()));
	}
	
	/**
	 * Find all shipments for the invoice. Invoked on selection of Invoice
	 * @param invoiceVO
	 */
	public void findAllShipmentsForInvoice() {
		
		//Clear all shipments
		setSelectedShipment(null);			
		
		if(null != getSelectedInvoiceId() && getSelectedInvoiceId() > 0) {			
			//Get the selected InvoiceVO
			InvoiceVO invoiceVO = invoiceService.findInvoice(getSelectedInvoiceId());
			setSelectedInvoiceVO(invoiceVO);
		
			List <ShipmentVO> shipmentList = shipmentService.findAllShipmentsForInvoice(invoiceVO);
			
			if(null == shipmentList || shipmentList.isEmpty()) {
				shipmentList = new ArrayList<ShipmentVO>();					
			}
			getSelectedInvoiceVO().setShipment(shipmentList);
		}
	}
	
	
	/**
	 * Method to retrieve all products for the shipment
	 */
	public void findAllproductsForShipment() {
		ShipmentVO selectedShipment = getSelectedShipment();		
		if(null != selectedShipment) {
			List<ShipmentProductVO> shipmentProductVOList = shipmentService.findAllproductsForShipment(selectedShipment);
			selectedShipment.setShipmentProduct(shipmentProductVOList); 
		}		
	}
	
	/**
	 * Invoked on selection of a shipment(From radio Button)
	 * @param selectEvent
	 */
    public void onShipmentRowSelect(SelectEvent selectEvent) {
       
        ShipmentVO shipmentVO = (ShipmentVO) selectEvent.getObject();
        setSelectedShipment(shipmentVO);        
    }
	
	
	/**
	 * Method invoked to create a new Invoice.
	 * Invoked on Add Shipment button'
	 */
	public void addNewShipment() {
		
		List<ShipmentVO> shipments = null;	

		//Add a new Shipment
		ShipmentVO shipmentVO = new ShipmentVO();
		shipmentVO.setShipmentDate(new Date());
		shipmentVO.setInvoice(getSelectedInvoiceVO());  
			
		//Add a new ShipmentVO	to existing List
		if(null != selectedInvoiceVO.getShipment() && ! selectedInvoiceVO.getShipment().isEmpty()) {
			shipments = selectedInvoiceVO.getShipment();     				
			shipmentVO.setShipmentNumber(selectedInvoiceVO.getShipment().size()+1);
			shipments.add(shipmentVO);
		}
		else {
			//Add First Shipment for the Invoice
			shipments = new ArrayList<ShipmentVO>();
			shipmentVO.setShipmentNumber(1);
  			shipments.add(shipmentVO);    
		}   		
		selectedInvoiceVO.setShipment(shipments); 
		setSelectedShipment(shipmentVO); 	
	}
		
	/**
	 * Method to save Shipment and all its payments
	 */
	public void saveshipmentData() {
		shipmentService.saveShipments(getSelectedInvoiceVO());
		UIMessageHelper.getInstance().displayUIMessage("shipment_saved", FacesMessage.SEVERITY_INFO);
	}
	
	/**
	 * Method invoked when a shipment product selected from the List for update
	 */
	public void onShipmentProductRowSelect(SelectEvent selectEvent) {
		//ShipmentProductVO shipmentProductVO = (ShipmentProductVO) selectEvent.getObject();
		//Do nothing
	}
	
	/**
	 * Method to update the Shipment record
	 * @param event
	 */
	public void onShipmentsEdit(RowEditEvent event) {
		//TODO
		ShipmentVO shipmentVO = (ShipmentVO) event.getObject(); 
		System.out.println(shipmentVO);
	}
	
	/**
	 * Method to delete a shipment and reorder the existing shipments
	 * @param event
	 */
	public void onDeleteShipment(RowEditEvent event) {		
		ShipmentVO shipmentVO = (ShipmentVO) event.getObject(); 
		shipmentService.deleteShipment(shipmentVO);
		
		//Fetch the data from db
		List <ShipmentVO> shipmentList = shipmentService.findAllShipmentsForInvoice(getSelectedInvoiceVO());		
		if(null == shipmentList || shipmentList.isEmpty()) {
			shipmentList = new ArrayList<ShipmentVO>();					
		}
		getSelectedInvoiceVO().setShipment(shipmentList);
		
		UIMessageHelper.getInstance().displayUIMessage("shipment_deleted", FacesMessage.SEVERITY_INFO);
	}
	
	/**
	 * Method to update the Shipment Payment record
	 * @param event
	 */
	public void onShipmentPaymentEdit(RowEditEvent event) {
		//TODO
		PaymentVO paymentVO = (PaymentVO) event.getObject(); 
		System.out.println(paymentVO);
	}
	
	/**
	 * Method to delete the Shipment Payment record
	 * @param event
	 */	
	public void onShipmentPaymentCancel(RowEditEvent event) {
		PaymentVO paymentVO = (PaymentVO) event.getObject(); 
		System.out.println(paymentVO);
	}	
	
		
	/**
	 * Add a new Shipment Payment
	 * @param shipmentVO
	 */
	public void addNewShipPayment(ShipmentVO shipmentVO) {
								
		//Iterate through the selectedInvoiceVO.shipment
		for(ShipmentVO shipment : selectedInvoiceVO.getShipment()) {
			if(shipment == shipmentVO) {				
				if(null != shipmentVO.getPayment() && ! shipmentVO.getPayment().isEmpty()) {
					shipmentVO.getPayment().add(createNewShipmentPayment());
				} else {
					List<PaymentVO> paymentList = new ArrayList<PaymentVO>();
					paymentList.add(createNewShipmentPayment());					
					shipmentVO.setPayment(paymentList);
				}			
			}
		}
	}
	
    /**
     * Method to convert USD TO GBP and update the total payment Amount
     */
    public void convertToGBP(PaymentVO payment) 
    {			
		if(null != payment.getAmountUsd() && null != payment.getGbpToUsd()) {
			payment.setAmount(payment.getAmountUsd()/payment.getGbpToUsd());    				
		}    			
    }	
	
 	/**
 	 * Invoked for Next/Previous step of the flow
 	 * @param flowEvent
 	 * @return
 	 */
	public String onFlowProcess(FlowEvent flowEvent) {      	
    	String queryScriptConfirm= "PF('wizard').backNav.show();PF('wizard').nextNav.hide();PF('wizard').cfg.showNavBar = false;";
    	String queryFirstTab = "PF('wizard').backNav.hide();PF('wizard').nextNav.show();PF('wizard').cfg.showNavBar = true;";
    	String queryScript= "PF('wizard').backNav.show();PF('wizard').cfg.showNavBar = false;";
    	
    	if (flowEvent.getNewStep().equals("confirmTab"))
    	{
    		PrimeFaces.current().executeScript(queryScriptConfirm);  
    		return flowEvent.getNewStep();
    	}
    	else if (flowEvent.getNewStep().equals("ShipmentTab"))
    	{
    		PrimeFaces.current().executeScript(queryFirstTab);  
    		return flowEvent.getNewStep();
    	}      
    	else if (flowEvent.getNewStep().equals("ShipmentPaymentTab"))
    	{
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
	 * Create a new blank Shipment payment
	 * @return
	 */
	private PaymentVO createNewShipmentPayment() {
		PaymentVO newShipPayment = new PaymentVO();
		newShipPayment.setAmountUsd(0D);
		newShipPayment.setGbpToUsd(0D);
		newShipPayment.setAmount(0D);
		newShipPayment.setOtherCharges(0D);
		newShipPayment.setBankCharges(0D);
		newShipPayment.setPaymentType(PAY_TYPE_SHIPMENT);
		return newShipPayment;
	}
	
	
	//*********Shipment Product *********************//
	
	/**
	 * Add a blank ShipmentProduct record to the SelectedShipment
	 * 
	 * @param producVO
	 */
	public void addNewShipmentProduct() {
		
		ProductVO productVO = getSelectedProductVO();
		
		if(isProductAlreadyAdded(productVO)) {
			UIMessageHelper.getInstance().displayUIMessage("product_already_added", FacesMessage.SEVERITY_INFO);
		}
		else {
			ShipmentProductVO shipmentProductVO = new ShipmentProductVO();
			shipmentProductVO.setShipment(getSelectedShipment());	
			shipmentProductVO.setProduct(productVO);
			
			shipmentProductVO = ProductShipmentHelper.populateDefaultProductValues(productVO, shipmentProductVO);
			List<ShipmentProductVO> shipmentProductVOList = new ArrayList<ShipmentProductVO>();
			
			if(null != getSelectedShipment().getShipmentProduct() && ! getSelectedShipment().getShipmentProduct().isEmpty()) {
				// Add the product to existing list 
				shipmentProductVOList = getSelectedShipment().getShipmentProduct();
				shipmentProductVOList.add(shipmentProductVO);			
			} else {
				//Create a new item and set in the getSelectedShipment().getShipmentProduct()		
				shipmentProductVOList = new ArrayList<ShipmentProductVO>();
				shipmentProductVOList.add(shipmentProductVO);
			}
			getSelectedShipment().setShipmentProduct(shipmentProductVOList);
			setSelectedShipmentProductVO(shipmentProductVO);			
		}
	}
	
	/**
	 * Prevent same product being added in the shipment list
	 * @param productVO
	 * @return
	 */
	private boolean isProductAlreadyAdded(ProductVO productVO ) {
		
		if(null != getSelectedShipment().getShipmentProduct() && ! getSelectedShipment().getShipmentProduct().isEmpty()) {
			List<ShipmentProductVO> shipmentProductList = getSelectedShipment().getShipmentProduct();			
			long count = shipmentProductList.stream().filter(i -> i.getProduct().getProductId() == productVO.getProductId()).count();
			if(count > 0)
				return true;
		}
		return false;
	}
	
	/*
	 * Method to save Shipment Product
	 */
	public void saveShipmentProduct(List<ShipmentProductVO> saveProduct) {
		
		ProductShipmentHelper.calculateShipmentProductprices(saveProduct);
		shipmentService.saveShipmentProduct(saveProduct);
		UIMessageHelper.getInstance().displayUIMessage("product_saved", FacesMessage.SEVERITY_INFO);
	}
	
	/**
	 * @return the invoiceService
	 */
	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	/**
	 * @param invoiceService the invoiceService to set
	 */
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
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
	 * @return the selectedShipment
	 */
	public ShipmentVO getSelectedShipment() {
		return selectedShipment;
	}


	/**
	 * @param selectedShipment the selectedShipment to set
	 */
	public void setSelectedShipment(ShipmentVO selectedShipment) {
		this.selectedShipment = selectedShipment;
	}


	/**
	 * @return the invokedFromInvoiceWizard
	 */
	public boolean isInvokedFromInvoiceWizard() {
		return invokedFromInvoiceWizard;
	}


	/**
	 * @param invokedFromInvoiceWizard the invokedFromInvoiceWizard to set
	 */
	public void setInvokedFromInvoiceWizard(boolean invokedFromInvoiceWizard) {
		this.invokedFromInvoiceWizard = invokedFromInvoiceWizard;
	}


	/**
	 * @return the addNewShipment
	 */
	public ShipmentVO getAddNewShipment() {
		return addNewShipment;
	}


	/**
	 * @param addNewShipment the addNewShipment to set
	 */
	public void setAddNewShipment(ShipmentVO addNewShipment) {
		this.addNewShipment = addNewShipment;
	}


	/**
	 * @return the selectedProductVO
	 */
	public ProductVO getSelectedProductVO() {
		return selectedProductVO;
	}


	/**
	 * @param selectedProductVO the selectedProductVO to set
	 */
	public void setSelectedProductVO(ProductVO selectedProductVO) {
		this.selectedProductVO = selectedProductVO;
	}


	/**
	 * @return the invokedFromShipmentWizard
	 */
	public boolean isInvokedFromShipmentWizard() {
		return invokedFromShipmentWizard;
	}


	/**
	 * @param invokedFromShipmentWizard the invokedFromShipmentWizard to set
	 */
	public void setInvokedFromShipmentWizard(boolean invokedFromShipmentWizard) {
		this.invokedFromShipmentWizard = invokedFromShipmentWizard;
	}

	/**
	 * @return the selectedShipmentProductVO
	 */
	public ShipmentProductVO getSelectedShipmentProductVO() {
		return selectedShipmentProductVO;
	}

	/**
	 * @param selectedShipmentProductVO the selectedShipmentProductVO to set
	 */
	public void setSelectedShipmentProductVO(ShipmentProductVO selectedShipmentProductVO) {
		this.selectedShipmentProductVO = selectedShipmentProductVO;
	}
	
	
			
}
