import java.util.*;

public class CustomerHomePage {

	Scanner sc = new Scanner(System.in);
	int cust_operation = 0;
	String returnToMainMenu;
	CustomerDBOperations custDB = new CustomerDBOperations();

	public void displayHomePage(IUser cust) {
		System.out.println(
				" ---- Welcome, " + ((CustomerUserMock) cust).getCustomer_name() + ". Its good to see you ---- ");
		System.out.println(" --------- Welcome to AngelBroking Customer Page --------- ");

		do {
			String shareName = "";
			int qty = 0;
			double price = 0.0;
			returnToMainMenu = "";

			System.out.println("Enter 1. View Portfolio \n" + "2. View Watchlist \n" + "3. Buy Shares \n"
					+ "4. Sell Shares \n" + "5. View available shares in market \n" + "6. Add to Watchlist \n"
					+ "7. Remove from Watchlist");
			cust_operation = sc.nextInt();

			switch (cust_operation) {
			case 1:
				displayPortfolio(cust);
				break;
			case 2:
				displayWatchList(cust);
				break;
			case 3:
				System.out.println(" List of available shares is displayed as (Share Name = Current Share Price) ");
				System.out.println(ShareManagement.getAvailableShares());
				System.out.println(
						" Enter the share name (exact name), quantity and maximum offered price for purchase ");
				shareName = sc.next();
				sc.nextLine();
				qty = sc.nextInt();
				price = sc.nextDouble();
				if (purchaseShares(custDB, cust, qty, shareName, price)) {
					System.out.println("Successfully added to Portfolio");
				} else {
					System.out.println("Could not make a purchase");
				}
				break;
			case 4:
				System.out.println(" Your current portfolio is displayed as (Share Name = Quantity Held) below ");
				System.out.println(((CustomerUserMock) cust).getPortfolio());
				System.out.println(" Enter the share name (exact name), quantity and minimum expected price to sell");
				shareName = sc.next();
				sc.nextLine();
				qty = sc.nextInt();
				price = sc.nextDouble();
				if (sellShares(custDB, cust, qty, shareName, price)) {
					System.out.println("Successfully sold shares");
				} else {
					System.out.println("Could not sell");
				}
				break;
			case 5:
				System.out.println(" List of shares in market displayed as (Share Name = Current Share Price)");
				System.out.println(ShareManagement.getAvailableShares());
				break;
			case 6:
				System.out.println(" List of shares in market displayed as (Share Name = Current Share Price)");
				System.out.println(ShareManagement.getAvailableShares());
				System.out.println(" Enter the share name (exact name) you want to add to watchlist ");
				shareName = sc.next();
				if (addToWatchlist(custDB, cust, shareName)) {
					System.out.println("Successfully added to watchlist");
				} else {
					System.out.println("Failed to add to watchlist");
				}
				break;
			case 7:
				System.out.println(" Enter the share name (exact name) you want to remove from watchlist ");
				shareName = sc.next();
				if (removeFromWatchList(custDB, cust, shareName)) {
					System.out.println("Removed from watchlist");
				} else {
					System.out.println("Could not remove from watchlist");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + cust_operation);
			}
			System.out.println("Do you wish to retun to main menu? ... Enter 'Yes' or 'No' ");
			returnToMainMenu = sc.next();
		} while ("No".equalsIgnoreCase(returnToMainMenu));
	}

	public void displayPortfolio(IUser cust) {
		System.out.println("--> Your current portfolio is displayed as (Share Name = Quantity Held) below ");
		System.out.println(cust.getPortfolio());
	}

	public void displayWatchList(IUser cust) {
		System.out.println("--> Your current watchList is disalyed as (Share Name = Current Share Price) below ");
		System.out.println(cust.getWatchList());
	}

