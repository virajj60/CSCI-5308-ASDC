import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Run unit tests if "test" passed as a JVM argument. All unit tests are expected to
		 * PASS. Test cases would use mock customer data values set in class CustomerMockTest.
		 * CustomerMock and CustomerMockTest implements interface IUSer
		 */
		if ((args.length) == 0 ? false: args[0].equals("test")) {
			CustomerHomePageTest custHomeTest = new CustomerHomePageTest();
			custHomeTest.displayPortfolioSuccessTest();
			custHomeTest.displayWatchListSuccessTest();
			custHomeTest.purchaseSharesSuccessTest();
			custHomeTest.validatePurchaseRequestSuccessTest();
			custHomeTest.validatePurchaseRequestNotAvlbFailureTest();
			custHomeTest.validatePurchaseRequestZeroQtyFailureTest();
			custHomeTest.validatePurchaseRequestMaxPriceFailureTest();
			custHomeTest.sellSharesSuccessTest();
			custHomeTest.validateSellRequestSuccessTest();
			custHomeTest.validateSellRequestNotAvlbFailureTest();
			custHomeTest.validateSellRequestQtyFailureTest();
			custHomeTest.validateSellRequestMinPriceFailureTest();
			custHomeTest.addToWatchlistSuccessTest();
			custHomeTest.validateAddToWatchListSuccessTest();
			custHomeTest.validateAddToWatchListAlreadyExistFailureTest();
			custHomeTest.validateAddToWatchListNotAvlbFailureTest();
			custHomeTest.removeFromWatchListSuccessTest();
			custHomeTest.validateRemoveFromWatchlistNotExistFailureTest();

			CustomerDBOperationsTest custDBMock = new CustomerDBOperationsTest();
			custDBMock.persistAddToPortfolioSuccessTest();
			custDBMock.persistAddToPortfolioFailureTest();
			custDBMock.persistRemoveFromPortfolioSuccessTest();
			custDBMock.persistRemoveFromPortfolioFailureTest();
			custDBMock.persistAddToWatchlistSuccessTest();
			custDBMock.persistAddToWatchlistSuccessTest();
			custDBMock.commitSuccesstest();
			custDBMock.rollbackSuccesstest();
			
			CustomerUserMockTest cusTest = new CustomerUserMockTest();
			cusTest.getCustomer_nameSuccessTest();
			cusTest.getCustomer_passwordSuccessTest();
			cusTest.getCustomer_passwordFailureTest();
			cusTest.getPortfolioSuccessTest();
			cusTest.getWatchlistSuccessTest();
			cusTest.validateCredentialsSuccessTest();
			cusTest.validateCredentialsFailureTest();

			
			ShareManagementTest shareMgtTest = new ShareManagementTest();
			shareMgtTest.addUpdateAvailableSharesAddSuccessTest();
			shareMgtTest.addUpdateAvailableSharesAddFailureTest();
			shareMgtTest.addUpdateAvailableSharesUpdateSuccessTest();
			shareMgtTest.addUpdateAvailableSharesUpdateFailureTest();
			 
			
			AdminHomePageTest adminHomePageTest = new AdminHomePageTest();
			adminHomePageTest.addToAvailableSharesSuccessTest();
			adminHomePageTest.addToAvailableSharesFailureTest();
			adminHomePageTest.updateAvailableSharePriceSuccessTest();
			adminHomePageTest.updateAvailableSharePriceFailureTest();
			
			AdminUserTest adminTest = new AdminUserTest();
			adminTest.validateCredentialsSuccessTest();
			adminTest.validateCredentialsFailureTest();
			
		}else {
			/* Begin executing the program */
			Scanner sc = new Scanner(System.in);
			int loginType = 0;
			String user_id = "";
			String user_password = "";
			String exit = "";

			IUser cust = new CustomerUserMock();
			/* CustomerDBOps custDB = new CustomerDBOps(); */
			CustomerHomePage custHome = new CustomerHomePage();
			IUser admin = new AdminUser();
			AdminHomePage adminHome = new AdminHomePage();

			do {
				exit = "";
				System.out.println("-------- Select 1 for Customer Login " + "and Select 2 for Admin Login --------");
				loginType = sc.nextInt();
				switch (loginType) {
				case 1:
					System.out.println("Enter customer ID and customer password");
					user_id = sc.next();
					user_password = sc.next();
					if (cust.validateCredentials(user_id,
							user_password) == IUser.AuthenticationResult.LOGIN_SUCCESS) {
						custHome.displayHomePage(cust);
					} else {
						System.out.println("Invalid Credentials");
					}
					break;
				case 2:
					System.out.println("Enter admin ID and admin password");
					user_id = sc.next();
					user_password = sc.next();
					if (admin.validateCredentials(user_id,
							user_password) == IUser.AuthenticationResult.LOGIN_SUCCESS) {
						adminHome.displayHomePage();
					} else {
						System.out.println("Invalid Credentials");
					}
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + loginType);
				}
				System.out.println("Do you wish to exit app? ... Enter 'Yes' or 'No' ");
				exit = sc.next();
			} while ("No".equalsIgnoreCase(exit));
		}
	}
}