class CustomerHomePageTest {

    IUser custTest = new CustomerUserMockTest();
	CustomerDBOperations custDB = new CustomerDBOperations();
	CustomerHomePage custHomeTest = new CustomerHomePage();
	ShareManagement shareMgtTest = new ShareManagement();
	
	/*
	 * Mock data for unit test has been set in class
	 * CustomerUserMockTest. All test cases use stable and consistent
	 * data values in class CustomerUserMockTest 
	 */
	
    public void displayPortfolioSuccessTest() {
		if(custTest.getPortfolio().size() == 5 ) {
			System.out.println("Test displayPortfolioSuccessTest() : PASSED ");
		}else {
			System.out.println("Test displayPortfolioSuccessTest() : FAILED ");
		}
	}
	
	public void displayWatchListSuccessTest() {
		if(custTest.getWatchList().size() == 4 ) {
			System.out.println("Test displayWatchListSuccessTest() : PASSED ");
		}else {
			System.out.println("Test displayWatchListSuccessTest() : FAILED ");
		}
	 }
   
	public void purchaseSharesSuccessTest() {
		String shareName = "ICICI_Bank";
		int qty = 10;
		double maxPrice = 928.00;
		custHomeTest.purchaseShares(custDB, custTest, qty, shareName, maxPrice);
		if (((CustomerUserMockTest) custTest).getPortfolio().get(shareName) == 30) {
			System.out.println("Test purchaseSharesSuccessTest() : PASSED ");
		} else {
			System.out.println("Test purchaseSharesSuccessTest : FAILED ");
		}
	}
    
	public void validatePurchaseRequestSuccessTest() {
		String shareName = "Wipro";
		int qty = 3;
		double maxPrice = 425.00;
		if (custHomeTest.validatePurchaseRequest(qty, shareName, maxPrice)) {
			System.out.println("Test validatePurchaseRequestSuccessTest() : PASSED ");
		} else {
			System.out.println("Test validatePurchaseRequestSuccessTest() : FAILED ");
		}
	}

	public void validatePurchaseRequestNotAvlbFailureTest() {
		String shareName = "Ambuja_Cement";
		int qty = 5;
		double maxPrice = 100;
		if (!custHomeTest.validatePurchaseRequest(qty, shareName, maxPrice)) {
			System.out.println("Test validatePurchaseRequestNotAvlbFailureTest() : PASSED ");
		} else {
			System.out.println("Test validatePurchaseRequestNotAvlbFailureTest() : FAILED ");
		}
	}

	public void validatePurchaseRequestZeroQtyFailureTest() {
		String shareName = "TCS";
		int qty = -1;
		double maxPrice = 4200.15;
		if (!custHomeTest.validatePurchaseRequest(qty, shareName, maxPrice)) {
			System.out.println("Test validatePurchaseRequestZeroQtyFailureTest() : PASSED ");
		} else {
			System.out.println("Test validatePurchaseRequestZeroQtyFailureTest() : FAILED ");
		}
	}

	public void validatePurchaseRequestMaxPriceFailureTest() {
		String shareName = "Olectra";
		int qty = 2;
		double maxPrice = 450;
		if (!custHomeTest.validatePurchaseRequest(qty, shareName, maxPrice)) {
			System.out.println("Test validatePurchaseRequestMaxPriceFailureTest() : PASSED ");
		} else {
			System.out.println("Test validatePurchaseRequestMaxPriceFailureTest() : FAILED ");
		}
	}

	public void sellSharesSuccessTest() {
		String shareName = "ITC";
		int qty = 1;
		double minPrice = 306.78;
		custHomeTest.sellShares(custDB, custTest, qty, shareName, minPrice);
		if (((CustomerUserMockTest) custTest).getPortfolio().get(shareName) == 24) {
			System.out.println("Test sellSharesSuccessTest() : PASSED ");
		} else {
			System.out.println("Test sellSharesSuccessTest() : FAILED ");
		}
	}

