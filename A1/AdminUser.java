import java.util.HashMap;

public class AdminUser implements IUser{
	private String admin_Id = "admin";
	private String admin_password = "admin123";

	public String getAdmin_Id() {
		return admin_Id;
	}

	public String getAdmin_password() {
		return admin_password;
	}
	
	public AuthenticationResult validateCredentials(String admin_Id, String admin_password) {
		if (admin_Id.equals(getAdmin_Id()) && admin_password.equals(getAdmin_password())) {
			return AuthenticationResult.LOGIN_SUCCESS;
		} else {
			return AuthenticationResult.LOGIN_FAILURE;
		}
	}

	@Override
	public HashMap<String, Integer> getPortfolio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Double> getWatchList() {
		// TODO Auto-generated method stub
		return null;
	}
}