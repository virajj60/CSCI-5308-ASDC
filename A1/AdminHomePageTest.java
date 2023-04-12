class AdminHomePageTest {

	AdminHomePage adminHomeTest = new AdminHomePage();

	public void updateAvailableSharePriceSuccessTest() {
		ShareManagement shareMgtTest = new ShareManagement();
		String shareName = "Nirlon";
		double price = 362.55;
		adminHomeTest.updateAvailableSharePrice(shareMgtTest, shareName, price);
		if (shareMgtTest.getAvailableShares().get(shareName) == 362.55) {
			System.out.println("Test updateAvailableSharePriceSuccessTest() : PASSED");
		} else {
			System.out.println("Test updateAvailableSharePriceSuccessTest() : FAILED");
		}
	}

	public void updateAvailableSharePriceFailureTest() {
		ShareManagement shareMgtTest = new ShareManagement();
		String shareName = "Nirlon";
		double price = 0.00;
		adminHomeTest.updateAvailableSharePrice(shareMgtTest, shareName, price);
		if (!(shareMgtTest.getAvailableShares().get(shareName) == 362.55)) {
			System.out.println("Test updateAvailableSharePriceFailureTest() : PASSED");
		} else {
			System.out.println("Test updateAvailableSharePriceFailureTest() : FAILED");
		}
	}

	public void addToAvailableSharesSuccessTest() {
		ShareManagement shareMgtTest = new ShareManagement();
		String shareName = "FSL";
		double price = 106.95;
		adminHomeTest.addToAvailableShares(shareMgtTest, shareName, price);
		if (shareMgtTest.getAvailableShares().containsKey(shareName)
				&& shareMgtTest.getAvailableShares().get(shareName) == 106.95) {
			System.out.println("Test addToAvailableSharesSuccessTest(): PASSED");
		} else {
			System.out.println("Test addToAvailableSharesSuccessTest(): PASSED");
		}
	}

	public void addToAvailableSharesFailureTest() {
		ShareManagement shareMgtTest = new ShareManagement();
		String shareName = "FSL";
		double price = -100;
		adminHomeTest.addToAvailableShares(shareMgtTest, shareName, price);
		if (!(shareMgtTest.getAvailableShares().containsKey(shareName)
				&& shareMgtTest.getAvailableShares().get(shareName) == -100)) {
			System.out.println("Test addToAvailableSharesSuccessTest(): PASSED");
		} else {
			System.out.println("Test addToAvailableSharesSuccessTest(): PASSED");

		}
	}
}