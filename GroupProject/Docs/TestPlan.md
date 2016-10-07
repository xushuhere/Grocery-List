#Test Plan
This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.
Author: <Team 16>

##1 Testing Strategy
###1.1 Overall strategy

This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.

We plan to use a combination of unit and system testing to verify the functionality of the product. The main class database util will have various methods pertaining to the interaction of the application with the database and hence unit testing will be performed on this file to verify functionality. Various other methods in the other classes like grocerylist manager, grocerylist and list item will have similar unit tests as well wherever possible.

We will try to keep code coverage high on all the code except the UI code and will test our UI on various size emulators in order to be certain that it is consistent across different device sizes.

We will use beta testers to check for UI usability and use that feedback for better user experience. 


###1.2 Test Selection
Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.

We will use both black box and whitebox testing techniques. Black box testing will include getting help and feedback from various beta testers. Trying to add invalid input and trying to make the code execute unexpected values.
Using code reviews and bug finding sessions we will perform white-box testing and unit tests will also help us be certain that individual modules work as expected

###1.3 Adequacy Criterion
Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.
We will use code coverage tools to analyze our testing quality

###1.4 Bug Tracking
Describe how bugs and enhancement requests will be tracked.
Github will be used to keep track of the bugs we will let users open issues that can be monitored by the entire team

###1.5 Technology
Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).
We will use JUNIT to perform our unit tests

##2 Test Cases
This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.


|Purpose| Steps Performed|Expected Result|Actual Result||Status(Pass/Fail)|
| -------------: |:---------------------------------:| ------------- |:-------------:|------------:|
|User should be able to create a grocery list|1: User clicks on add button  2: A dialog opens where user is prompted to enter list name 3: User enters List name and clicks create  4: List gets created|List gets created|  |  |  |

|User should be able to delete a grocery list|
1: User clicks on delete list button
2: A confirmation dialog opens where user is is asked if the user is sure
3: User clicks delete
4: List gets deleted|
List gets deleted|  |  |  |

|User should be able to rename a grocery list|
1: User clicks on rename list button
2: A dialog opens where user is prompted to enter new list name
3: User enters List name and clicks rename
4: List gets renamed|
List gets renamed|   |  |  |


|User should be able to view all grocery lists that belong to user|
1: User opens the application
2: User dashboard opens
3: Difference cards are displayed with names of the lists that belong to the user on it|
List that belong to a user should be visible|   |  |  |




|User should not be able to see grocery lists that belong to other users|
1: User 1 opens the application and logs in
2: User 1 dashboard opens
3: Lists belonging to user 1 is visible
4: User 1 logs out
5: User 2 opens the application and logs in
6: User 2 dashboard opens
7: Lists belonging to user 2 are visible|
List for other user should not be visible|   |  |  |


|User should be able to mark a grocery list as active|
1: User clicks on activate list button
2: The list gets activated and list card color changes
3: All the other lists get deactivated
4: All the other list cards turn to default color|
List gets marked as active|   |  |  |




|User should be able to add item to the active grocery list|
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on add item
4: A dialog opens that allows user to search for item
5: User starts typing the search term
6: As the user is typing a list is populated with all the items that match the search term
7: User selects an item
8: User clicks add to list button
9: Item gets added|
|Item gets added to active list|   |  |  |




|User should be able to see all items in the grocery list|
1: User clicks on a list card
2: A new activity opens that displays all items in that list|
All items in the list are visible|   |  |  |




|User should be able to check all Items in the grocery list|
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on check all items button
4: All items get checked| 

All items in the list get checked| |  |  |





|User should be able to unCheckall Items in the grocery list|
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on un-check all items button
4: All items get un-checked|
All items in the list get unChecked| |  |  





User should be able to group items in grocery list by type
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: The new activity has all list items grouped by their type
All items in the list get grouped by type




User should be able to remove item from the grocery list
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on a list item card
4: A dialog with various possible action opens.
5: user clicks delete item
6: Items gets deleted
7: List Items activity refreshes and the recently deleted item is not visible
Item gets removed from the list




User should be able check and individual item in grocery list
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on
Check box on the  a list item card
4: List Items activity refreshes and the recently checked item cards checkbox is checked
A particular Item is marked as checked 




User should be able uncheck and individual item in grocery list
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on
Check box on the  a list item card
4: List Items activity refreshes and the recently unchecked item cards checkbox is unchecked
A particular Item is marked as unChecked 




User should be able to change quantity of an Item in grocery list
1: User clicks on a list card
2: A new activity opens that displays all items in that list
3: User clicks on a list item card
4: A dialog with various possible action opens.
5: user clicks on change quantity
6: User is prompted to enter new quantity
7: User enters new quantity and clicks save
8: List Items activity refreshes and the modified item displays new quantity
Quantity of the item gets changed




User should be able to see all items types in database
1: User opens the application
2: User dashboard opens
3: User Clicks on manage db button
4: A new activity opens that displays all item types in a list


All distinct item types are visible to the user




User should be able to see all items for a particular type in the database
1: User opens the application
2: User dashboard opens
3: User Clicks on manage db button
4: A new activity opens that displays all item types in a list
5: User clicks on item type
6: List expands to show all items under that type
All items if a particular type are visible to the user




User should be able to add items to the database
1: User opens the application
2: User dashboard opens
3: User Clicks on manage db button
4: User clicks on add item to db button
5: A dialog opens that allow user to enter a type and an item name
6: User clicks add button
7: Item gets added to the DB
Item added by user gets added to the database




User should be able to similar items to a keyword from the database
1: User opens the application
2: User dashboard opens
3: User Clicks on manage db button
4: A new activity opens that displays all item types in a list
5: User clicks on find item button
6: A dialog opens where user enters a search term
7: Items matching the keyword are displayed in a list
Items with names similar to the one added by the user are displayed to the user




Use should be able to switch between the lists
1: User opens the application
2: User dashboard opens
3: User marks a list as active
4: User marks another list as active
5: First list gets deactivated and new list gets marked as active
New list is marked as active list





