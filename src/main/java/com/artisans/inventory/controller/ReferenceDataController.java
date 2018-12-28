/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author bjacob
 *
 */

@Scope(value="application")
@Component(value = "ReferenceDataController")
public class ReferenceDataController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ApplicationConfiguration configUtil;
	
	@Autowired
	StandingDataService standingDataService;		
		
	private List<SupplierVO> supplierVOList;
	
	private List<CourierVO> courierVOList;
	
	private List<ProductVO> productVOList;
	
	private Date today;
	
	
	@PostConstruct
	public void init() 
	{					
		//Get all Suppliers
		List<SupplierVO> suppliervoList = standingDataService.findSuppliers();
		setSupplierVOList(suppliervoList);
		
		//Get All Couriers
		List<CourierVO> couriervoList = standingDataService.findCouriers();
		setCourierVOList(couriervoList);
		
		//Get All Couriers
		List<ProductVO> productVOList = standingDataService.findProducts();
		setProductVOList(productVOList);		
		
		setToday(BeanHelper.getToday());
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
	 * @return the today
	 */
	public Date getToday() {
		return today;
	}

	/**
	 * @param today the today to set
	 */
	public void setToday(Date today) {
		this.today = today;
	}
	
	
	
}
