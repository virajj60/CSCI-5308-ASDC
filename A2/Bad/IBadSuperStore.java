package com.dalhousie;

public interface IBadSuperStore {
	//input - itemName , returns - Universal Product Code (UPC)
    public int scanItem(String itemName);
    
    //input - product UPC , returns - product price
    public float getPriceByUPC(int UPC);
    
    //input - product UPC, itemWeight  returns - price for total weight
    public float getPriceByProduceWeight(int UPC, float itemWeight);
}
