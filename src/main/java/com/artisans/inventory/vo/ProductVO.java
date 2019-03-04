/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    
    private String ean;
    
    private String sku;
    
    private Date inactiveFrom;

    private int inventory;

    private int minInventory;

    private String description;
    
    private String image;
    
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

    private Double costPriceUsd;

    private Double costPriceGbp;    
                   
    private List<ShipmentProductVO> shipmentProductVO;
    
    private SupplierVO supplier;
    
    
	/**
	 * Method to format the Shipment number + date to be 
	 * shown in dropdown
	 * @return
	 */
	public String getFormattedLabel() {
		return getSku() + " - " + getName();
	}    

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
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
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
	 * @return the ean
	 */
	public String getEan() {
		return ean;
	}

	/**
	 * @param ean the ean to set
	 */
	public void setEan(String ean) {
		this.ean = ean;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the inactiveFrom
	 */
	public Date getInactiveFrom() {
		return inactiveFrom;
	}

	/**
	 * @param inactiveFrom the inactiveFrom to set
	 */
	public void setInactiveFrom(Date inactiveFrom) {
		this.inactiveFrom = inactiveFrom;
	}

	/**
	 * @return the costPriceUsd
	 */
	public Double getCostPriceUsd() {
		return costPriceUsd;
	}

	/**
	 * @param costPriceUsd the costPriceUsd to set
	 */
	public void setCostPriceUsd(Double costPriceUsd) {
		this.costPriceUsd = costPriceUsd;
	}

	/**
	 * @return the costPriceGbp
	 */
	public Double getCostPriceGbp() {
		return costPriceGbp;
	}

	/**
	 * @param costPriceGbp the costPriceGbp to set
	 */
	public void setCostPriceGbp(Double costPriceGbp) {
		this.costPriceGbp = costPriceGbp;
	}

	/**
	 * @return the supplier
	 */
	public SupplierVO getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(SupplierVO supplier) {
		this.supplier = supplier;
	}			
	
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof PaymentVO)) {
            return false;
        }

        ProductVO productVO = (ProductVO) o;
        return productVO.getProductId() == getProductId();
    }	
}
