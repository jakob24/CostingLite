/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;

/**
 * @author Jacob
 *
 */
public class AmazonFbaSizeFeesVO extends BaseVO implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer amazonFbaSizeFeesId;
    
    private String size;

    private Double ukFees;

    private Double deFees;

    private Double frFees;

	/**
	 * @return the amazonFbaSizeFeesId
	 */
	public Integer getAmazonFbaSizeFeesId() {
		return amazonFbaSizeFeesId;
	}

	/**
	 * @param amazonFbaSizeFeesId the amazonFbaSizeFeesId to set
	 */
	public void setAmazonFbaSizeFeesId(Integer amazonFbaSizeFeesId) {
		this.amazonFbaSizeFeesId = amazonFbaSizeFeesId;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the ukFees
	 */
	public Double getUkFees() {
		return ukFees;
	}

	/**
	 * @param ukFees the ukFees to set
	 */
	public void setUkFees(Double ukFees) {
		this.ukFees = ukFees;
	}

	/**
	 * @return the deFees
	 */
	public Double getDeFees() {
		return deFees;
	}

	/**
	 * @param deFees the deFees to set
	 */
	public void setDeFees(Double deFees) {
		this.deFees = deFees;
	}

	/**
	 * @return the frFees
	 */
	public Double getFrFees() {
		return frFees;
	}

	/**
	 * @param frFees the frFees to set
	 */
	public void setFrFees(Double frFees) {
		this.frFees = frFees;
	}
    
    
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof AmazonFbaSizeFeesVO)) {
            return false;
        }

        AmazonFbaSizeFeesVO amazonFbaSizeFeesVO = (AmazonFbaSizeFeesVO) o;
        return amazonFbaSizeFeesVO.getAmazonFbaSizeFeesId().intValue() == getAmazonFbaSizeFeesId().intValue();
    }	
}
