package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.model.Supplier;
import com.artisans.inventory.repository.SupplierRepository;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.transformers.SupplierTransformer;
import com.artisans.inventory.vo.SupplierVO;

@Component(value="standingDataService")
@Transactional(readOnly=true)
public class StandingDataServiceImpl extends BaseServiceImpl implements StandingDataService  {

	@Autowired
	private SupplierRepository supplierRepository;
	
	/**
	 * Find the List of Supplier
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public List<SupplierVO> findSuppliers()
	{
		List<SupplierVO> currencyVOList = new ArrayList<SupplierVO>();
		List<?> supplierList = supplierRepository.findAll();
		if(null != supplierList && ! supplierList.isEmpty())
		{
			CollectionUtils.transform(supplierList, new SupplierTransformer());
			currencyVOList = (List<SupplierVO>)supplierList;
		}		
		return currencyVOList;
	}
	
	/**
	 * Create or update Supplier
	 * @param groupVO
	 * @return GroupVO
	 */
	@Transactional(readOnly=false)
	public SupplierVO saveSupplier(SupplierVO supplierVO)
	{
		updateTimeStamp(supplierVO);
		Supplier supplier = new DozerBeanMapper().map(supplierVO, Supplier.class);    
		supplier = supplierRepository.saveAndFlush(supplier);
		return new DozerBeanMapper().map(supplier, SupplierVO.class);  
	}	
}
