package com.dalhousie;

import java.util.HashMap;

public class GoodCanadianTire implements ISuperStoreItems {

	HashMap<String,Integer> cadTireProductTable = new HashMap<String,Integer>();
	HashMap<Integer,Float> cadTireProductPriceTable = new HashMap<Integer, Float>();
	
	@Override
	public int scanItem(String itemName) {
		if(cadTireProductTable.containsKey(itemName)) {
			return cadTireProductTable.get(itemName);
		}else {
			System.out.println("Item Not Found");
			return -999;
		}
	}

	@Override
	public float getPriceByUPC(int UPC) {
		if(cadTireProductPriceTable.containsKey(UPC)) {
			return cadTireProductPriceTable.get(UPC);
		}else {
			System.out.println("Item Price not available");
			return -999;
		}
	}
}
