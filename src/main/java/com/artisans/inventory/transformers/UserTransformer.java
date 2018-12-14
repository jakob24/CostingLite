/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.User;
import com.artisans.inventory.vo.UserVO;

/**
 * @author bjacob
 *
 */
public class UserTransformer implements Transformer {

    public UserVO transform(Object userObj)
    {
     	if(userObj == null)
    	{
    		throw new IllegalArgumentException("The input userObj is empty.");
    	}
    	else if(! (userObj instanceof User))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToUserVO((User)userObj);
    }
    	
	
	private static UserVO transformToUserVO(User user)
	{
		UserVO userVO = new DozerBeanMapper().map(user, UserVO.class);   
		return userVO;
	}	
}
