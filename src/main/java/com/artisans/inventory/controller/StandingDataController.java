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
	
	private SupplierVO supplierVO;
	
	private List<SupplierVO> supplierVOList;
	

	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{
		List<SupplierVO> supplierVOList = standingDataService.findSuppliers();
		setSupplierVOList(supplierVOList);
	}		
	
    /**
     * Update Group Name
     * @param event
     */
    public void onSupplierEdit(RowEditEvent event) 
    {
    	SupplierVO supplierVO = (SupplierVO) event.getObject(); 	 
    	standingDataService.saveSupplier(supplierVO);
    	UIMessageHelper.getInstance().displayUIMessage("msg_group_name_saved", FacesMessage.SEVERITY_INFO);
    }	
    
    public boolean isUniqueName(RowEditEvent event) {
    	SupplierVO supplierVO = (SupplierVO) event.getObject();
    	return true;
    }
    
    /**
     * Delete Group
     * @param event
     */
    public void onSupplierCancel(RowEditEvent event) 
    { 
    	
    }	    
    
	/**
	 * @return the supplierVO
	 */
	public SupplierVO getSupplierVO() {
		return supplierVO;
	}

	/**
	 * @param supplierVO the supplierVO to set
	 */
	public void setSupplierVO(SupplierVO supplierVO) {
		this.supplierVO = supplierVO;
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
}
