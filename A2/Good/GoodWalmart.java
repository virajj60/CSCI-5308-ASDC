package com.dalhousie;

import java.util.HashMap;

public class GoodWalmart implements ISuperStoreProduce , ISuperStoreItems{

	HashMap<String,Integer> walmartProductTable = new HashMap<String,Integer>();
	HashMap<Integer,Float> walmartProductPriceTable = new HashMap<Integer, Float>();
	
	@Override
	public int scanItem(String itemName) {
		if(walmartProductTable.containsKey(itemName)) {
			return walmartProductTable.get(itemName);
		}else {
			System.out.println("Item Not Found");
			return -999;
		}
	}

	@Override
	public float getPriceByUPC(int UPC) {
		if(walmartProductPriceTable.containsKey(UPC)) {
			return walmartProductPriceTable.get(UPC);
		}else {
			System.out.println("Item Price not available");
			return -999;
		}
	}

	@Override
	public float getPriceByProduceWeight(int UPC, float itemWeight) {
		if(walmartProductPriceTable.containsKey(UPC)) {
			return walmartProductPriceTable.get(UPC)*itemWeight;
		}else {
			System.out.println("Item Price not available");
			return -999;
		}
	} 
}
