/**
 * 
 */
package com.artisans.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artisans.inventory.model.Invoice;

/**
 * @author bjacob
 *
 */
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {

}
