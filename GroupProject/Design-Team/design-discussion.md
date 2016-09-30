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

We discussed about individual’s designs and adapted some concepts. The diagram is presented above.


The grocery list manager app is a single user application to buy items in the list from a grocery store. 

1. The Application class is the application layer of the design. This class interacts with UI and drives into next layers. The GroceryListManager class has attributes of groceryLists, database, hierachicalList, sepcifySearch, etc. The GroceryListManager class method createList() allows to generate a new shopping list, and rename the grocery list, selectList() to drive into GroceryList class, deleteList() to remove selected list, and all other get methods.

2. From the application, we can drive into GroceryList class by selectList() method. The groceryList class has name and listItems attributes, and several methods of addItem(),addItemFromHierarchy(), addItembySpeficy(),deleteItem(),selectItem(),clearAllChekced(), and groupItemsByType().  To add an item, the user can select the addItem() method, the app will get the choice between addItemFromHierarchy() and addItembySpeficy() methods. In addition, the user can use addItemFromHierarchy() and addItembySpeficy() methods from the UI. The two methods - addItemFromHierarchy() and addItembySpeficy()  methods are associated with HierachicalList and SpecifySearchList classes respectively. For the uses of those two classes, please refer to point 4 and 5. The deleteItem() method is called for deleting an item from the list. The clearAllCheckedOffItems() method will reset the checkedOff attribute from all the items in the list. When a grocery list is present to the UI, the gropupItemsByType() method is automatically called to list all items by the type.


3. From the groceryList, we can drive into Item class by selectItem() method. Each item has attributes of itemID, name, type, quantity, checkedOff, and unitOfMeasure attributes. Several set methods are initiated when one item is added into the list from setName(),setType(), setCheckedOff(), setUnitOfMeasure(). All of those values are grabbed from the database via either addItemFromHierarchy() and addItembySpeficy(). The user are asked to input quantity of the item from setQuantity(). The isCheckedOff() method will mark the item in the list to be checkedOFF. 
4. Users can get the HierachicalList class through Application or GroceryList. This class uses Database class and show the list of item of the selected type. Then the user has the option to add the selected item to the list. If the user drives into this class through application class and then a temp list is created to hold the item. When an item is selected to add into the list, the values of this items in the database are fetched from database including name, ItemID, type, unitOfMeasure.

5. Similar to HierachicalList class, Users can get add item through Application or GroceryList. This class uses Database class and show the matched items from database. If no match is found, findSimilarNames() method is called and similar items from the database are presented in the UI. Then the user has the option to add the selected item to the list. If the user drives into this class through application class and then a temp list is created to hold the item. In addition, the user can create items if no match is found or from the top screen of this class by giving the initial attributes including name, type, unitOfMeasure etc. This method will write the new item into the database and into the list as well. When an item is selected to add into the list, the values of this items in the database are fetched from database including name, itemID(unique), type, unitOfMeasure.

6. The application must contain a database of items and corresponding item types. The items are stored in this database having attributes of name, type, itemID(unique), and unitOfMeasure. Several built-in methods are presented in the database: findType() will show all types in the database; findItemsOfType() presents the items of certain type; findItem() gives the item with a specific name; findTypeForItem() is used to show the type attribute of the selected item; findSimilarNames() method is also used for specifySearch when no exact match is found; and insertNewItem() method is used to add new items into the database.



#**Summary**

For the team design we kept the database class as a separate utility class that would handle all database interactions. We decided to accommodate pros of all individual designs in order to create an improved team design.

User uses the application class in order to manage their lists
