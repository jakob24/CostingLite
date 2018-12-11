/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Supplier;

/**
 * @author Jacob
 *
 */
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
