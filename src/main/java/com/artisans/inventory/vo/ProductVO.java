/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Jacob
 *
 */
public class ProductVO implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int productId;

    private String name;

    private String asin;

    private int inventory;

    private int minInventory;

    private String description;
    
    private byte[] image;

    private Timestamp modifiedOn;

    private Set<ShipmentProductVO> shipmentProductVO;

    private UserVO userVO;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return the asin
	 */
	public String getAsin() {
		return asin;
	}

	/**
	 * @param asin the asin to set
	 */
	public void setAsin(String asin) {
		this.asin = asin;
	}

	/**
	 * @return the inventory
	 */
	public int getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the minInventory
	 */
	public int getMinInventory() {
		return minInventory;
	}

	/**
	 * @param minInventory the minInventory to set
	 */
	public void setMinInventory(int minInventory) {
		this.minInventory = minInventory;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
