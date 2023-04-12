import java.util.HashMap;

public class CustomerUserMock implements IUser {
  
	private String customer_name;
	private String customer_Id;
	private String customer_password;

	private HashMap<String, Integer> portfolio = new HashMap<String, Integer>();
	private HashMap<String, Double> watchList = new HashMap<String, Double>();

	CustomerUserMock() {
		customer_name = "viraj";
		customer_Id = "vjoshi";
		customer_password = "viraj123";
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
	
	public AuthenticationResult validateCredentials (String cust_Id, String cust_password) {
	  if (getCustomer_Id().equals(cust_Id) && getCustomer_password().equals(cust_password)) {
		  return AuthenticationResult.LOGIN_SUCCESS; 
		  } else {
			  return AuthenticationResult.LOGIN_FAILURE; }
	  }
}