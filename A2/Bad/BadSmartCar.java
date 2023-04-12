package com.dalhousie;

public class BadSmartCar extends BadVehicle {
	static final boolean correctKey = true;
	static boolean engineOn;
	static int currentGear=0;
	static int alcoSensor =0;
	
	@Override
	void start() {
		if(correctKey) {
			engineOn = true;
			currentGear =1;
		}
	}

	@Override
	void accelerate() {
		currentGear ++;		
	}

	@Override
	void brake() {
		while(currentGear!=0) {
			currentGear --;
		}
		engineOn = false;
	}

	@Override
	void drunkDriveCheck() {
		if(alcoSensor < 30) {
			brake();
		}
	}
}
