/**
 * 
 */
package com.artisans.inventory.service.api;

import java.util.List;

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
}
