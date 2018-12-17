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
    
    private Double postageCharges;	
    
    private Double packingCharges;	
    
    private Double otherCharges;	
    
    private Double webRrp;	
    
    private Double webPpCharge;	
    
    private Double ebayRrp;		
    
    private Double ebayFees;	
    
    private Double amzRrp;	
    
    private Double amzFees;		
    
    private Double amzFbaFees;   
       
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
	 * @return the postageCharges
	 */
	public Double getPostageCharges() {
		return postageCharges;
	}

	/**
	 * @param postageCharges the postageCharges to set
	 */
	public void setPostageCharges(Double postageCharges) {
		this.postageCharges = postageCharges;
	}

	/**
	 * @return the packingCharges
	 */
	public Double getPackingCharges() {
		return packingCharges;
	}

	/**
	 * @param packingCharges the packingCharges to set
	 */
	public void setPackingCharges(Double packingCharges) {
		this.packingCharges = packingCharges;
	}

	/**
	 * @return the otherCharges
	 */
	public Double getOtherCharges() {
		return otherCharges;
	}

	/**
	 * @param otherCharges the otherCharges to set
	 */
	public void setOtherCharges(Double otherCharges) {
		this.otherCharges = otherCharges;
	}

	/**
	 * @return the webRrp
	 */
	public Double getWebRrp() {
		return webRrp;
	}

	/**
	 * @param webRrp the webRrp to set
	 */
	public void setWebRrp(Double webRrp) {
		this.webRrp = webRrp;
	}

	/**
	 * @return the webPpCharge
	 */
	public Double getWebPpCharge() {
		return webPpCharge;
	}

	/**
	 * @param webPpCharge the webPpCharge to set
	 */
	public void setWebPpCharge(Double webPpCharge) {
		this.webPpCharge = webPpCharge;
	}

	/**
	 * @return the ebayRrp
	 */
	public Double getEbayRrp() {
		return ebayRrp;
	}

	/**
	 * @param ebayRrp the ebayRrp to set
	 */
	public void setEbayRrp(Double ebayRrp) {
		this.ebayRrp = ebayRrp;
	}

	/**
	 * @return the ebayFees
	 */
	public Double getEbayFees() {
		return ebayFees;
	}

	/**
	 * @param ebayFees the ebayFees to set
	 */
	public void setEbayFees(Double ebayFees) {
		this.ebayFees = ebayFees;
	}

	/**
	 * @return the amzRrp
	 */
	public Double getAmzRrp() {
		return amzRrp;
	}

	/**
	 * @param amzRrp the amzRrp to set
	 */
	public void setAmzRrp(Double amzRrp) {
		this.amzRrp = amzRrp;
	}

	/**
	 * @return the amzFees
	 */
	public Double getAmzFees() {
		return amzFees;
	}

	/**
	 * @param amzFees the amzFees to set
	 */
	public void setAmzFees(Double amzFees) {
		this.amzFees = amzFees;
	}

	/**
	 * @return the amzFbaFees
	 */
	public Double getAmzFbaFees() {
		return amzFbaFees;
	}

	/**
	 * @param amzFbaFees the amzFbaFees to set
	 */
	public void setAmzFbaFees(Double amzFbaFees) {
		this.amzFbaFees = amzFbaFees;
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
