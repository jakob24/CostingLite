package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.UIMessageHelper;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.SupplierVO;

@Scope(value = "session")
@Component(value = "StandingDataController")
public class StandingDataController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	StandingDataService standingDataService;	
	
	
	private List<SupplierVO> supplierVOList;
	
	private List<CourierVO> courierVOList;
	
	private List<ProductVO> productVOList;
	
	//Selected Product
	private ProductVO selectedProduct;
	

	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{
		//Get all Suppliers
		List<SupplierVO> suppliervoList = standingDataService.findSuppliers();
		setSupplierVOList(suppliervoList);
		
		//Get All Couriers
		List<CourierVO> couriervoList = standingDataService.findCouriers();
		setCourierVOList(couriervoList);
		
		//Get All Products
		List<ProductVO> productvoList = standingDataService.findProducts();
		setProductVOList(productvoList);		
	}		
	
    /**
     * Update Group Name
     * @param event
     */
    public void onSupplierEdit(RowEditEvent event) 
    {
    	SupplierVO supplierVO = (SupplierVO) event.getObject(); 
    	if(isUniqueSupplierName(supplierVO)) {
    		standingDataService.saveSupplier(supplierVO);
    		UIMessageHelper.getInstance().displayUIMessage("msg_group_name_saved", FacesMessage.SEVERITY_INFO);
    	} else {
    		UIMessageHelper.getInstance().displayUIMessage("uniqie_supplier_name", FacesMessage.SEVERITY_ERROR);
    	}    	
    }	
    
    /**
     * Check for unique Supplier Name
     * @param event
     * @return
     */
    private boolean isUniqueSupplierName(SupplierVO newSupplier) {    	
    	if(! supplierVOList.isEmpty() && supplierVOList.size() > 1) {
    		for(SupplierVO supplierVO : supplierVOList) {
    			if(!(newSupplier.getSupplierId() == supplierVO.getSupplierId())) {
    				if(newSupplier.getName().equalsIgnoreCase(supplierVO.getName())) {
        				return false;
        			}
    			}
    		}
    	}
    	return true;
    }
    
    
    /**
     * Add a new supplier by providing an empty row
     */
    public void onAddNewSupplierRow() {
        // Add one new car to the table:
    	SupplierVO supplierVO = new SupplierVO(); 
    	supplierVOList.add(supplierVO);
    }
    
    /**
     * Delete Group
     * @param event
     */
    public void onSupplierCancel(RowEditEvent event) 
    {     	
    }	   
    
    
    /**
     * Update Courier Name
     * @param event
     */
    public void onCourierEdit(RowEditEvent event) 
    {
    	CourierVO courierVO = (CourierVO) event.getObject(); 
    	if(isUniqueCourierName(courierVO)) {
    		standingDataService.saveCourier(courierVO);
    		UIMessageHelper.getInstance().displayUIMessage("msg_group_name_saved", FacesMessage.SEVERITY_INFO);
    	} else {
    		UIMessageHelper.getInstance().displayUIMessage("uniqie_supplier_name", FacesMessage.SEVERITY_ERROR);
    	}    	
    }	
    
    /**
     * Check for unique Courier Name
     * @param event
     * @return
     */
    private boolean isUniqueCourierName(CourierVO newCourier) {    	
    	if(! courierVOList.isEmpty() && courierVOList.size() > 1) {
    		for(CourierVO courierVO : courierVOList) {
    			if(!(newCourier.getCourierId() == courierVO.getCourierId())) {
    				if(newCourier.getName().equalsIgnoreCase(courierVO.getName())) {
        				return false;
        			}
    			}
    		}
    	}
    	return true;
    }
    
    
    /**
     * Add a new supplier by providing an empty row
     */
    public void onAddNewCourierRow() {
        // Add one new car to the table:
    	CourierVO courierVO = new CourierVO(); 
    	courierVOList.add(courierVO);
    }
    
    /**
     * Delete Group
     * @param event
     */
    public void onCourierCancel(RowEditEvent event) 
    {     	
    }	    
    
    
    public void onProductEdit() {
    	
    	System.out.println(getSelectedProduct());
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
	 * @return the selectedProduct
	 */
	public ProductVO getSelectedProduct() {
		return selectedProduct;
	}

	/**
	 * @param selectedProduct the selectedProduct to set
	 */
	public void setSelectedProduct(ProductVO selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	
	
	
}
