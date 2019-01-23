/**
 * 
 */
package com.artisans.inventory.helper;

import java.util.List;

import org.apache.commons.math3.util.Precision;

import com.artisans.inventory.vo.InvoiceVO;
import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.ShipmentProductVO;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author bjacob
 *
 *Helper class for Shipment product
 */
public class ProductShipmentHelper {

	/**
	 * Copy values from the ProductVO to ShipmentProductVO
	 * @param productVO
	 * @param shipmentProductVO
	 * @return
	 */
	public static ShipmentProductVO populateDefaultProductValues(ProductVO productVO, ShipmentProductVO shipmentProductVO) {
		
		shipmentProductVO.setGbpToUsd(getInvoiceConversionRate(shipmentProductVO));
		shipmentProductVO.setOtherCharges(productVO.getOtherCharges());
		shipmentProductVO.setWebRrp(productVO.getWebRrp());
		shipmentProductVO.setEbayRrp(productVO.getEbayRrp());
		shipmentProductVO.setEbayFees(productVO.getEbayFees());
		shipmentProductVO.setAmzRrp(productVO.getAmzRrp());
		shipmentProductVO.setAmzFees(productVO.getAmzFees());
		shipmentProductVO.setAmzFbaFees(productVO.getAmzFbaFees());	
		shipmentProductVO.setCostPriceUsd(productVO.getCostPriceUsd());
		shipmentProductVO.setCostPriceGbp(productVO.getCostPriceGbp());
		shipmentProductVO.setDate(shipmentProductVO.getShipment().getDeliveryDate());
		return shipmentProductVO;
	}
	
	/**
	 * Get the conversion rate (GBP to USD) for the invoice Payment
	 */
	public static Double getInvoiceConversionRate(ShipmentProductVO shipmentProductVO) {
		Double rate =1D;

		List<PaymentVO> paymentList =  shipmentProductVO.getShipment().getInvoice().getPayment();
		paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase("INVOICE")).findFirst();		
		rate = paymentList.get(0).getAmountUsd()==null? 1D : paymentList.get(0).getGbpToUsd();
		return rate;
	}
	
	/**
	 * Calculate all the costs and pricing for all the products in the List
	 * @param shipmentProductVO
	 * @return
	 */
	public static List<ShipmentProductVO> calculateShipmentProductprices(List<ShipmentProductVO> shipmentProductVOList) {
		
		InvoiceVO invoiceVO = null;		
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			
			//Get Invoice Details
			if(null == invoiceVO) {
				invoiceVO = shipmentProductVO.getShipment().getInvoice();
			}			
			
			Double landingCostpercentage = calculateLandingCostPercentage(invoiceVO, shipmentProductVO.getShipment());		
			shipmentProductVO.setLandingCostGbp(Precision.round(((shipmentProductVO.getCostPriceGbp() * landingCostpercentage)/100),2));
		}		
		return shipmentProductVOList;		
	}
	
	/**
	 * Calculate the overall landing cost based on overall additional costs
	 * @param invoiceVO
	 * @param shipmentVO
	 * @return
	 */
	public static Double calculateLandingCostPercentage(InvoiceVO invoiceVO, ShipmentVO shipmentVO) {
		
		Double percentage = null;
		Double totalOtherCosts = 0D;
		Double invoiceAmount = 0D;
				
		//Get all other Payments related to invoice
		for (PaymentVO paymentVO : invoiceVO.getPayment()) {
			invoiceAmount += paymentVO.getAmount(); 
			totalOtherCosts += paymentVO.getBankCharges() + paymentVO.getOtherCharges();
		}
		
		//Get all Payments related to Shipment
		for (PaymentVO paymentVO : shipmentVO.getPayment()) {
			totalOtherCosts += 	paymentVO.getAmount() + paymentVO.getBankCharges() + paymentVO.getOtherCharges() +  paymentVO.getDisbursementCharges();
		}	
		
		Double totalShipmentAmount = invoiceAmount + totalOtherCosts;
		percentage = Precision.round((totalShipmentAmount * 100) / invoiceAmount, 4);
		return percentage;
	}
}
