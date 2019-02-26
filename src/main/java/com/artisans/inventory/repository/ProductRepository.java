/**
 * 
 */
package com.artisans.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.model.Product;

/**
 * @author bjacob
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	/**
	 * Returns all products sorted by sku and inactive_from
	 * @return Products List
	 */
	@Query(value= "SELECT * FROM costing_lite.product order by inactive_from, sku;", nativeQuery=true)
	public List<Product> findAllProducts();	
}
