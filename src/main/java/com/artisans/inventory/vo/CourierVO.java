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
public class CourierVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int courierId;

    private String name;

    private Timestamp modifiedDate;

    private Set<ShipmentVO> shipmentVO;

    private UserVO userVO;

	/**
	 * @return the courierId
	 */
	public int getCourierId() {
		return courierId;
	}

	/**
	 * @param courierId the courierId to set
	 */
	public void setCourierId(int courierId) {
		this.courierId = courierId;
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
	 * @return the modifiedDate
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
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
