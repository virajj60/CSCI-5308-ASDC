import java.util.Scanner;

public class AdminHomePage {

	ShareManagement shareMgt = new ShareManagement();

	public void displayHomePage() {
		System.out.println(" --------- Welcome to AngelBroking Admin Console --------- ");

		Scanner sc = new Scanner(System.in);
		int admin_operation = 0;
		String returnToMainMenu = "";

		do {
			String shareName = "";
			double updatedPrice = 0.0;
			System.out.println(" --------- Welcome to AngelBroking Admin Page --------- ");
			System.out.println("Enter 1. Update share prices \n" + "2. Add to available shares \n");
			admin_operation = sc.nextInt();
			switch (admin_operation) {
			case 1: {
				System.out.println(" List of shares in market displayed as (Share Name = Current Share Price)");
				System.out.println(ShareManagement.getAvailableShares());
				System.out.println(" Enter the shareName (exact Name) and updated price ");
				shareName = sc.next();
				updatedPrice = sc.nextDouble();
				if (updateAvailableSharePrice(shareMgt, shareName, updatedPrice)) {
					System.out.println(" Share price updated successfully ");
				} else {
					System.out.println(" Could not update price ");
				}
				break;
			}
			case 2: {
				System.out.println(" List of shares in market displayed as (Share Name = Current Share Price)");
				System.out.println(ShareManagement.getAvailableShares());
				System.out.println(" Enter the share Name (exact Name) and price to add available shares ");
				shareName = sc.nextLine();
				updatedPrice = sc.nextDouble();
				if(addToAvailableShares(shareMgt, shareName, updatedPrice)) {
					System.out.println(" Share added successfully ");
				}else{
					System.out.println(" Share could not be added ");
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + admin_operation);
			}
			System.out.println("Do you wish to retun to main menu? ... Enter 'Yes' or 'No' ");
			returnToMainMenu = sc.next();
		} while ("No".equalsIgnoreCase(returnToMainMenu));
	}

	public boolean updateAvailableSharePrice(ShareManagement shareMgt, String shareName, double updatedPrice) {
		if (shareMgt.addUpdateAvailableShares(shareMgt, shareName, updatedPrice)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean addToAvailableShares(ShareManagement shareMgt, String shareName, double updatedPrice) {
		if (shareMgt.addUpdateAvailableShares(shareMgt, shareName, updatedPrice)) {
			return true;
		} else {
			return false;
		}
	}
}