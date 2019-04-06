package com.artisans.inventory.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.apache.commons.math3.util.Precision;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.artisans.inventory.helper.ApplicationConfiguration;
import com.artisans.inventory.helper.BeanHelper;
import com.artisans.inventory.helper.UIMessageHelper;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.vo.AmazonFbaSizeFeesVO;
import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.SupplierVO;

@Scope(value = "session") //Required for images as view scope wont work
@Component(value = "StandingDataController")
public class StandingDataController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	StandingDataService standingDataService;	
	
	@Autowired
	private ApplicationConfiguration configUtil;
	
	@Autowired
	private ReferenceDataController referenceDataController;
		
	private List<SupplierVO> supplierVOList;
	
	private List<CourierVO> courierVOList;
	
	private List<ProductVO> productVOList;
	
	private List<AmazonFbaSizeFeesVO> amazonFbaSizeFeesVOList;
	
	//Selected Product
	private ProductVO selectedProduct;
	
	//Product to Save
	private ProductVO newProduct;	
	
	Double amzReferalFeePercentage = null;
	Double euroToGBP = null;
	Double deMargin = null;
	Double frMargin = null;	
	
	
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{		
		//Get all Suppliers
		setSupplierVOList(referenceDataController.getSupplierVOList());
		
		//Get All Couriers
		setCourierVOList(referenceDataController.getCourierVOList());
		
		//Get All Products
		setProductVOList(referenceDataController.getProductVOList());
		
		//Get All AmazonFbaSizeFees
		setAmazonFbaSizeFeesVOList(referenceDataController.getAmazonFbaSizeFeesVOList());
		
		amzReferalFeePercentage = new Double(configUtil.getProperty("amazon.referalfee.percentage"));
		euroToGBP = new Double(configUtil.getProperty("euroToGBPReference"));
		deMargin = 100 + new Double(configUtil.getProperty("de.extra.margin.percentage"));
		frMargin = 100 + new Double(configUtil.getProperty("fr.extra.margin.percentage"));		
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
    public boolean isUniqueSupplierName(SupplierVO newSupplier) {    	
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
    
    
    public List<ProductVO> completeProductSelection(String query) {
        List<ProductVO> allProducts = productVOList;
        List<ProductVO> filteredProducts = new ArrayList<ProductVO>();         
        for (int i = 0; i < allProducts.size(); i++) {
        	ProductVO thisProduct = allProducts.get(i);
            if(thisProduct.getName().toLowerCase().contains(query.toLowerCase()) || 
            		thisProduct.getSku().toLowerCase().contains(query.toLowerCase())) {
                filteredProducts.add(thisProduct);
            }
        }         
        return filteredProducts;
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
     * Check for unique Product Name
     * @param event
     * @return
     */
    private boolean isUniqueProductName(ProductVO newProduct) {    	
    	if(! productVOList.isEmpty() && productVOList.size() > 1) {
    		for(ProductVO productVo : productVOList) {
    			if(!(newProduct.getProductId() == productVo.getProductId())) {
    				if(newProduct.getName().equalsIgnoreCase(productVo.getName())) {
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
     * Add new Product
     */
    public void onEditProduct() {	
    	setNewProduct(getSelectedProduct());
    }    
    
    /**
     * Add new Product
     */
    public void onAddProduct() {	
    	
    	ProductVO prod= new ProductVO();
    	prod.setWebPpCharge(new Double(configUtil.getProperty("web.payment.processor.charge")));
    	setNewProduct(prod);    	
    }
    
    /**
     * Calculate product RRP based on shipping size
     */
    public void onAmazonFeeSelect() {    	
    	ProductVO thisProduct = getNewProduct();    	
		if(null != thisProduct.getAmzRrp() && null != thisProduct.getAmazonFbaSizeFees()) {			
			String prices = calculateAmazonPrices(thisProduct);					
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Recommended Amazon Prices", prices.toString()));
		}    	
    }
    
    /**
     * Calculate product RRP based on shipping size
     */
    private  String calculateAmazonPrices(ProductVO thisProduct) {   	

    	StringBuffer prices = new StringBuffer();
		if(null != thisProduct.getAmzRrp() && null != thisProduct.getAmazonFbaSizeFees()) {
									
			//Update All Fees
			AmazonFbaSizeFeesVO feesVO = thisProduct.getAmazonFbaSizeFees();
						
			//UK
			//Fees
			Double amzFee = Precision.round(thisProduct.getAmzRrp() * (amzReferalFeePercentage/100) , 2);				
			//FBA
			Double amzFBAFee = Precision.round(amzFee + feesVO.getUkFees(), 2);	
			
			prices.append("<br/>UK Fees  = " + amzFee + "<br/>");
			prices.append("UK FBA Fees = " + amzFBAFee + "<br/>");
								
			//DE RRP	
			Double deRRP =null;
			if(null != thisProduct.getAmzDeRrp()) {
				deRRP = Precision.round(thisProduct.getAmzDeRrp(), 2); 
			}
			else {
				deRRP = Precision.round((thisProduct.getAmzRrp() * (deMargin/100)) * euroToGBP,2);  
			}
			//DE FBA 
			Double deFbaFees = Precision.round((deRRP * (amzReferalFeePercentage/100)) + (feesVO.getDeFees()), 2);
					
			prices.append("DE RRP  = " + deRRP + "<br/>");
			prices.append("DE FBA Fees = " + deFbaFees + "<br/>");
			
			//FR RRP
			Double frRRP =null;
			if(null != thisProduct.getAmzFrRrp()) {
				frRRP = Precision.round(thisProduct.getAmzFrRrp(), 2); 
			}
			else {
				frRRP = Precision.round((thisProduct.getAmzRrp() * (frMargin/100)) * euroToGBP,2);  
			}
			//FR FBA
			Double frFbaFees = Precision.round((frRRP * (amzReferalFeePercentage/100)) + (feesVO.getFrFees()), 2);
			
			prices.append("Fr RRP  = " + frRRP + "<br/>");
			prices.append("Fr FBA Fees = " + frFbaFees);	
		} 
		return prices.toString();
    }    
    
    /**
     * Calculate Amz DE Fees and set the value if empty
     * Invoked on change of AMZ De Price
     * @return
     */
    public void calculateDeAmazonFees() {
		Double deRRP =null;
		ProductVO thisProduct = getNewProduct();
		AmazonFbaSizeFeesVO feesVO = thisProduct.getAmazonFbaSizeFees();
		
		if(null != thisProduct.getAmzDeRrp()) {
			deRRP = Precision.round(thisProduct.getAmzDeRrp(), 2); 
			
			//DE FBA 
			Double deFbaFees = Precision.round((deRRP * (amzReferalFeePercentage/100)) + (feesVO.getDeFees()), 2);
			
			if(null == thisProduct.getAmzDeFbaFees()) {
				thisProduct.setAmzDeFbaFees(deFbaFees);
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Recommended Amazon DA FBA Fees",
						deFbaFees.toString()));				
			}
		}
    }
    
    /**
     * Calculate Amz DE Fees and set the value if empty
     * Invoked on change of AMZ De Price
     * @return
     */
    public void calculateFrAmazonFees() {
		Double frRRP =null;
		ProductVO thisProduct = getNewProduct();
		AmazonFbaSizeFeesVO feesVO = thisProduct.getAmazonFbaSizeFees();
		
		if(null != thisProduct.getAmzFrRrp()) {
			frRRP = Precision.round(thisProduct.getAmzFrRrp(), 2); 
			
			//DE FBA 
			Double frFbaFees = Precision.round((frRRP * (amzReferalFeePercentage/100)) + (feesVO.getFrFees()), 2);
			
			if(null == thisProduct.getAmzFrFbaFees()) {
				thisProduct.setAmzFrFbaFees(frFbaFees);
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Recommended Amazon FR FBA Fees",
						frFbaFees.toString()));				
			}			
		}
    }    
        
    /**
     * Save the product details
     */
    public void onSaveProduct() {  
    	ProductVO thisProduct = getNewProduct();
    	if(thisProduct.getProductId() == 0 ) {
    		if( ! isUniqueProductName(thisProduct)) {
    			UIMessageHelper.getInstance().displayUIMessage("uniqie_product_name", FacesMessage.SEVERITY_ERROR);    	
    			return;
    		}
    	}  
    	
    	
    	standingDataService.saveProduct(thisProduct);
    	UIMessageHelper.getInstance().displayUIMessage("product_saved", FacesMessage.SEVERITY_INFO); 
    }
      
    
    public void refresh() {
		 UIViewRoot viewRoot =  FacesContext.getCurrentInstance().getViewRoot();
		 UIComponent component1 = viewRoot.findComponent("dataSettings");  
		 BeanHelper.clearComponentHierarchy(component1);
		 init();    
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
	 * @return the newProduct
	 */
	public ProductVO getNewProduct() {
		return newProduct;
	}

	/**
	 * @param newProduct the newProduct to set
	 */
	public void setNewProduct(ProductVO newProduct) {
		this.newProduct = newProduct;
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
	
}