	public void validateSellRequestSuccessTest() {
		String shareName = "Chemcon";
		int qty = 10;
		double minPrice = 351.13;
		if (custHomeTest.validateSellRequest(custTest, qty, shareName, minPrice)) {
			System.out.println("Test validateSellRequestSuccessTest() : PASSED ");
		} else {
			System.out.println("Test validateSellRequestSuccessTest(): FAILED ");
		}
	}

	public void validateSellRequestNotAvlbFailureTest() {
		String shareName = "SAIL";
		int qty = 10;
		double minPrice = 70;
		if (!custHomeTest.validateSellRequest(custTest, qty, shareName, minPrice)) {
			System.out.println("Test validateSellRequestNotAvlbFailureTest() : PASSED ");
		} else {
			System.out.println("Test validateSellRequestNotAvlbFailureTest(): FAILED ");
		}
	}

	public void validateSellRequestQtyFailureTest() {
		String shareName = "Federal_Bank";
		int qty = 500;
		double minPrice = 92.014566;
		if (!custHomeTest.validateSellRequest(custTest, qty, shareName, minPrice)) {
			System.out.println("Test validateSellRequestNegativeQtyFailureTest() : PASSED ");
		} else {
			System.out.println("Test validateSellRequestNegativeQtyFailureTest(): FAILED ");
		}
	}

	public void validateSellRequestMinPriceFailureTest() {
		String shareName = "TCS";
		int qty = 4;
		double minPrice = 3400;
		if (!custHomeTest.validateSellRequest(custTest, qty, shareName, minPrice)) {
			System.out.println("Test validateSellRequestNegativeQtyFailureTest() : PASSED ");
		} else {
			System.out.println("Test validateSellRequestNegativeQtyFailureTest(): FAILED ");
		}
	}

	public void addToWatchlistSuccessTest() {
		String shareName = "Adani_Power";
		custHomeTest.addToWatchlist(custDB, custTest, shareName);
		if (((CustomerUserMockTest) custTest).getWatchList().containsKey(shareName)) {
			System.out.println("Test addToWatchlistSuccessTest() : PASSED ");
		} else {
			System.out.println("Test addToWatchlistSuccessTest() : FAILED ");
		}
	}

	public void validateAddToWatchListSuccessTest() {
		String shareName = "SAIL";
		if (custHomeTest.validateAddToWatchList(custTest, shareName)) {
			System.out.println("Test validateAddToWatchListSuccessTest() : PASSED ");
		} else {
			System.out.println("Test validateAddToWatchListSuccessTest() : FAILED ");
		}
	}

	public void validateAddToWatchListAlreadyExistFailureTest() {
		String shareName = "TTML";
		if (!custHomeTest.validateAddToWatchList(custTest, shareName)) {
			System.out.println("Test validateAddToWatchListAlreadyExistFailureTest() : PASSED ");
		} else {
			System.out.println("Test validateAddToWatchListAlreadyExistFailureTest() : FAILED ");
		}
	}

	public void validateAddToWatchListNotAvlbFailureTest() {
		String shareName = "ABFRL";
		if (!custHomeTest.validateAddToWatchList(custTest, shareName)) {
			System.out.println("Test validateAddToWatchListNotAvlbFailureTest() : PASSED ");
		} else {
			System.out.println("Test validateAddToWatchListNotAvlbFailureTest() : FAILED ");
		}
	}

	public void removeFromWatchListSuccessTest() {
		String shareName = "Hudco";
		if (custHomeTest.removeFromWatchList(custDB, custTest, shareName)) {
			System.out.println("Test removeFromWatchListSuccessTest() : PASSED ");
		} else {
			System.out.println("Test removeFromWatchListSuccessTest() : FAILED ");
		}
	}
   
	public void validateRemoveFromWatchlistNotExistFailureTest() {
		String shareName = "Reddys";
		if(!custHomeTest.validateRemoveFromWatchlist(custTest, shareName)) {
			System.out.println("Test validateRemoveFromWatchlistNotExistFailureTest() : PASSED ");
		}else {
			System.out.println("Test validateRemoveFromWatchlistNotExistFailureTest() : FAILED ");
		}
	}	
}