/**
 * 
 */
package com.artisans.inventory.service.api;

import java.util.List;

import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 */
public interface StandingDataService {

	/**
	 * Find the List of Supplier
	 * @param data
	 */
	public List<SupplierVO> findSuppliers();
	
	/**
	 * Create or update Supplier
	 * @param groupVO
	 * @return GroupVO
	 */
	public SupplierVO saveSupplier(SupplierVO supplierVO);	
	
	/**
	 * Find all couriers
	 * @return
	 */
	public List<CourierVO> findCouriers();
	
	/**
	 * Create or update Courier
	 * @param CourierVO
	 * @return CourierVO
	 */
	public CourierVO saveCourier(CourierVO courierVO);	
	
	/**
	 * Find all Products
	 * @return
	 */
	public List<ProductVO> findProducts();
	
	/**
	 * Create or update Products
	 * @param ProductVO
	 * @return ProductVO
	 */
	public ProductVO saveProduct(ProductVO productVO);		
}
