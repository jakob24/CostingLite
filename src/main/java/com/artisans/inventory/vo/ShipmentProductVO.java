/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Jacob
 *
 */
public class ShipmentProductVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer shipmentProductId;
    
    private Date date;

    private Integer productQty;

    private ProductVO product;

    private ShipmentVO shipment;
            
    private Double costPriceUsd;

    private Double costPriceGbp;

    private Double landingCostGbp;
        
    //Product Attributes
    private Double otherCharges;
    
    private Double webRrp;	
    
    private Double ebayRrp;		
    
    private Double ebayFees;	
    
    private Double amzRrp;	
    
    private Double amzFees;		
    
    private Double amzFbaFees;    
    
    //Calculated from Invoice payment
    private Double gbpToUsd;
    
    //Quantity in inventory
    private Integer inventory;
    
    private Double webProfit;	
    
    private Double ebayProfit;

    private Double amzProfit;
    
    private Double amzFbaProfit;  
    
    private Double amzDeRrp;	

    private Double amzDeFbaFees;  
    
    private Double amzDeFbaProfit;  

    private Double amzFrRrp;	

    private Double amzFrFbaFees;     

    private Double amzFrFbaProfit;       
    
    
	/**
	 * @return the shipmentProductId
	 */
	public Integer getShipmentProductId() {
		return shipmentProductId;
	}

	/**
	 * @param shipmentProductId the shipmentProductId to set
	 */
	public void setShipmentProductId(Integer shipmentProductId) {
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
	 * @return the productQty
	 */
	public Integer getProductQty() {
		return productQty;
	}

	/**
	 * @param productQty the productQty to set
	 */
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	/**
	 * @return the product
	 */
	public ProductVO getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductVO product) {
		this.product = product;
	}

	/**
	 * @return the shipment
	 */
	public ShipmentVO getShipment() {
		return shipment;
	}

	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(ShipmentVO shipment) {
		this.shipment = shipment;
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
	 * @param landingCostGbp the landingCostGbp to set
	 */
	public void setLandingCostGbp(Double landingCostGbp) {
		this.landingCostGbp = landingCostGbp;
	}

	/**
	 * @return the gbpToUsd
	 */
	public Double getGbpToUsd() {
		return gbpToUsd;
	}

	/**
	 * @param gbpToUsd the gbpToUsd to set
	 */
	public void setGbpToUsd(Double gbpToUsd) {
		this.gbpToUsd = gbpToUsd;
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
	 * @return the landingCostGbp
	 */
	public Double getLandingCostGbp() {
		return landingCostGbp;
	}

	/**
	 * @return the inventory
	 */
	public Integer getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
		
		   
    /**
	 * @return the webProfit
	 */
	public Double getWebProfit() {
		return webProfit;
	}

	/**
	 * @param webProfit the webProfit to set
	 */
	public void setWebProfit(Double webProfit) {
		this.webProfit = webProfit;
	}

	/**
	 * @return the ebayProfit
	 */
	public Double getEbayProfit() {
		return ebayProfit;
	}

	/**
	 * @param ebayProfit the ebayProfit to set
	 */
	public void setEbayProfit(Double ebayProfit) {
		this.ebayProfit = ebayProfit;
	}

	/**
	 * @return the amzProfit
	 */
	public Double getAmzProfit() {
		return amzProfit;
	}

	/**
	 * @param amzProfit the amzProfit to set
	 */
	public void setAmzProfit(Double amzProfit) {
		this.amzProfit = amzProfit;
	}

	/**
	 * @return the amzFbaProfit
	 */
	public Double getAmzFbaProfit() {
		return amzFbaProfit;
	}

	/**
	 * @param amzFbaProfit the amzFbaProfit to set
	 */
	public void setAmzFbaProfit(Double amzFbaProfit) {
		this.amzFbaProfit = amzFbaProfit;
	}
	
	/**
	 * @return the amzDeRrp
	 */
	public Double getAmzDeRrp() {
		return amzDeRrp;
	}

	/**
	 * @param amzDeRrp the amzDeRrp to set
	 */
	public void setAmzDeRrp(Double amzDeRrp) {
		this.amzDeRrp = amzDeRrp;
	}

	/**
	 * @return the amzDeFbaFees
	 */
	public Double getAmzDeFbaFees() {
		return amzDeFbaFees;
	}

	/**
	 * @param amzDeFbaFees the amzDeFbaFees to set
	 */
	public void setAmzDeFbaFees(Double amzDeFbaFees) {
		this.amzDeFbaFees = amzDeFbaFees;
	}

	/**
	 * @return the amzFrRrp
	 */
	public Double getAmzFrRrp() {
		return amzFrRrp;
	}

	/**
	 * @param amzFrRrp the amzFrRrp to set
	 */
	public void setAmzFrRrp(Double amzFrRrp) {
		this.amzFrRrp = amzFrRrp;
	}

	/**
	 * @return the amzFrFbaFees
	 */
	public Double getAmzFrFbaFees() {
		return amzFrFbaFees;
	}

	/**
	 * @param amzFrFbaFees the amzFrFbaFees to set
	 */
	public void setAmzFrFbaFees(Double amzFrFbaFees) {
		this.amzFrFbaFees = amzFrFbaFees;
	}
	
	/**
	 * @return the amzDeFbaProfit
	 */
	public Double getAmzDeFbaProfit() {
		return amzDeFbaProfit;
	}

	/**
	 * @param amzDeFbaProfit the amzDeFbaProfit to set
	 */
	public void setAmzDeFbaProfit(Double amzDeFbaProfit) {
		this.amzDeFbaProfit = amzDeFbaProfit;
	}

	/**
	 * @return the amzFrFbaProfit
	 */
	public Double getAmzFrFbaProfit() {
		return amzFrFbaProfit;
	}

	/**
	 * @param amzFrFbaProfit the amzFrFbaProfit to set
	 */
	public void setAmzFrFbaProfit(Double amzFrFbaProfit) {
		this.amzFrFbaProfit = amzFrFbaProfit;
	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof ShipmentProductVO)) {
            return false;
        }

        ShipmentProductVO shipmentProductVO = (ShipmentProductVO) o;
        return shipmentProductVO.getShipmentProductId().intValue() == getShipmentProductId().intValue();
    }		
}
