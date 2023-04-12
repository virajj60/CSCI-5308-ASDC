import java.util.HashMap;

public interface IUser {
	
	
	public enum AuthenticationResult{ LOGIN_SUCCESS, LOGIN_FAILURE }
	  
	public AuthenticationResult validateCredentials(String Id, String password);
	public HashMap<String, Integer> getPortfolio(); 
	public HashMap<String,Double> getWatchList();
	  
}