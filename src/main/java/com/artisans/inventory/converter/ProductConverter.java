/**
 * 
 */
package com.artisans.inventory.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artisans.inventory.controller.ReferenceDataController;
import com.artisans.inventory.vo.ProductVO;

/**
 * @author bjacob
 *
 */
@SuppressWarnings("rawtypes")
@Component(value = "ProductConverter")
@FacesConverter("com.artisans.inventory.converter.ProductConverter")
public class ProductConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private ReferenceDataController referenceDataController;			

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		Object selectedProduct = null;		
		List<ProductVO>products = referenceDataController.getProductVOList();			
		for(ProductVO product : products)
		{
			if(product.getProductId() == new Long(value).longValue())
			{
				selectedProduct =  product;
				break;
			}
		}		
		return selectedProduct;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if( null != value && value != "")
		{
			return new Long(((ProductVO) value).getProductId()).toString(); 
		}
		else
		{
			return value==null ? "": value.toString();
		}		
	}	
}
