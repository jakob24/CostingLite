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

import com.artisans.inventory.helper.ReportEnum;

/**
 * @author Jacob
 *
 */
@Scope(value = "session")
@Component(value = "loginController")
public class LoginController extends BaseWizard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		item.setIcon("fa fa-home");
		item.setHref("index.xhtml");
		firstSubmenu.addElement(item);
		
		item = new DefaultMenuItem("Settings");		
		item.setCommand(INVOICE_ENTRY_METHOD);
		item.setIcon("fa fa-book");
		item.setHref("mySettings.xhtml");
		firstSubmenu.addElement(item);	
		
		topMenu.addElement(firstSubmenu);
				
		DefaultSubMenu invoiceSubmenu = new DefaultSubMenu("Invoices");		
		item = new DefaultMenuItem("Manage Invoices");		
		item.setCommand(INVOICE_ENTRY_METHOD);
		item.setIcon("fa fa-book");
		invoiceSubmenu.addElement(item);
		topMenu.addElement(invoiceSubmenu);	
		
		DefaultSubMenu shipmentSubmenu = new DefaultSubMenu("Shipments");		
		item = new DefaultMenuItem("Manage Shipments");		
		//item.setHref("shipments.xhtml");
		item.setIcon("fa fa-ship");
		item.setCommand(SHIPMENT_ENTRY_METHOD);		
		shipmentSubmenu.addElement(item);		
		
		item = new DefaultMenuItem("Manage Shipment Products");		
		item.setHref("shipmentProduct.xhtml");
		item.setIcon("fa fa-product-hunt");
		//item.setCommand(SHIPMENT_ENTRY_METHOD);		
		shipmentSubmenu.addElement(item);
		topMenu.addElement(shipmentSubmenu);
		
						
		DefaultSubMenu dataSubmenu = new DefaultSubMenu("Data");		
		item = new DefaultMenuItem("Maintain Product");		
		item.setHref("product.xhtml");
		item.setIcon("fa fa-cart-plus");
		dataSubmenu.addElement(item);	
				
		item = new DefaultMenuItem("Maintain Courier");		
		item.setHref("courier.xhtml");
		item.setIcon("fa fa-ship");
		dataSubmenu.addElement(item);	
		
		item = new DefaultMenuItem("Maintain Supplier");		
		item.setHref("supplier.xhtml");
		item.setIcon("fa fa-user-secret");
		dataSubmenu.addElement(item);
					
		item = new DefaultMenuItem("Maintain User");		
		item.setIcon("fa fa-user-plus");
		dataSubmenu.addElement(item);	
		topMenu.addElement(dataSubmenu);
				
		DefaultSubMenu reportSubmenu = new DefaultSubMenu("Reports");		
		item = new DefaultMenuItem("Full Inventory Report");
		item.setCommand("#{ReportsController.generateInventoryReport}");
		item.setIcon("fa fa-cart-plus");
		item.setAjax(false);
		reportSubmenu.addElement(item);	
				
		item = new DefaultMenuItem("Shipment Costing Report");		
		item.setCommand("#{ReportsController.setPageForReport}");
		item.setParam("reportType", ReportEnum.SHIPMENT_COSTING);
		item.setIcon("fa fa-gbp");
		reportSubmenu.addElement(item);	
		
		item = new DefaultMenuItem("Invoice Report");		
		item.setCommand("#{ReportsController.setPageForReport}");
		item.setParam("reportType", ReportEnum.INVOICE);
		item.setIcon("fa fa-money");
		reportSubmenu.addElement(item);			
		
		item = new DefaultMenuItem("All Invoices Report");		
		item.setCommand("#{ReportsController.setPageForReport}");
		item.setParam("reportType", ReportEnum.ALL_INVOICES);
		item.setIcon("fa fa-money");
		reportSubmenu.addElement(item);			
							
		topMenu.addElement(reportSubmenu);			
	}	 	
}
