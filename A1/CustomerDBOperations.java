public class CustomerDBOperations implements IDatabasePersistance {

	/*
	 * persistAddToPortfolio() returns true or false. Adds purchased share and
	 * quantity to portfolio. If share does not already exist in portfolio, sets the
	 * count to 0 so as to add integer value 'qty'. If no errors, values are
	 * commited to database
	 */
	public boolean persistAddToPortfolio(IUser cust, String shareName, int qty) {
		try {
			cust.getPortfolio().put(shareName,
					(cust.getPortfolio().get(shareName) != null ? cust.getPortfolio().get(shareName) : 0)
							+ (Integer) qty);
			return commit(this);
		} catch (Exception e) {
			return rollback(this);
		}
	}

	/*
	 * persistRemoveFromPortfolio() returns true or false. Removes sold shares and
	 * quantity from portfolio. If share does not already exist in portfolio, sets
	 * the count to 0 so as to subtract integer value 'qty'. If no errors, values
	 * are commited to database
	 */
	public boolean persistRemoveFromPortfolio(IUser cust, String shareName, int qty) {
		try {
			cust.getPortfolio().put(shareName,
					(cust.getPortfolio().get(shareName) != null ? cust.getPortfolio().get(shareName) : 0)
							- (Integer) qty);
			return commit(this);
		} catch (Exception e) {
			return rollback(this);
		}
	}

	/*
	 * persistAddToWatchlist() returns true or false. Adds validated share and
	 * current price to watchlist. If no errors, values are commited to database
	 */
	public boolean persistAddToWatchlist(IUser cust, String shareName, Double price) {
		try {
			cust.getWatchList().put(shareName, price);
			return commit(this);
		} catch (Exception e) {
			return rollback(this);
		}
	}

	/*
	 * persistRemoveFromWatchlist() returns true or false. Removes validated share
	 * and current price from watchlist. If no errors, values are commited to
	 * database
	 */
	public boolean persistRemoveFromWatchlist(IUser cust, String shareName) {
		try {
			cust.getWatchList().remove(shareName);
			return commit(this);
		} catch (Exception e) {
			return rollback(this);
		}
	}
    
	/* Mocks the database commit operation */
	public boolean commit(IDatabasePersistance db) {
		return PERSIST_SUCCESS;
	}
    
	/* Mocks the database rollback operation */
	public boolean rollback(IDatabasePersistance db) {
		return PERSIST_FAILURE;
	}
}