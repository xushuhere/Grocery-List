To realize all the requirements for this assignment I created the GroceryListManager class. 

This class acts like a connecting point between the Grocery Lists and the Users.

This class has methods that would allow the user to interact with multiple lists and manage how he/she finds and interacts with the D2.


Basic design consists of a database, GroceryLists that belongs to a user, ListItems that belongs to a GroceryList. 

The GroceryListManager handles all interaction with the database and provides provision to allow a single user to have multiple lists.

A.	A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples). 


1.	GroceryListManager class method getAllLists(User) allows all the lists associated to the user to be  displayed on screen 1

2.	Clicking on an Item will open dialog-1

3.	Clicking on “Details” will call selectAList(Listname){This will just mark the one list as selected and deselect every other list the user owns} , after this the  getSelectedList(User) method is called in order to navigate to screen two

4.	User can click on any item to navigate to dialog 2 that has various action buttons.

5.	User can add ListItem to Grocery List using method addItem(ListItem)

6.	User can remove ListItem from Grocery List using method removeItem(ListItem)

7.	User can change quantity by clicking editQuantity and calling editQuantity(newQuantity) method for the ListItem object


B.	The application must contain a database (DB) of items and corresponding item types. 


1.	There is a DB that the GroceryListManager uses in order to help manage the functionality for the user.

2.	This DB stores various items and item type combinations


C.	Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.


1.	User clicks add button on dialog-1 to add to a particular list

2.	Dialog 3 opens where the getAllItemTypes() in from GroceryListManager gets all distinct item types from the DB

3.	Clicking on a type expands the type and displays all items under that type using getItemsForType(string type) method from GroceryListManager that gets all items of that list type from the database.

4.	User selects an Item and the enter quantity dialog opens

5.	User enters a quantity and sets it using the editQuantity() methods  and the item gets added to the list



D.	Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to ad4. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its D2. 


1.	User wants to add item so navigates to dialog 3

2.	User types search string in search bar (white) and the GroceryListManager findSimilarItems(string searchterm) searches for string for possible suggestions.

3.	If user not satisfied with any of the suggestions the user clicks on the add button and addItemToDB(String name, String type) 
is called which adds the new combination to the database


E.	Lists must be saved automatically and immediately after they are modifie4. 


1.	GroceryListManager saveListToDb(GroceryList) is called anytime a GroceryList modification is done



F.	Users must be able to check off items in a list (without deleting them). 


1.	User can navigate to dialog 1 

2.	Click on checkAll which will trigger checkAll() method in GroceryList accomplishing the task


G.	Users must also be able to clear all the check-off marks in a list at once. 


1.	User can navigate to dialog 1

2.	Click on unCheckAll which will trigger unCheckAll() method in GroceryList accomplishing the task.


H.	Check-off marks for a list are persistent and must also be saved immediately. 


1.	GroceryListManager saveListToDb(GroceryList) is performed anytime a list modification is done even after check/uncheck that are performed on any list item


I.	The application must present the items in a list grouped by type, so as to allow 
users to shop for a specific type of products at once (i.e., without having to go 
back and forth between aisles). 


1.	Items in the list can be displayed the way they are in dialog 3 by using method getAllDistinctType() from GroceryList

2.	First we user getAllDistinctType() to get a list of strings of all the distinct type elements in the list.

3.	The user can click on a type and then see all items of that type in expanded view using getAllItemsByType() method from GroceryList


J.	The application must support multiple lists at a time (e.g., “weekly grocery list”, 
“monthly farmer’s market list”). Therefore, the application must provide the users 
with the ability to create, (re)name, select, and delete lists. 

1.	The GroceryListManager methods can help maintain multiple lists by adding methods like addList(), removeList() and renameList().


K.	The User Interface (UI) must be intuitive and responsive. 

1.	Basic UI is displayed above and can be improved in a few iterations. Not a whole lot of focus was done on the UI part since that was outside the scope of the assignment.
