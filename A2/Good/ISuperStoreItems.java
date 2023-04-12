package com.dalhousie;

public interface ISuperStoreItems {
	//input - itemName , returns - Universal Product Code (UPC)
    public int scanItem(String itemName);
    
  //input - product UPC , returns - product price
    public float getPriceByUPC(int UPC);
}
