/**
 * 
 */
package com.artisans.inventory.controller.themes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author Jacob
 *
 */

@Scope(value="application")
@Component(value = "ThemeSwitcherView")
public class ThemeSwitcherView implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2576708187712675145L;

	
	private List<Theme> themes;
	
	private String theme;
    
	@Autowired
    private ThemeService themeService;
    	
	/**
	 * @return the themes
	 */
	public List<Theme> getThemes()
	{
		return themes;
	}

	/**
	 * @param themes the themes to set
	 */
	public void setThemes(List<Theme> themes)
	{
		this.themes = themes;
	}

	/**
	 * @return the theme
	 */
	public String getTheme()
	{
		return theme;
	}

	/**
	 * @param theme the theme to set
	 */
	public void setTheme(String theme)
	{
		this.theme = theme;
	}

	/**
	 * @return the themeService
	 */
	public ThemeService getThemeService()
	{
		return themeService;
	}

	/**
	 * @param themeService the themeService to set
	 */
	public void setThemeService(ThemeService themeService)
	{
		this.themeService = themeService;
	}    
		

	@PostConstruct
    public void init() 
    {
        themes = themeService.getThemes();
        FacesContext context = FacesContext.getCurrentInstance();
    	setTheme(context.getExternalContext().getInitParameter("primefaces.THEME"));       
    }	
}
