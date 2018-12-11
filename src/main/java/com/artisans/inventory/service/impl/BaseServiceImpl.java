/**
 * 
 */
package com.artisans.inventory.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import com.artisans.inventory.vo.BaseVO;

/**
 * @author Jacob
 *
 */
public class BaseServiceImpl {

	protected void updateTimeStamp(BaseVO baseVO) {
		
		baseVO.setModifiedOn(new Timestamp(new Date().getTime()));
		
	}
}
