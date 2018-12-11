/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Jacob
 *
 */
public class ShipmentProductVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int shipmentProductId;
    
    private Date date;

    private double costPriceUsd;

    private double costPriceGbp;

    private double landingCostGbp;

    private int productQty;

    private Timestamp modifiedOn;

    private ProductVO productVO;

    private ShipmentVO shipmentVO;

    private UserVO userVO;

	/**
	 * @return the shipmentProductId
	 */
	public int getShipmentProductId() {
		return shipmentProductId;
	}

	/**
	 * @param shipmentProductId the shipmentProductId to set
	 */
	public void setShipmentProductId(int shipmentProductId) {
		this.shipmentProductId = shipmentProductId;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the costPriceUsd
	 */
	public double getCostPriceUsd() {
		return costPriceUsd;
	}

	/**
	 * @param costPriceUsd the costPriceUsd to set
	 */
	public void setCostPriceUsd(double costPriceUsd) {
		this.costPriceUsd = costPriceUsd;
	}

	/**
	 * @return the costPriceGbp
	 */
	public double getCostPriceGbp() {
		return costPriceGbp;
	}

	/**
	 * @param costPriceGbp the costPriceGbp to set
	 */
	public void setCostPriceGbp(double costPriceGbp) {
		this.costPriceGbp = costPriceGbp;
	}

	/**
	 * @return the landingCostGbp
	 */
	public double getLandingCostGbp() {
		return landingCostGbp;
	}

	/**
	 * @param landingCostGbp the landingCostGbp to set
	 */
	public void setLandingCostGbp(double landingCostGbp) {
		this.landingCostGbp = landingCostGbp;
	}

	/**
	 * @return the productQty
	 */
	public int getProductQty() {
		return productQty;
	}

	/**
	 * @param productQty the productQty to set
	 */
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	/**
	 * @return the modifiedOn
	 */
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the productVO
	 */
	public ProductVO getProductVO() {
		return productVO;
	}

	/**
	 * @param productVO the productVO to set
	 */
	public void setProductVO(ProductVO productVO) {
		this.productVO = productVO;
	}

	/**
	 * @return the shipmentVO
	 */
	public ShipmentVO getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(ShipmentVO shipmentVO) {
		this.shipmentVO = shipmentVO;
	}

	/**
	 * @return the userVO
	 */
	public UserVO getUserVO() {
		return userVO;
	}

	/**
	 * @param userVO the userVO to set
	 */
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
    
    
}
