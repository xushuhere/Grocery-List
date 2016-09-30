#**Design 1**

#![alt tag](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team16/blob/master/GroupProject/Design-Team/design-agoel63.png)

**Pros:** 

 - Separate Id attribute to handle duplicate names
 - Showed the UI design as well

**Cons:**

 - Database interaction class can be created which will be different from GroceryListManager class and handle all the different operations related to the database.
 - Make GroceryList communicate directly with the database or a utility class and reduce some dependence on the GroceryListManager class.

#**Design 2**

#![alt tag](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team16/blob/master/GroupProject/Design-Team/design-dnelson42.png)

**Pros:** 

 - Database as a class eases the user’s operation
 - Designed based on 3 Tier software architecture

**Cons:**

 - HierachicalList class and addItemFromHeirarchy are redundant

#**Design 3**

#![alt tag](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team16/blob/master/GroupProject/Design-Team/design-sxu332.png)

**Pros:** 

 - Specify Search as a class allows a single point to add new items to database based on user input. 

**Cons:**

 - HierachicalList need to communicate with the database (missing)
 - Integer quantity without quantity type makes it difficult to handle units.

#**Design 4**

#![alt tag](https://github.gatech.edu/gt-omscs-se-2016fall/6300Fall16Team16/blob/master/GroupProject/Design-Team/design-zahmad8.png)

**Pros:** 

 - quantityType attribute in itemType allows specification of what kind of quantity is being used. E.g. bunches of cilantro or cans/bottles of coke etc. Different item types will likely use different quantity types. 

**Cons:**

 - clearAllChecks should be a method for the List instead of stand alone function
 - enterItem class should be a method for the List instead of a stand alone association class

#**Team Design**


#**Summary**

For the team design we kept the database class as a separate utility class that would handle all database interactions. We decided to accommodate pros of all individual designs in order to create an improved team design.

User uses the application class in order to manage their lists
