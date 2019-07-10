/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.AmazonFbaSizeFeesVO;
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
	StandingDataService standingDataService;		
		
	private List<SupplierVO> supplierVOList;
	
	private List<CourierVO> courierVOList;
	
	private List<ProductVO> productVOList;
	
	private List<AmazonFbaSizeFeesVO> amazonFbaSizeFeesVOList;
	
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
		
		//Get All Products
		List<ProductVO> productVOList = standingDataService.findProducts();
		setProductVOList(productVOList);
		
		//Get All AmazonFbaSizeFees
		List<AmazonFbaSizeFeesVO> amazonFbaSizeFeesVOList = standingDataService.findAmazonFbaSizeFees();
		setAmazonFbaSizeFeesVOList(amazonFbaSizeFeesVOList);
		
		setToday(BeanHelper.getToday());
	}

	/**
	 * Event for product dropdown selection
	 * 
	 * @param query
	 * @return
	 */
    public List<ProductVO> completeProductSelection(String query) {
        List<ProductVO> allProducts = productVOList;
        List<ProductVO> filteredProducts = new ArrayList<ProductVO>();         
        for (int i = 0; i < allProducts.size(); i++) {
        	ProductVO thisProduct = allProducts.get(i);
            if(thisProduct.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredProducts.add(thisProduct);
            }
        }         
        return filteredProducts;
    }	
	
	/**
	 * Method to refresh product Data being held in cache
	 */
	public void refreshProductData() {
		//Get All Products
		setProductVOList(standingDataService.findProducts());		
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
	 * @return the amazonFbaSizeFeesVOList
	 */
	public List<AmazonFbaSizeFeesVO> getAmazonFbaSizeFeesVOList() {
		return amazonFbaSizeFeesVOList;
	}

	/**
	 * @param amazonFbaSizeFeesVOList the amazonFbaSizeFeesVOList to set
	 */
	public void setAmazonFbaSizeFeesVOList(List<AmazonFbaSizeFeesVO> amazonFbaSizeFeesVOList) {
		this.amazonFbaSizeFeesVOList = amazonFbaSizeFeesVOList;
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
