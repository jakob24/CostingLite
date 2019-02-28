/**
 * 
 */
package com.artisans.inventory.helper;

import java.util.List;

import org.apache.commons.math3.util.MathUtils;
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
		if(isUSDInvoice(shipmentProductVO)) {
			shipmentProductVO.setCostPriceGbp(productVO.getCostPriceUsd()/shipmentProductVO.getGbpToUsd());
		} else {
			shipmentProductVO.setCostPriceGbp(productVO.getCostPriceGbp());
		}		
		
		shipmentProductVO.setDate(shipmentProductVO.getShipment().getDeliveryDate());
		shipmentProductVO.setInventory(productVO.getInventory());
		return shipmentProductVO;
	}
	
	/*
	 * Method to check if the invoice is pais in USD
	 */
	public static boolean isUSDInvoice(ShipmentProductVO shipmentProductVO) {
		List<PaymentVO> paymentList =  shipmentProductVO.getShipment().getInvoice().getPayment();
		PaymentVO paymentVO = paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase("INVOICE")).findFirst().orElse(null);	
		if(null != paymentVO && null != paymentVO.getAmountUsd() && paymentVO.getAmountUsd() > 0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Get the conversion rate (GBP to USD) for the invoice Payment
	 * Take the average conversion rate of all invoice payments
	 */
	public static Double getInvoiceConversionRate(ShipmentProductVO shipmentProductVO) {
		Double totalRate = 0D;
		Double rate = 0D;
		int count = 0;
		List<PaymentVO> paymentList =  shipmentProductVO.getShipment().getInvoice().getPayment();
		paymentList.stream().filter(i -> i.getPaymentType().equalsIgnoreCase("INVOICE"));		
		for(PaymentVO paymentVO : paymentList) {
			if(null != paymentVO.getAmountUsd() && paymentVO.getAmountUsd() > 0) {
				totalRate += paymentVO.getGbpToUsd();
				count++;
			} else {
				totalRate = 1D;
				count = 1;
				break;
			}
		}		
		rate = totalRate/count;
		return Precision.round(rate, 4);
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
			totalOtherCosts += 	paymentVO.getAmount() + paymentVO.getBankCharges() + paymentVO.getOtherCharges() +  paymentVO.getDisbursementCharges() + paymentVO.getVat();
		}	
		
		Double totalShipmentAmount = invoiceAmount + totalOtherCosts;
		percentage = Precision.round((totalShipmentAmount * 100) / invoiceAmount, 4);
		return percentage;
	}
}
