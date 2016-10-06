# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<person or team name\>

## 1 Use Case Diagram

*This section should contain a use case diagram with all the actors and use cases for the system, suitably connected.*
##![alt tag](images/useCaseDiagram.png)

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*

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
* A new item with the properties specified by the user is added to the selected grocery list.  

*Alternate Scenario:*

* User opens application
* User selects a grocery list that was previously created
* Application prompts user to add items to the grocery list  
* User selects add items
* Application displays options to select an item type from a list or specify an item by entering its name
* The user chooses to enter the item by its name
* The application prompts the user with a list of items that are similar to the entered name
* If one of the prompted items are what the user desired, the user selects that item
* If none of the prompted items are what the user desired, the user selects an option for no match. 
	* Application prompts user to specify item type for entered item
	* User enters item type 
* Application prompts user to input quantity of item
* User inputs quantity
* User selects add 
* A new item with the properties specified by the user is added to the selected grocery list