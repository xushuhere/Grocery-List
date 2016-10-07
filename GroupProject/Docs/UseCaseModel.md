# Use Case Model

**Author**: Team 16: Anshul Goel, Dwight Nelson, Shu Xu, Zakariya Ahmad

## 1 Use Case Diagram

##![alt tag](images/useCaseDiagram.png)

## 2 Use Case Descriptions

**Use Case 1:** Create grocery list

*Requirements:* This use case should allow the user to create a new grocery list that can be used to track items they need or want to purchase from a grocery store. 

*Pre-conditions:* None

*Post-conditions:* 

* A new grocery list is created
* The grocery list has a name    

*Normal Scenario:*
   
* User opens application
* Application prompts user to select desired activity: create, (re)name, or delete list
* User selects option to create
* Application prompts user to enter a name for the list
* User inputs desired name for list
* User clicks next 
* New grocery list with that name is created

*Alternate Scenario:*

* User opens application
* Application prompts user to select desired activity: create, (re)name, or delete list 
* User selects option to create
* Application prompts user to enter a name for the list
* User does not input a name for list
* User clicks next 
* Application prompts user that it cannot create a list without a name
* User input desired name for list
* User clicks next 
* New grocery list with that name is created

**Use Case 2:** Add items

*Requirements:* This use case should allow the user to add items to an existing grocery list.

*Pre-conditions:*

* At least one grocery list has been created and is available for the user to select

*Post-conditions:* 

* An item must have been added to an existing grocery list as specified by the user

*Normal Scenario:*
   
* User opens application
* User selects a grocery list that was previously created
* Application prompts user to add items to the grocery list  
* User selects add items
* Application displays options to select an item type from a list or specify an item by entering its name
* The user selects an item type from the list
* The application presents a list of items to select from 
* User selects the item they want from this list  
* Application prompts user to input quantity of item
* User inputs quantity
* User selects add 
* A new item with the properties specified by the user is added to the selected grocery list

*Alternate Scenario:*

* User opens application
* User selects a grocery list that was previously created
* Application prompts user to add items to the grocery list  
* User selects add items
* Application displays options to select an item type from a list or specify an item by entering its name
* The user chooses to enter the item by its name
* The application prompts the user with a list of items that are similar to the entered name
* If one of the prompted items are what the user desired, the user selects that item
* If none of the prompted items are what the user desired, the user selects an option for no match 
	* Application prompts user to specify item type for entered item
	* User enters item type 
* Application prompts user to input quantity of item
* User inputs quantity
* User selects add 
* A new item with the properties specified by the user is added to the selected grocery list

**Use Case 3:** Maintain items

*Requirements:* This use case should allow the user to modify an item's quantity and remove and item from a list

*Pre-conditions:*

* There exists at least one grocery list, which contains at least one item

*Post-conditions:* 

* The appropriate modifications to the user specified item have been made and saved to the grocery list which contains it

*Normal Scenario:*
   
* User opens application
* User selects a grocery list that was previously created
* User selects an item from the list  
* Application prompts user to edit or delete
* If user selects edit:
	* Application prompts user to change quantity
	* User changes quantity
* If user selects delete:
	* Application confirms that user wants to delete item
	* User confirms
	* The item is removed from the grocery list
* User is returned to the grocery list view 

**Use Case 4:** View grocery list

*Requirements:* This use case should allow the user to view a specified grocery list and check off items as they attain them

*Pre-conditions:*

* There exists at least one grocery list, which contains at least one item

*Post-conditions:* 

* Items that the user has acquired and specified are checked off in the grocery list 

*Normal Scenario:*
   
* User opens application
* User selects a grocery list that was previously created
* User scrolls to the item type of the item they are looking for
* User identifies the item they need to acquire
* If user has not acquired specified item, no changes are made
* If user has acquired specified item, user checks off the item
* User is returned to the grocery list view 

**Use Case 5:** Maintain grocery lists

*Requirements:* This use case should allow the user to modify or delete existing grocery lists

*Pre-conditions:*

* There exists at least one grocery list

*Post-conditions:* 

* User specified actions to grocery list have been made and saved

*Normal Scenario:*
   
* User opens application
* User is viewing list of all available grocery lists
* Application has edit button available
* User selects edit
* Application prompts user to specifiy which list to edit
* User selects a single grocery list
* Application prompts user to rename list or delete list
* If user selects rename list:
	* User enters new name for grocery list
	* User selects save
* If user selects delete:
	* Application confirms user wishes to delete specified list
	* User confirms
	* Grocery list is deleted
* User is returned to the grocery list view 

*Alternate Scenario:*
   
* User opens application
* User is viewing list of all available grocery lists
* Application has edit button available
* User selects edit
* Application prompts user to specifiy which list to edit
* User selects a single grocery list
* Application prompts user to rename list or delete list
* If user selects rename list:
	* User enters new name for grocery list
	* User selects save
* If user selects delete:
	* Application confirms user wishes to delete specified list
	* User selects cancel
	* Grocery list is not deleted
* User is returned to the grocery list view 

*Alternate Scenario 2:*
   
* User opens application
* User is viewing list of all available grocery lists
* Application has edit button available
* User selects edit
* Application prompts user to specifiy which list to edit
* User selects a single grocery list
* Application prompts user to rename list or delete list
* If user selects rename list:
	* User does not enter new name for grocery list
	* User selects save
	* Grocery list maintains original list name
* If user selects delete:
	* Application confirms user wishes to delete specified list
	* User confirms
	* Grocery list is deleted
* User is returned to the grocery list view 