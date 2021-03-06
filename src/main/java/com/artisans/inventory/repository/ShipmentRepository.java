/**
 * 
 */
package com.artisans.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artisans.inventory.model.Shipment;

/**
 * @author bjacob
 *
 */
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

	/**
	 * Returns all invoices for the supplier
	 * @param invoiceId
	 * @return Shipment List
	 */
	@Query(value= "SELECT * FROM shipment where invoice = ?1 order by shipment_number asc", nativeQuery=true)
	public List<Shipment> findAllShipmentsForInvoice(Integer invoiceId);
			
}
