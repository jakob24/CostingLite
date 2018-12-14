/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Jacob
 *
 */
public class UserVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;

    private String username;

    private int modifiedBy;

    private boolean admin;

    private Set<CourierVO> courierVO;

    private Set<InvoiceVO> invoiceVO;

    private Set<PaymentVO> paymentVO;

    private Set<ProductVO> productVO;

    private Set<ShipmentProductVO> shipmentProductVO;

    private Set<ShipmentVO> shipmentVO;

    private Set<SupplierVO> supplierVO;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the modifiedBy
	 */
	public int getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the courierVO
	 */
	public Set<CourierVO> getCourierVO() {
		return courierVO;
	}

	/**
	 * @param courierVO the courierVO to set
	 */
	public void setCourierVO(Set<CourierVO> courierVO) {
		this.courierVO = courierVO;
	}

	/**
	 * @return the invoiceVO
	 */
	public Set<InvoiceVO> getInvoiceVO() {
		return invoiceVO;
	}

	/**
	 * @param invoiceVO the invoiceVO to set
	 */
	public void setInvoiceVO(Set<InvoiceVO> invoiceVO) {
		this.invoiceVO = invoiceVO;
	}

	/**
	 * @return the paymentsVO
	 */
	public Set<PaymentVO> getPaymentsVO() {
		return paymentVO;
	}

	/**
	 * @param paymentVO the paymentsVO to set
	 */
	public void setPaymentsVO(Set<PaymentVO> paymentVO) {
		this.paymentVO = paymentVO;
	}

	/**
	 * @return the productVO
	 */
	public Set<ProductVO> getProductVO() {
		return productVO;
	}

	/**
	 * @param productVO the productVO to set
	 */
	public void setProductVO(Set<ProductVO> productVO) {
		this.productVO = productVO;
	}

	/**
	 * @return the shipmentProductVO
	 */
	public Set<ShipmentProductVO> getShipmentProductVO() {
		return shipmentProductVO;
	}

	/**
	 * @param shipmentProductVO the shipmentProductVO to set
	 */
	public void setShipmentProductVO(Set<ShipmentProductVO> shipmentProductVO) {
		this.shipmentProductVO = shipmentProductVO;
	}

	/**
	 * @return the shipmentVO
	 */
	public Set<ShipmentVO> getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(Set<ShipmentVO> shipmentVO) {
		this.shipmentVO = shipmentVO;
	}

	/**
	 * @return the supplierVO
	 */
	public Set<SupplierVO> getSupplierVO() {
		return supplierVO;
	}

	/**
	 * @param supplierVO the supplierVO to set
	 */
	public void setSupplierVO(Set<SupplierVO> supplierVO) {
		this.supplierVO = supplierVO;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
