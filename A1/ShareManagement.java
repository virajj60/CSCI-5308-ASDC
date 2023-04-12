import java.util.HashMap;

public class ShareManagement {

	private static HashMap<String, Double> availableShares = new HashMap<String, Double>();

	public ShareManagement() {
		availableShares.put("Federal_Bank", 119.20);
		availableShares.put("Chemcon", 351.14);
		availableShares.put("ICICI_Bank", 912.12);
		availableShares.put("TTML", 122.70);
		availableShares.put("TCS", 3125.0);
		availableShares.put("ITC", 335.75);
		availableShares.put("Gujarat_Themis",609.34);
		availableShares.put("Olectra",625.70);
		availableShares.put("Dhani",58.50);
		availableShares.put("Hudco",42.35);
		availableShares.put("SAIL", 83.90);
		availableShares.put("Adani_Power", 387.55);
		availableShares.put("Wipro", 417.00);
		availableShares.put("Nirlon", 361.55);
		availableShares.put("Cholafin",786.50);
	}

	public static HashMap<String, Double> getAvailableShares() {
		return availableShares;
	}
	
	public boolean addUpdateAvailableShares(ShareManagement shareMgt, String shareName, double updatedPrice) {
		if(updatedPrice > 0) {
			shareMgt.getAvailableShares().put(shareName, updatedPrice);
			return true;
		}else {
			System.out.println(" Share price can not be negative ");
			return false;
		}
	}
}