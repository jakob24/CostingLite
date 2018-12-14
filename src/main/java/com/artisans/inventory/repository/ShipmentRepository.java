/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Shipment;

/**
 * @author bjacob
 *
 */
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

}
