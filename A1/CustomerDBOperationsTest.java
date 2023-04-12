class CustomerDBOperationsTest {

	CustomerDBOperations custDB = new CustomerDBOperations();
	IUser custTest = new CustomerUserMockTest();

	/*
	 * Mock data for unit test has been set in class CustomerUserMockTest. All test
	 * cases use stable data values in class CustomerUserMockTest
	 */

	public void persistAddToPortfolioSuccessTest() {
		String shareName = "TTML";
		int qty = 4;
		custDB.persistAddToPortfolio(custTest, shareName, qty);
		if (custTest.getPortfolio().get(shareName) == 4) {
			System.out.println("Test persistAddToPortfolioSuccessTest() : PASSED ");
		} else {
			System.out.println("Test persistAddToPortfolioSuccessTest() : FAILED ");
		}
	}

	public void persistAddToPortfolioFailureTest() {
		String shareName = "Adani_Power";
		int qty = 4;
		custDB.persistAddToPortfolio(custTest, shareName, qty);
		if (!(custTest.getPortfolio().get(shareName) == 0)) {
			System.out.println("Test persistAddToPortfolioFailureTest() : PASSED ");
		} else {
			System.out.println("Test persistAddToPortfolioFailureTest() : FAILED ");
		}
	}

	public void persistRemoveFromPortfolioSuccessTest() {
		String shareName = "Federal_Bank";
		int qty = 2;
		custDB.persistRemoveFromPortfolio(custTest, shareName, qty);
		if (custTest.getPortfolio().get(shareName) == 98) {
			System.out.println("Test persistRemoveFromPortfolioSuccessTest() : PASSED ");
		} else {
			System.out.println("Test persistRemoveFromPortfolioSuccessTest() : PASSED ");
		}
	}

	public void persistRemoveFromPortfolioFailureTest() {
		String shareName = "ICICI_Bank";
		int qty = 1;
		custDB.persistRemoveFromPortfolio(custTest, shareName, qty);
		if (custTest.getPortfolio().get(shareName) == 19) {
			System.out.println("Test persistRemoveFromPortfolioSuccessTest() : PASSED ");
		} else {
			System.out.println("Test persistRemoveFromPortfolioSuccessTest() : PASSED ");
		}
	}

	public void persistAddToWatchlistSuccessTest() {
		String shareName = "Cholafin";
		double price = 786.50;
		custDB.persistAddToWatchlist(custTest, shareName, price);
		if (custTest.getWatchList().containsKey(shareName) && custTest.getWatchList().get(shareName) == 786.50) {
			System.out.println("Test persistAddToWatchlistSuccessTest() : PASSED ");
		} else {
			System.out.println("Test persistAddToWatchlistSuccessTest() : FAILED ");
		}
	}

	public void persistRemoveFromWatchlistSuccessTest() {
		String shareName = "Hudco";
		custDB.persistRemoveFromWatchlist(custTest, shareName);
		if (!custTest.getWatchList().containsKey(shareName)) {
			System.out.println("Test persistRemoveFromWatchlistSuccessTest() : PASSED ");
		} else {
			System.out.println("Test persistRemoveFromWatchlistSuccessTest() : FAILED ");
		}
	}

	public void commitSuccesstest() {
		if (custDB.commit(custDB)) {
			System.out.println("Test commitSuccesstest() : PASSED ");
		}

	}

	public void rollbackSuccesstest() {
		if (!custDB.rollback(custDB)) {
			System.out.println("Test rollbackSuccesstest() : PASSED ");
		}

	}
}