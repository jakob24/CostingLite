/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.vo.InvoiceVO;

/**
 * @author Jacob
 *
 */
public class InvoiceVOTransformer implements Transformer
{
    public Invoice transform(Object invoiceVOObj)
    {
     	if(invoiceVOObj == null)
    	{
    		throw new IllegalArgumentException("The input invoiceVOObj is empty.");
    	}
    	else if(! (invoiceVOObj instanceof InvoiceVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToInvoice((InvoiceVO)invoiceVOObj);
    }
    	
	
	private static Invoice transformToInvoice(InvoiceVO invoiceVO)
	{
		Invoice invoice = new DozerBeanMapper().map(invoiceVO, Invoice.class);   
		return invoice;
	}
}
