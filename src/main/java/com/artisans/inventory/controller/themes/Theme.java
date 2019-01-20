/**
 * 
 */
package com.artisans.inventory.controller.themes;

import java.io.Serializable;

/**
 * @author Jacob
 *
 */
public class Theme implements Serializable
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1833380301520239850L;

	private int id;
     
	 private String displayName;
     
	 private String name;
     
	 public Theme() {}
 
	 public Theme(int id, String displayName, String name) 
	 {
		 this.id = id;
		 this.displayName = displayName;
		 this.name = name;
	 }

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
    public String toString() 
	{
        return name;
    }	
	 
	 
}
