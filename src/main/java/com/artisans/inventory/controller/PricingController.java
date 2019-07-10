/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Jacob
 *
 */
@Scope(value="view")
@Component(value = "PricingController")
public class PricingController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8102869450748998345L;
	
	
	/**
	 * Initial method to load data on the screen
	 */
	@PostConstruct
	public void init() 
	{	

	}
	
	
		

}
