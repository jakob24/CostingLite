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
public class ProductVO extends BaseVO implements Serializable {
	

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

    private Set<ShipmentProductVO> shipmentProductVO;


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

}
