/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Product;

/**
 * @author bjacob
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
