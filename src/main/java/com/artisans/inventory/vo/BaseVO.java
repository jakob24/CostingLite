/**
 * 
 */
package com.artisans.inventory.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Jacob
 *
 */
public class BaseVO implements Serializable {
	
    private UserVO userVO;
    
    private Timestamp modifiedOn;

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
    
    

}
