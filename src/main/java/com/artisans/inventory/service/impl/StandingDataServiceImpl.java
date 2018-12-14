package com.artisans.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.artisans.inventory.model.Courier;
import com.artisans.inventory.model.Product;
import com.artisans.inventory.model.Supplier;
import com.artisans.inventory.repository.CourierRepository;
import com.artisans.inventory.repository.ProductRepository;
import com.artisans.inventory.repository.SupplierRepository;
import com.artisans.inventory.service.api.StandingDataService;
import com.artisans.inventory.transformers.CourierTransformer;
import com.artisans.inventory.transformers.ProductTransformer;
import com.artisans.inventory.transformers.SupplierTransformer;
import com.artisans.inventory.vo.CourierVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.SupplierVO;

@Component(value="standingDataService")
@Transactional(readOnly=true)
public class StandingDataServiceImpl extends BaseServiceImpl implements StandingDataService  {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private CourierRepository courierRepository;	
	
	@Autowired
	private ProductRepository productRepository;			
	
	/**
	 * Find the List of Supplier
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public List<SupplierVO> findSuppliers()
	{
		List<SupplierVO> supplierVOList = new ArrayList<SupplierVO>();
		List<?> supplierList = supplierRepository.findAll();
		if(null != supplierList && ! supplierList.isEmpty())
		{
			CollectionUtils.transform(supplierList, new SupplierTransformer());
			supplierVOList = (List<SupplierVO>)supplierList;
		}		
		return supplierVOList;
	}
	
	/**
	 * Create or update Supplier
	 * @param SupplierVO
	 * @return SupplierVO
	 */
	@Transactional(readOnly=false)
	public SupplierVO saveSupplier(SupplierVO supplierVO)
	{
		updateTimeStamp(supplierVO);
		Supplier supplier = new DozerBeanMapper().map(supplierVO, Supplier.class);    
		supplier = supplierRepository.saveAndFlush(supplier);
		return new DozerBeanMapper().map(supplier, SupplierVO.class);  
	}	
	
	/**
	 * Find all couriers
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<CourierVO> findCouriers()
	{
		List<CourierVO> courierVOList = new ArrayList<CourierVO>();
		List<?> courierList = courierRepository.findAll();
		if(null != courierList && ! courierList.isEmpty())
		{
			CollectionUtils.transform(courierList, new CourierTransformer());
			courierVOList = (List<CourierVO>)courierList;
		}		
		return courierVOList;	
	}
	
	/**
	 * Create or update Courier
	 * @param CourierVO
	 * @return CourierVO
	 */
	@Transactional(readOnly=false)
	public CourierVO saveCourier(CourierVO courierVO)
	{
		updateTimeStamp(courierVO);
		Courier courier = new DozerBeanMapper().map(courierVO, Courier.class);    
		courier = courierRepository.saveAndFlush(courier);
		return new DozerBeanMapper().map(courier, CourierVO.class);  
	}	
	
	
	/**
	 * Find all couriers
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<ProductVO> findProducts()
	{
		List<ProductVO> productVOList = new ArrayList<ProductVO>();
		List<?> productList = productRepository.findAll();
		if(null != productList && ! productList.isEmpty())
		{
			CollectionUtils.transform(productList, new ProductTransformer());
			productVOList = (List<ProductVO>)productList;
		}		
		return productVOList;	
	}
	
	/**
	 * Create or update Courier
	 * @param CourierVO
	 * @return CourierVO
	 */
	@Transactional(readOnly=false)
	public ProductVO saveProduct(ProductVO productVO)
	{
		updateTimeStamp(productVO);
		Product product = new DozerBeanMapper().map(productVO, Product.class);    
		product = productRepository.saveAndFlush(product);
		return new DozerBeanMapper().map(product, ProductVO.class);  
	}		
}
