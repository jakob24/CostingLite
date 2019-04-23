/**
 * 
 */
package com.artisans.inventory.controller.themes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author Jacob
 *
 */

@Component(value="themeService")
public class ThemeService implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7613945831392889608L;
	private List<Theme> themes;

	
	@PostConstruct
    public void init() 
	{
        themes = new ArrayList<Theme>();
        themes.add(new Theme(1, "Afternoon", "afternoon"));
        themes.add(new Theme(3, "Aristo", "aristo"));
        themes.add(new Theme(19, "Hot-Sneaks", "hot-sneaks"));      
        themes.add(new Theme(30, "South-Street", "south-street"));
        themes.add(new Theme(32, "Sunny", "sunny"));        
        themes.add(new Theme(30, "Home", "home"));
        themes.add(new Theme(32, "Bootstrap", "bootstrap"));        
        themes.add(new Theme(30, "Smoothness", "smoothness"));
        themes.add(new Theme(32, "Start", "start"));
        themes.add(new Theme(30, "Overcast", "overcast"));
        themes.add(new Theme(32, "Pepper-grinder", "pepper-grinder"));   
    }


	public List<Theme> getThemes() 
    {
        return themes;
    } 	

}
