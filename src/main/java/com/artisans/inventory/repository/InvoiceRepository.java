/**
 * 
 */
package com.artisans.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artisans.inventory.model.Invoice;

/**
 * @author bjacob
 *
 */
@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {

	/**
	 * Returns all invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@Query(value= "SELECT * FROM invoice where supplier= ?1 order by invoice_date desc;", nativeQuery=true)
	public List<Invoice> findAllInvoicesForSupplier(Integer supplierId);
	
	/**
	 * Returns all active invoices for the supplier
	 * @param supplierId
	 * @param drivePattern
	 * @return Invoice List
	 */
	@Query(value= "SELECT * FROM invoice where supplier=1 and date_paid is null order by invoice_date desc;", nativeQuery=true)
	public List<Invoice> findAllActiveInvoicesForSupplier(Integer supplierId);
}
