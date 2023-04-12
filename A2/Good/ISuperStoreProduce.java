package com.dalhousie;

public interface ISuperStoreProduce {
	//input - product UPC, itemWeight  returns - price for total weight
    public float getPriceByProduceWeight(int UPC, float itemWeight);
}
