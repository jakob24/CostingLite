/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Set;

import com.artisans.inventory.model.Invoice;

/**
 * @author Jacob
 *
 */
public class SupplierVO extends BaseVO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int supplierId;

    private String name;

    private String location;

    private Set<Invoice> invoice;


	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}

	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}



	/**
	 * @return the invoice
	 */
	public Set<Invoice> getInvoice() {
		return invoice;
	}

	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

}
