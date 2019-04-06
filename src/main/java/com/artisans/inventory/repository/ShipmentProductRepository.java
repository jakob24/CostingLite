/**
 * 
 */
package com.artisans.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artisans.inventory.model.ShipmentProduct;

/**
 * @author bjacob
 *
 */
public interface ShipmentProductRepository extends JpaRepository<ShipmentProduct, Integer> {

	/**
	 * Returns all invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@Query(value= "select sp.*, p.inventory FROM shipment_product sp inner join product p on p.product_id=sp.product where sp.shipment = ?1 order by shipment_product_id asc", 
			nativeQuery=true)
	public List<ShipmentProduct> findAllproductsForShipment(Integer shipmentId);
}
