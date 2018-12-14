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
public class CourierVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int courierId;

    private String name;

    private Set<ShipmentVO> shipmentVO;


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
}
