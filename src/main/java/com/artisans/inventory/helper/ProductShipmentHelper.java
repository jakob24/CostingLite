/**
 * 
 */
package com.artisans.inventory.helper;

import java.util.List;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.artisans.inventory.controller.ShipmentWizard;
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
	
	private static ApplicationConfiguration configUtil;
	
	final static Logger log = LoggerFactory.getLogger(ShipmentWizard.class);
	
	@SuppressWarnings("unused")
	private ProductShipmentHelper() {
		
	}
	
	
	/**
	 * Copy values from the ProductVO to ShipmentProductVO
	 * @param productVO
	 * @param shipmentProductVO
	 * @return
	 */			
	public static ShipmentProductVO populateDefaultProductValues(ProductVO productVO, ShipmentProductVO shipmentProductVO, boolean invoiceInUSD) {	
		
		if(invoiceInUSD) {
			shipmentProductVO.setGbpToUsd(getInvoiceConversionRate(shipmentProductVO));
			shipmentProductVO.setCostPriceUsd(productVO.getCostPriceUsd());
		} else {
			shipmentProductVO.setGbpToUsd(1D);
		}
		
		shipmentProductVO.setOtherCharges(productVO.getOtherCharges());
		shipmentProductVO.setWebRrp(productVO.getWebRrp());
		shipmentProductVO.setEbayRrp(productVO.getEbayRrp());
		
		//Ebay Fees
		if(null == productVO.getEbayFees() && null != productVO.getEbayRrp()) {
			Double ebayFees = new Double(configUtil.getProperty("ebay.approx.charge.percentage"));
			shipmentProductVO.setEbayFees(Precision.round(productVO.getEbayRrp() * (ebayFees/100),2));
			
		} else {
			shipmentProductVO.setEbayFees(productVO.getEbayFees());
		}
				
		shipmentProductVO.setAmzRrp(productVO.getAmzRrp());
		
		//Amazon Fees
		shipmentProductVO.setAmzFees(productVO.getAmzFees());

		//Amz FBA
		shipmentProductVO.setAmzFbaFees(productVO.getAmzFbaFees());
		
		//Amz DE FBA
		shipmentProductVO.setAmzDeRrp(productVO.getAmzDeRrp());
		shipmentProductVO.setAmzDeFbaFees(productVO.getAmzDeFbaFees());
		
		//Amz FR FBA	
		shipmentProductVO.setAmzFrRrp(productVO.getAmzFrRrp());
		shipmentProductVO.setAmzFrFbaFees(productVO.getAmzFrFbaFees());
		
		if(isUSDInvoice(shipmentProductVO)) {
			shipmentProductVO.setCostPriceGbp(Precision.round(productVO.getCostPriceUsd()/shipmentProductVO.getGbpToUsd(),2));
		} else {
			shipmentProductVO.setCostPriceGbp(productVO.getCostPriceGbp());
		}		
		
		shipmentProductVO.setDate(shipmentProductVO.getShipment().getDeliveryDate());
		shipmentProductVO.setInventory(productVO.getInventory());
		return shipmentProductVO;
	}
	
	/*
	 * Method to check if the invoice is paid in USD
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
			
			//Calculate profits
			calculateShipmentProductProfit(shipmentProductVO);
		}		
		return shipmentProductVOList;		
	}
	
	/**
	 * Calculate all the costs and pricing for all the products in the List
	 * @param shipmentProductVO
	 * @return
	 */
	private static ShipmentProductVO calculateShipmentProductProfit(ShipmentProductVO shipmentProductVO) {
		
		Double profit = null;
		Double freeShipThreshhold = new Double(configUtil.getProperty("web.freepostage.threshhold"));
		Double webPostalCharge = new Double(configUtil.getProperty("web.below.threshhold.postage"));
		
		Double paypalFeePercentage = new Double(configUtil.getProperty("ebay.paypal.fee.percentage"));
		Double paypalFixedCost = new Double(configUtil.getProperty("ebay.paypal.fee.fixed"));
		Double ebayListingCost = new Double(configUtil.getProperty("ebay.listing.cost"));
		Double ebayFeePercentage = new Double(configUtil.getProperty("ebay.approx.charge.percentage"));						
		Double amzReferalFeePercentage = new Double(configUtil.getProperty("amazon.referalfee.percentage"));
		Double amzFeeTaxPercentage = new Double(configUtil.getProperty("amazon.fee.tax.percentage"));
		
		Double fixedCosts =  shipmentProductVO.getLandingCostGbp() + shipmentProductVO.getProduct().getPackingCharges() + 
				shipmentProductVO.getOtherCharges();								
		log.debug("Fixed Cost ->" + fixedCosts);		
		
		//Web Profit
		if(null != shipmentProductVO.getWebRrp()) {			
			if(shipmentProductVO.getWebRrp() > freeShipThreshhold) {
				profit = shipmentProductVO.getWebRrp() - fixedCosts	- shipmentProductVO.getProduct().getPostageCharges()  
						 - (shipmentProductVO.getWebRrp() * (shipmentProductVO.getProduct().getWebPpCharge()/100));
			} else {
				
				Double totalWebCost = shipmentProductVO.getWebRrp() + webPostalCharge;
				profit = totalWebCost - fixedCosts	- shipmentProductVO.getProduct().getPostageCharges()
						- (totalWebCost * (shipmentProductVO.getProduct().getWebPpCharge()/100));				
			}			
			shipmentProductVO.setWebProfit(Precision.round(profit, 2));
		}
		
		//Ebay Profit
		if(null != shipmentProductVO.getEbayRrp()) {
			
			if(null == shipmentProductVO.getEbayFees()) {
				Double ebayFee = shipmentProductVO.getEbayRrp() * (ebayFeePercentage/100);
				shipmentProductVO.setEbayFees(Precision.round(ebayFee, 2));
			}				
			Double paypalFees = Precision.round((shipmentProductVO.getEbayRrp() * (paypalFeePercentage /100) + paypalFixedCost), 2);	
			log.debug("Ebay PayPal Fess ->" + paypalFees);
			
			profit = shipmentProductVO.getEbayRrp() - fixedCosts - shipmentProductVO.getProduct().getPostageCharges() 
					- shipmentProductVO.getEbayFees() - paypalFees - ebayListingCost;
			
			shipmentProductVO.setEbayProfit(Precision.round(profit, 2));		
		}			
		
		//AMZ Profit
		Double referalFee = Precision.round(shipmentProductVO.getAmzRrp() *(amzReferalFeePercentage/100),2);
		
		if(null != shipmentProductVO.getAmzRrp()) {
			if(null == shipmentProductVO.getAmzFees()) {
				shipmentProductVO.setAmzFees(referalFee);
			}
			Double taxOnFee = (shipmentProductVO.getAmzFees() * (amzFeeTaxPercentage/100));	
			log.debug("Amz Referral Fee->" + referalFee + ", Amz Fee Tax ->" + taxOnFee);
			
			profit = shipmentProductVO.getAmzRrp() - fixedCosts - shipmentProductVO.getProduct().getPostageCharges()
					 - shipmentProductVO.getAmzFees() - taxOnFee;
			shipmentProductVO.setAmzProfit(Precision.round(profit, 2));	
			
			
			//AMZ FBA Profit
			if(null != shipmentProductVO.getAmzFbaFees()) {
				Double taxOnFBAFee = (shipmentProductVO.getAmzFbaFees() * (amzFeeTaxPercentage/100));
				
				profit = shipmentProductVO.getAmzRrp() - fixedCosts 
						-shipmentProductVO.getAmzFbaFees() - taxOnFBAFee;
				shipmentProductVO.setAmzFbaProfit(Precision.round(profit, 2));
				log.debug("Amz FBA Fee Tax ->" + taxOnFee);
			}	 
			
			//AMZ DE FBA Profit
			if(null != shipmentProductVO.getAmzDeRrp() && null != shipmentProductVO.getAmzDeFbaFees()) {
				Double taxOnFBAFee = (shipmentProductVO.getAmzDeFbaFees() * (amzFeeTaxPercentage/100));
				
				profit = shipmentProductVO.getAmzDeRrp() - fixedCosts 
						-shipmentProductVO.getAmzDeFbaFees() - taxOnFBAFee;
				shipmentProductVO.setAmzDeFbaProfit(Precision.round(profit, 2));
				log.debug("Amz De FBA Fee Tax ->" + taxOnFee);				
			}
			
			//AMZ FR FBA Profit
			if(null != shipmentProductVO.getAmzFrRrp() && null != shipmentProductVO.getAmzFrFbaFees()) {
				Double taxOnFBAFee = (shipmentProductVO.getAmzFrFbaFees() * (amzFeeTaxPercentage/100));
				
				profit = shipmentProductVO.getAmzFrRrp() - fixedCosts 
						-shipmentProductVO.getAmzFrFbaFees() - taxOnFBAFee;
				shipmentProductVO.setAmzFrFbaProfit(Precision.round(profit, 2));
				log.debug("Amz Fr FBA Fee Tax ->" + taxOnFee);				
			}			
		}
		return shipmentProductVO;		
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


	/**
	 * @return the configUtil
	 */
	public static ApplicationConfiguration getConfigUtil() {
		return configUtil;
	}


	/**
	 * @param configUtil the configUtil to set
	 */
	public static void setConfigUtil(ApplicationConfiguration configUtil) {
		ProductShipmentHelper.configUtil = configUtil;
	}			
}
