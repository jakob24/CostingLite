/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Courier;

/**
 * @author bjacob
 *
 */
public interface CourierRepository  extends JpaRepository<Courier, Integer> {

}
