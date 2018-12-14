/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.ShipmentProduct;

/**
 * @author bjacob
 *
 */
public interface ShipmentProductRepository extends JpaRepository<ShipmentProduct, Integer> {

}
