**1.	A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).**
	To realize this requirement, I added to the design a class *GroceryList* with attribute listItems, and operations addItem and deleteItem. I also added an *Item* class with attribute quantity.
    
**2.	The application must contain a database (DB) of items and corresponding item types.**
	To realize this requirement, I added to the design a class *Database*, added attribute itemType to the class Item, and added attribute database to class Application.
	
**3.	Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the actual item (e.g., shredded wheat). After adding an item, users must be able to specify a quantity for that item.**
	To realize this requirement, I added operations findTypes and findItemsOfType to class Database. I also added class HierarchicalList with operations showTypes, showItemsOfType, and selectItemToAdd.
	
**4.	Users must also be able to specify an item by typing its name. In this case, the application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type.**
	To realize this requirement, I added operations findSimilarNames, findItem and insertNewItem to class Database. I also added getItemNamefromUser to class Application

**5.	Lists must be saved automatically and immediately after they are modified.**
	Not considered because it does not affect the design directly.

**6.	Users must be able to check off items in a list (without deleting them).**
	To realize this requirement, I added the operation checkOffItem to class GroceryList and attribute isCheckedOff to class Item

**7.	Users must also be able to clear all the check-off marks in a list at once.**
	To realize this requirement, I added the operation checkOffAllItems to class GroceryList

**8.	Check-off marks for a list are persistent and must also be saved immediately.**
	Not considered because it does not affect the design directly.

**9.	The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth between aisles).**
	To realize this requirement, I added the operation groupItemsByType to class GroceryList

**10.	The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.**
	To realize this requirement, I added to the design a class *Application* with attributes groceryLists and selectedList, and operations createList, renameList, selectList, and deleteList.

**11.	The User Interface (UI) must be intuitive and responsive.**
	Not considered because it does not affect the design directly.
