### Assignment 1 
##### Test Driven Development #####

The project is a console based Stock Management Application named "e-broking" 
It mimics the operations of a customer and admin with the application.

There are 2 entities in this application
1. Customer  -  Customer is a user of the application. 
2. Admin -  Admin is a user of the application with special authority.


### Project Structure
Classes - 

1. Main.java - 
Main class starts the program execution. It prompts user to login as 'customer' or 'admin'. 
Based on this, it calls method to display customer or admin home page.

2. CustomerHomePage.java - 
Presentation layer for customer. Has methods for all functionalities available to the customer
and validation logic.


-  2A. CustomerHomePageTest.java - 
Contains corresponding test cases for CustomerHomePage.java methods. 

3. CustomerDBOperations.java - 
Implements interface 'IDataPersistance'. Contains methods to manipulate customer data like customer portfolio, customer watchlist etc.
Has database commit and rollback  methods.

- 3A. CustomerDBOperationsTest.java - 
Contains corresponding test cases for CustomerDBOperations.java methods.

4. CustomerMock.java -
It implements interface 'IUser' . This class represents the customer database.
Contains fields for customer user_name, password, portfolio and watchlist. All operations performed during code execution
are made on this database.

- 4A. CustomerMockTest.java - 
It implements interface 'IUser'. This class represents the mock customer database.
It has 'stable' and 'known' mock data values which is used by test cases. 

5. AdminHomePage.java - 
Presentation layer for admin. Has methods for all functionalities available to the admin.

- 5A. AdminHomePageTest.java - 
Contains corresponding test methods for AdminHomePage.java methods.


6. AdminUser.java - 
It implements interface 'IUser'. 

- 6A. AdminUserTest.java - 
Contains corresponding test methods for AdminUser.java method.

7. ShareManagement.java - 
Has a static list of available stocks and method to add/update the static list.

- 7A. ShareManagementTest.java - 
Contains a list of available stocks which is used by test classes and corresponding test cases for class ShareManagement.

8. IUser - 
Its an interface. CustomerMock and CustomerMockTest implement this interface.
We use this interface for depedency injection.

9. IDataPersistance -
Its and interface that mimicks database commit and rollback functionalities. 
CustomerDBOperations implements this interface.


### Functionalities 

>> Customer has the following functionalities -
A. View portfolio - Portfolio is a list of stocks purchased by the customer.
B. View watchlist - Watchlist is a list of stocks being tracked by the customer.
C. Purchase stocks - Customer can purchase stocks from a list of available stocks by entering the stock-name, required quantity and maximum offered price. Entered stock must be present in the available stocks list, quantity be greater than zero and the current stock price should be less than or equal to the maximum offered price failing which system will fail the purchase request.
D. Sell stocks - Customer can sell stocks from the portfolio by specifying the stock-name, quantity to be sold and minimum expected price. Entered stock must be present in the customer's portfolio, quantity be less than or equal to what the customer owns and the current stock price should be more than  or equal to the minimum expected price failing which system will fail the sell request.
E. Add stocks to watchlist - Customer can add from the list of available stock to personal watchlist. Only available stocks can be added to watchlist failing which system will fail the request.
F. Remove from watchlist - Customer can remove from personal watchlist any stock. Only stocks present in personal watchlist can be removed failing which system will fail the request.
G. Watch available shares - Display a list of shares available in the market.


--- 
>> Admin has the following functionalities - 
A. Update stock price - Admin can update/modify price of any stock to reflect current market price by entering the stock name and updated price. Only stocks available in the available list can be modified. Price can never be zero. On adding 0 pice, system will fail the request.
B. Add new stocks - Admin can add stocks to the list by entering the stock name and corresponding price. Price can never be zero. On adding 0 pice, system will fail the request.


### Program execution
1 Select customer login or admin login.

2 Enter login credentials when prompted.
- For customer - Enter user_name as 'vjoshi' and password as 'viraj123' for log-in.
- For admin - Enter user_name as 'admin' and password as 'admin123' for log-in

3.If chosen customer -> system will display customer home page.
Enter the option code for performing an operation. 
Note - Initially portfolio and watchlist are empty. Buy shares to add to portfolio and add to watchlist.

4.If customer no longer wants to perform operations, enter 'Yes' to exit customer home page.

5.Once back on the main page. Enter 'Yes' to exit the system or 'No' to continue. 

6.Select customer or admin login .

7.If chosen admin -> system will display admin home page.
Enter the optoin code for performing an operation.

8.If admin no longer wants to perform operation, enter 'Yes' to exit admin home page.

9.Once back on the main page. Enter 'Yes' to exit the system or 'No' to continue. 

10.Select customer or admin login.

Note - One can add a stock as customer and change price as an agent and then again log-in as customer to check if the price change is reflected in available shares.