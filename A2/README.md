# **Assignment** **2**
Name – Viraj Joshi

# **Interface** **Segregation** **Principle**
Bad Package

1. IBadSuperStore – This interface is built so that it can be used by stores to perform tasks such as scanning items and fetching the product UPC (Universal Product Code), fetching product price using the UPC and calculating produce price according to the weight.

2. class BadWalmart – It implements the BadSuperStoreInterface. All interface methods are implemented in the class as Walmart sells items as well as produce.

3. class BadCanadianTire – It implements the BadSuperStoreInterface. Since Canadian Tire store does not sell produce items, it does not need method ‘getPriceByProduceWeight’. Thus, the class makes this method a ‘do-nothing’ method to bypass compiler errors.

This violates the Interface Segregation Principle which says "**No** **client** **should** **be** **forced** **to** **depend** **on** **methods** **it** **does** **not** **use.** **Many** **client-specific** **interfaces** **are** **better** **than** **one** **general-purpose** **interface."**

The Interface Segregation principle violation can be fixed by breaking the interface into smaller interfaces. Resolved the bad code by creating two interfaces – ISuperStoreItems and ISuperStoreProduce

Good Package
1. ISuperStoreItems – This interface contains methods that deal with scanning and pricing items.

2. ISuperStoreProduce – This interface contains methods that deal with pricing produce items.

3. class GoodWalmart – Since Walmart sells both produce and non-produce items, this class implements ISuperStoreItems as well as ISuperStoreProduce.

4. class GoodCanadianTire – Since CanadianTire does not sell produce goods, this class implements just the ISuperStoreItems.


# **Dependency** **Inversion** **Principle**
Bad Package

1. class BadCharReader – This class contains method read() to read a file character by character.

2. class BadReader – This class creates an object of BadCharReader class and uses it to call method read() to read a particular file one character at a time.

This violates the Dependency Inversion Principle which says **"high level modules should not depend upon low level modules, instead both must depend on abstractions"** . Suppose it is decided that instead of reading the file one character at a time, it must be read one line at a time. Implementing this change will require making changes to the BadCharReader and BadReader class. It will be difficult to swap the modules to implement such changes in the above code.


This violation can be resolved by making the high level and low level modules depend on an interface rather than a concrete class implantation. To achieve this, we create and Interface – IFileReader with method read(String filepath). This interface is implemented by class GoodCharReader and GoodLineReader. Thus, both classes will have their own implementation of the read method.

Class GoodReader will have a dependency on IFileReader. Depending upon which class object is passed, it will either call read() method in GoodCharReader or GoodLineReader. Swapping of modules to implement changes (to read one line instead of one character) will be easier by following Dependency Inversion Principle.

Good Package 

1. IFileReader – Interface that contains read(String filePath) method.

2. class GoodCharReader – This class implements the IFileReader interface and implements the read() method to read a file character by character.

3. class GoodLineReader – This class implements the IFileReader interface and implements the read() method to read a file line by line.

4. class GoodReader – This class contains method readFile(IFileInterface iFileReader, String filePath). This represents dependency injection. Now depending upon whether we want to read the file per character or line, we pass the object of either the GoodLineReader or GoodCharReader class. This also makes swapping of modules easier.


# **Liskov** **Substitution** **Principle**
Bad Package

1. abstarct class BadVehicle – This is an abstract class that contains abstract methods to start, accelerate, brake and check drunk driver.
1. class BadSmartCar – This class extends BadVehicle and implements all abstract methods.
1. class BadCar – This class extends BadVehicle. But this is a non-smart car which does not have a ‘alcohol detection sensor’. So this class throws a “No sensor” exception in the drunkDriveCheck() method implementation.


This design is a violation of the Liskov Substitution Principle which states that “**Objects** **in** **a** **program** **should** **be** **replaceable** **with** **instances** **of** **their** **subtypes** **without** **altering** **the** **correctness of that program”.** In this code, the super class method drunkDriveCheck() which was functioning previously ,would throw an unexpected exception if the superclass object is replaced with the subtype object. The exception would be a violation of the spirit of the method described in the abstract class. Its ‘refusing the bequest’.


This violation can be resolved by creating the following hierarchical pattern.

Good Package

1. abstract class GoodVehicle - This is an abstract class that contains abstract methods to start, accelerate and apply brake.

2. abstract class GoodSmartVehicle – This is an abstract class that extends the GoodVehicle class. Additionally it adds an abstract method drunkDriveCheck() to detect if the driver is drunk while driving.

3. class GoodSmartCar – This class extends the GoodSmartVehicle class.


4. class GoodCar – This class extends the GoodVehicle class as it does not have sensors to check drunk driving.

This ensures that cars with no sensors do not have to implement the drunkDriveCheck() method, alter its behavior , throw an exception and eventually preventing violation of Liskov Substitution Principle.
