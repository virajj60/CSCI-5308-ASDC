import java.util.HashMap;

class ShareManagementTest {
	
    ShareManagement shareMgtTest = new ShareManagement();
    public HashMap<String, Double> availableSharesTest =  new HashMap<String, Double>();
    
    public ShareManagementTest() {
		
    	availableSharesTest.put("Federal_Bank", 119.20);
		availableSharesTest.put("Chemcon", 351.14);
		availableSharesTest.put("ICICI_Bank", 912.12);
		availableSharesTest.put("Nirlon", 361.55);
		availableSharesTest.put("Cholafin",786.50);
	}
    
    public void addUpdateAvailableSharesAddSuccessTest() {
		String shareName = "FSL";
		double price = 106.95;
		shareMgtTest.addUpdateAvailableShares(shareMgtTest, shareName, price);
		if(ShareManagement.getAvailableShares().containsKey(shareName)) {
			System.out.println("Test addUpdateAvailableSharesAddSuccessTest() : PASSED ");
		}else {
			System.out.println("Test addUpdateAvailableSharesAddSuccessTest() : PASSED ");
		}
	}
    
    public void addUpdateAvailableSharesAddFailureTest() {
		String shareName = "FSL";
		double price =-106.95;
		shareMgtTest.addUpdateAvailableShares(shareMgtTest, shareName, price);
		if(!ShareManagement.getAvailableShares().containsKey(shareName)) {
			System.out.println("Test addUpdateAvailableSharesAddFailureTest() : PASSED ");
		}else {
			System.out.println("Test addUpdateAvailableSharesAddFailureTest() : PASSED ");
		}
	}
    
    public void  addUpdateAvailableSharesUpdateSuccessTest() {
    	String shareName = "FSL";
    	double updatedPrice = 107.98;
    	shareMgtTest.addUpdateAvailableShares(shareMgtTest, shareName, updatedPrice);
    	if(ShareManagement.getAvailableShares().get(shareName) == 107.98) {
    		System.out.println("Test addUpdateAvailableSharesUpdateSuccessTest() : PASSED ");
    	}else {
    		System.out.println("Test addUpdateAvailableSharesUpdateSuccessTest() : FAILURE ");
    	}
    }
    
    public void  addUpdateAvailableSharesUpdateFailureTest() {
    	String shareName = "FSL";
    	double updatedPrice = 0.00;
    	shareMgtTest.addUpdateAvailableShares(shareMgtTest, shareName, updatedPrice);
    	if(!(ShareManagement.getAvailableShares().get(shareName) == 0.00)) {
    		System.out.println("Test addUpdateAvailableSharesUpdateFailureTest() : PASSED ");
    	}else {
    		System.out.println("Test addUpdateAvailableSharesUpdateFailureTest() : FAILURE ");
    	}
    }
}