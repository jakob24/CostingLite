/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Payment;

/**
 * @author bjacob
 *
 */
public interface PaymentsRepository extends JpaRepository<Payment, Integer> {

}