	public boolean purchaseShares(CustomerDBOperations custDB, IUser cust, int qty, String shareName, double maxPrice) {
		if (validatePurchaseRequest(qty, shareName, maxPrice)) {
			if (custDB.persistAddToPortfolio(cust, shareName, qty)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/* validatePurchaseRequest() returns true or false
	 * Shares can only be purchased if they are available with the company, their
	 * quantity is more than 0 and the maximum offered price is greater than or
	 * equal to the current share price. Method returns true if all 
	 * conditions are met; false otherwise.
	 */
	public boolean validatePurchaseRequest(int qty, String shareName, double maxPrice) {
		if (ShareManagement.getAvailableShares().containsKey(shareName)
				&& ShareManagement.getAvailableShares().get(shareName) <= maxPrice && qty > 0) {
			return true;
		} else {
			if (!ShareManagement.getAvailableShares().containsKey(shareName)) {
				System.out.println("Requested share " + shareName + " is not available");
			} else if (!(qty > 0)) {
				System.out.println("Quantity can't be zero or negative");
			} else if (!(ShareManagement.getAvailableShares().get(shareName) <= maxPrice)) {
				System.out.println(
						"Share price for " + shareName + " is current higher than the maximum offered " + "price");
			}
			return false;
		}
	}

	public boolean sellShares(CustomerDBOperations custDB, IUser cust, int qty, String shareName, double minPrice) {
		if (validateSellRequest(cust, qty, shareName, minPrice)) {
			if (custDB.persistRemoveFromPortfolio(cust, shareName, qty)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
    
	/*
	 * validateSellRequest() returns true or false
	 * Shares can only be sold if they are present with the
	 * user the quantity is greater than 0 and the minimum expected price is less
	 * than or equal to the current share price. Method returns true if all
	 * conditions are met; false otherwise
	 */
	public boolean validateSellRequest(IUser cust, int qty, String shareName, double minPrice) {
		if (cust.getPortfolio().containsKey(shareName) && cust.getPortfolio().get(shareName) >= qty
				&& ShareManagement.getAvailableShares().get(shareName) >= minPrice) {
			return true;
		} else {
			if (!(cust.getPortfolio().containsKey(shareName))) {
				System.out.println("Share " + shareName + " does not exist in your portfolio ");
			} else if (!(cust.getPortfolio().get(shareName) >= qty)) {
				System.out.println("There aren't enough shares of " + shareName + " in your portfolio to sell");
			} else if (!(ShareManagement.getAvailableShares().get(shareName) >= minPrice)) {
				System.out.println("Current price of share " + shareName + " is lower than minnimum expected price");
			}
			return false;
		}
	}

	public boolean addToWatchlist(CustomerDBOperations custDB, IUser cust, String shareName) {
		if (validateAddToWatchList(cust, shareName)) {
			custDB.persistAddToWatchlist(cust, shareName, ShareManagement.getAvailableShares().get(shareName));
			return true;
		} else {
			return false;
		}
	}
    
	/*
	 * validateAddToWatchList() returns true or false
	 * Shares can only be added to watchlist if they are
	 * available and they are not already present in the watchlist. Method returns true if all
	 * conditions are met; false otherwise
	 */
	public boolean validateAddToWatchList(IUser cust, String shareName) {
		if (!cust.getWatchList().containsKey(shareName)
				&& ShareManagement.getAvailableShares().containsKey(shareName)) {
			return true;
		} else {
			if (cust.getWatchList().containsKey(shareName)) {
				System.out.println("Share already exists in watchlist");
				return false;
			} else if (!ShareManagement.getAvailableShares().containsKey(shareName)) {
				System.out.println("Share is not available to add in watchlist");
				return false;
			}
		}
		return false;
	}

	public boolean removeFromWatchList(CustomerDBOperations custDB, IUser cust, String shareName) {
		if (validateRemoveFromWatchlist(cust, shareName)) {
			custDB.persistRemoveFromWatchlist(cust, shareName);
			return true;
		} else {
			return false;
		}
	}

	/*
	 * validateRemoveFromWatchlist() returns true or false Shares can only be
	 * removed from the watchlist if they already exist in the user watchlist.
	 * Method returns true if all conditions are met; false otherwise
	 */
	public boolean validateRemoveFromWatchlist(IUser cust, String shareName) {
		if (cust.getWatchList().containsKey(shareName)) {
			return true;
		} else if (!cust.getWatchList().containsKey(shareName)) {
			System.out.println("Share does not exist in current watchlist");
			return false;
		}
		return false;
	}
}