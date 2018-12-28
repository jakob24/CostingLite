/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.List;
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

    private List<CourierVO> courierVO;

    private List<InvoiceVO> invoiceVO;

    private List<PaymentVO> paymentVO;

    private List<ProductVO> productVO;

    private List<ShipmentProductVO> shipmentProductVO;

    private List<ShipmentVO> shipmentVO;

    private List<SupplierVO> supplierVO;

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
	public List<CourierVO> getCourierVO() {
		return courierVO;
	}

	/**
	 * @param courierVO the courierVO to set
	 */
	public void setCourierVO(List<CourierVO> courierVO) {
		this.courierVO = courierVO;
	}

	/**
	 * @return the invoiceVO
	 */
	public List<InvoiceVO> getInvoiceVO() {
		return invoiceVO;
	}

	/**
	 * @param invoiceVO the invoiceVO to set
	 */
	public void setInvoiceVO(List<InvoiceVO> invoiceVO) {
		this.invoiceVO = invoiceVO;
	}

	/**
	 * @return the paymentVO
	 */
	public List<PaymentVO> getPaymentVO() {
		return paymentVO;
	}

	/**
	 * @param paymentVO the paymentVO to set
	 */
	public void setPaymentVO(List<PaymentVO> paymentVO) {
		this.paymentVO = paymentVO;
	}

	/**
	 * @return the productVO
	 */
	public List<ProductVO> getProductVO() {
		return productVO;
	}

	/**
	 * @param productVO the productVO to set
	 */
	public void setProductVO(List<ProductVO> productVO) {
		this.productVO = productVO;
	}

	/**
	 * @return the shipmentProductVO
	 */
	public List<ShipmentProductVO> getShipmentProductVO() {
		return shipmentProductVO;
	}

	/**
	 * @param shipmentProductVO the shipmentProductVO to set
	 */
	public void setShipmentProductVO(List<ShipmentProductVO> shipmentProductVO) {
		this.shipmentProductVO = shipmentProductVO;
	}

	/**
	 * @return the shipmentVO
	 */
	public List<ShipmentVO> getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(List<ShipmentVO> shipmentVO) {
		this.shipmentVO = shipmentVO;
	}

	/**
	 * @return the supplierVO
	 */
	public List<SupplierVO> getSupplierVO() {
		return supplierVO;
	}

	/**
	 * @param supplierVO the supplierVO to set
	 */
	public void setSupplierVO(List<SupplierVO> supplierVO) {
		this.supplierVO = supplierVO;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
