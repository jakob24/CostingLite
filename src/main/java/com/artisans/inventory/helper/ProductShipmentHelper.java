/**
 * 
 */
package com.artisans.inventory.helper;

import java.util.List;

import com.artisans.inventory.vo.PaymentVO;
import com.artisans.inventory.vo.ProductVO;
import com.artisans.inventory.vo.ShipmentProductVO;

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
		
		for(ShipmentProductVO shipmentProductVO : shipmentProductVOList) {
			
			
			
			
			shipmentProductVO.setLandingCostGbp(12D);
		}		
		return shipmentProductVOList;
		
	}
}
