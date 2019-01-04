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

    private int productQty;

    private ProductVO productVO;

    private ShipmentVO shipmentVO;
            
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
	
		    
}
