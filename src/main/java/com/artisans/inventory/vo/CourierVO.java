/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jacob
 *
 */
public class CourierVO extends BaseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer courierId;

    private String name;

    private List<ShipmentVO> shipmentVO;


	/**
	 * @return the courierId
	 */
	public Integer getCourierId() {
		return courierId;
	}

	/**
	 * @param courierId the courierId to set
	 */
	public void setCourierId(Integer courierId) {
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
	public List<ShipmentVO> getShipmentVO() {
		return shipmentVO;
	}

	/**
	 * @param shipmentVO the shipmentVO to set
	 */
	public void setShipmentVO(List<ShipmentVO> shipmentVO) {
		this.shipmentVO = shipmentVO;
	}


}
