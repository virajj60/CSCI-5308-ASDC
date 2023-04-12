import java.util.HashMap;

public class CustomerUserMockTest implements IUser {
	private String customer_name;
	private String customer_Id;
	private String customer_password;

	private HashMap<String, Integer> portfolio = new HashMap<String, Integer>();
	private HashMap<String, Double> watchList = new HashMap<String, Double>();
    
	/* Set stable and known values to mock customer data which is used by the test cases */
	CustomerUserMockTest() {
		customer_name = "virajTest";
		customer_Id = "vjoshitest";
		customer_password = "viraj123test";

		portfolio.put("Federal_Bank", 100);
		portfolio.put("ICICI_Bank", 20);
		portfolio.put("Chemcon", 50);
		portfolio.put("TCS", 10);
		portfolio.put("ITC", 25);

		watchList.put("Gujarat_Themis", 609.34);
		watchList.put("Olectra", 625.70);
		watchList.put("TTML", 122.70);
		watchList.put("Hudco", 42.35);
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public String getCustomer_Id() {
		return customer_Id;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public HashMap<String, Integer> getPortfolio() {
		return portfolio;
	}

	public HashMap<String, Double> getWatchList() {
		return watchList;
	}

	public AuthenticationResult validateCredentials(String cust_Id, String cust_password) {
		if (getCustomer_Id().equals(cust_Id) && getCustomer_password().equals(cust_password)) {
			return AuthenticationResult.LOGIN_SUCCESS;
		} else {
			return AuthenticationResult.LOGIN_FAILURE;
		}
	}

	public void getCustomer_nameSuccessTest() {
		if (("virajTest").equals(getCustomer_name())) {
			System.out.println("Test getCustomer_nameSuccessTest : PASSED");
		} else {
			System.out.println("Test getCustomer_nameSuccessTest : FAILED");
		}
	}

	public void getCustomer_passwordSuccessTest() {
		if ("viraj123test".equals(getCustomer_password())) {
			System.out.println("Test getCustomer_passwordSuccessTest() : PASSED");
		} else {
			System.out.println("Test getCustomer_passwordSuccessTest() : FAILED");
		}
	}

	public void getCustomer_passwordFailureTest() {
		if (!("viraj123").equals(getCustomer_password())) {
			System.out.println("Test getCustomer_passwordSuccessTest() : PASSED");
		} else {
			System.out.println("Test getCustomer_passwordSuccessTest() : FAILED");
		}
	}

	public void getPortfolioSuccessTest() {
		if (getPortfolio().size() == 5) {
			System.out.println("Test getPortfolioSuccessTest() : PASSED");
		} else {
			System.out.println("Test getPortfolioSuccessTest() : FAILED");
		}
	}

	public void getWatchlistSuccessTest() {
		if (getWatchList().size() == 4) {
			System.out.println("Test getPortfolioSuccessTest() : PASSED");
		} else {
			System.out.println("Test getPortfolioSuccessTest() : FAILED");
		}
	}

	public void validateCredentialsSuccessTest() {
		String admin_Id = "vjoshitest";
		String admin_password = "viraj123test";
		if (validateCredentials(admin_Id, admin_password) == AuthenticationResult.LOGIN_SUCCESS) {
			System.out.println("Test validateCredentialsSuccessTest() : PASSED ");
		} else {
			System.out.println("Test validateCredentialsSuccessTest() : FAILED ");
		}
	}

	public void validateCredentialsFailureTest() {
		String admin_Id = "virajjoshi";
		String admin_password = "virajjoshi123";
		if (validateCredentials(admin_Id, admin_password) == AuthenticationResult.LOGIN_FAILURE) {
			System.out.println("Test validateCredentialsSuccessTest() : PASSED ");
		} else {
			System.out.println("Test validateCredentialsSuccessTest() : FAILED ");
		}
	}
}