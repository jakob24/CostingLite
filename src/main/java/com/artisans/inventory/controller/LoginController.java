/**
 * 
 */
package com.artisans.inventory.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Jacob
 *
 */
@Scope(value = "session")
@Component(value = "loginController")
public class LoginController implements Serializable {

	private MenuModel topMenu;
	
	/**
	 * @return the topMenu
	 */
	public MenuModel getTopMenu() {
		return topMenu;
	}

	/**
	 * @param topMenu the topMenu to set
	 */
	public void setTopMenu(MenuModel topMenu) {
		this.topMenu = topMenu;
	}


	@PostConstruct
	public void init() 
	{	
		topMenu = new DefaultMenuModel();
		
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("Home");
		DefaultMenuItem item = new DefaultMenuItem("Home");	
		item.setIcon("fa fa-automobile");
		firstSubmenu.addElement(item);
		topMenu.addElement(firstSubmenu);
				
		DefaultSubMenu invoiceSubmenu = new DefaultSubMenu("Invoice");
		
		item = new DefaultMenuItem("New");		
		item.setHref("newInvoice.xhtml");
		item.setIcon("fa fa-user");
		invoiceSubmenu.addElement(item);	
				
		item = new DefaultMenuItem("Update");		
		item.setHref("editInvoice.xhtml");
		item.setIcon("fa fa-cogs");
		invoiceSubmenu.addElement(item);	
		
		topMenu.addElement(invoiceSubmenu);	
						
		DefaultSubMenu dataSubmenu = new DefaultSubMenu("Data");
		
		item = new DefaultMenuItem("Maintain Product");		
		item.setHref("product.xhtml");
		item.setIcon("fa fa-user");
		dataSubmenu.addElement(item);	
				
		item = new DefaultMenuItem("Maintain Courier");		
		item.setHref("courier.xhtml");
		item.setIcon("fa fa-cogs");
		dataSubmenu.addElement(item);	
		
		item = new DefaultMenuItem("Maintain Supplier");		
		item.setHref("supplier.xhtml");
		item.setIcon("fa fa-file-archive-o");
		dataSubmenu.addElement(item);
		
		item = new DefaultMenuItem("Maintain User");		
		//item.setOutcome("subscription");
		item.setIcon("fa fa-paypal");
		dataSubmenu.addElement(item);	
							
		topMenu.addElement(dataSubmenu);			
	}
}
