# **Test Plan**

**Author**: Team 16: Anshul Goel, Dwight Nelson, Shu Xu, Zakariya Ahmad

## **1 Testing Strategy**

### **1.1 Overall strategy**

Our team will use a combination of black box and white box testing to verify the functionality of the product. System level tests will be performed by developers and beta testers to check for functionality and usability. The developers will write unit tests to ensure the correctness in the functionality of the individual components of the applications.

The database utility class will have various methods pertaining to the interaction of the application with the database and hence will be a good candidate for unit testing to ensure accurate expectations. We will write unit tests to do input validations and boundary checking in other classes as well.

Our team will test our UI on various size emulators in order to be certain that it is consistent across different device sizes.

Beta testers will also help perform usability testing and therefore improve the UX.

### **1.2 Test Selection**

We will use both white box and black box testing.

Black Box - Usability testing by getting feedback from beta testers, Functional testing to ensure requirements are met by using the test plan below, Regression testing on every code merge.

White Box - Unit testing the code, Input validation tests, Integration testing to check interaction between modules.

Using code reviews will also help us maintain code quality reducing the chances of bugs.


### **1.3 Adequacy Criterion**

We will use code coverage tools to analyze our testing quality and write tests in advance to ensure our test don't have any bias.

### **1.4 Bug Tracking**

Github will be used to keep track of the bugs we will let users open issues that can be monitored by the entire team.

### **1.5 Technology**

We will use JUNIT to perform our unit tests and we will also use manually test our app by different devices and opearations.

## **2 Test Cases**
JUNIT tests:
Database classes (3 classes): passed.

<table>
  <tr>
    <td>Purpose</td>
    <td>Steps Performed</td>
    <td>Expected Result</td>
    <td>Actual Result</td>
    <td>Status(P/F)</td>
  </tr>
  <tr>
    <td>Create List</td>
    <td>Open App</td>
    <td>App Opens</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td>Click on create list button</td>
    <td>A dialog opens</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td>Type the name of new list in dialog</td>
    <td>User is able to type name </td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td>Click Save</td>
    <td>Dialog is dismissed  and new list is visible on the page</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Delete List from Dashboard</td>
    <td>Open App</td>
    <td>App Opens</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td>Click on the list name user wants to delete</td>
    <td>A dialog opens</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td>Click on delete list</td>
    <td>List gets deleted and is removed from the page</td>
    <td></td>
    <td>P</td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Rename List from Dashboard</td>
    <td>Open App</td>
    <td>App Opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Click on the list name user wants to rename</td>
    <td>A dialog opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Click on rename list</td>
    <td>A dialog opens asking for a new name</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Type new list name</td>
    <td>User is able to type name</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Click save</td>
    <td>List gets renamed</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>View all grocery lists that belong to user</td>
    <td>User opens the application</td>
    <td>App Opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Check to see if multiple cards are displayed for the grocery lists associated with the user</td>
    <td>Different lists are visible on the dashboard associated with the user</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>User should not be able to see grocery lists that belong to other users</td>
    <td>User 1 Opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User 1 logs in </td>
    <td>User 1 is able to log in and view list associated
to him/her </td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User 1 logs out </td>
    <td>User 1 is able to log out successfully</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User 2 Logs in</td>
    <td>User 2 is able to login and view list associated to him/her and not with user 1</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Mark a grocery list as active</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>Click on the list name user wants to activate</td>
    <td>A new window with details of this particular list opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add item to the active grocery list</td>
    <td>User clicks on add item</td>
    <td>A dialog opens that allows user to search for item</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User starts typing the search term
</td>
    <td>As the user is typing a list is populated with all the items that match the search term</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User selects an item</td>
    <td>Item gets selected and fills the edit text</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on save</td>
    <td>Item gets added to the list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>See all items in the grocery list ordered by type</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the name of the list user wants to see</td>
    <td>A new window opens with items in the list sorted by type</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Check all Items in the grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to check all items for</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the check all checkbox</td>
    <td>The checkboxes new to all items on the activity get marked as checked</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Un - Check all Items in the grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to check all items for</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the un-check all checkbox</td>
    <td>The checkboxes new to all items on the activity get marked as unchecked</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Remove item from the grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to check all items for</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the remove button next the item user wants to remove</td>
    <td>A dialog opens asking the user to confirm</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks confirm</td>
    <td>The item gets removed from the list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Check an individual item in grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to check item for</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the checkbox next the item user wants to check(currently unchecked)</td>
    <td>The checkbox on the item gets marked as checked</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Un-check an individual item in grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to uncheck item for</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the checkbox next the item user wants to check(currently checked)</td>
    <td>The checkbox on the item gets marked as unchecked</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Change quantity of an Item in grocery list</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to change item quantities for </td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the quantity button next the item user wants to change quantity for</td>
    <td>A dialog opens asking the user to enter new quantity</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User types in the new quantity and selects unit</td>
    <td>User enters new quantity</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks save</td>
    <td>The quantity value next to the item gets updated to new quantity</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Switch between the lists</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the a list name</td>
    <td>A new window opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the spinner on top that displays all the user lists</td>
    <td>Spinner dropdown gets expanded</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on the list name user wants to switch to</td>
    <td>Window refreshes and display the new list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>See all items types in database</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on manage DB button</td>
    <td>A new window opens that displays all item types in a list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>See all items for a particular type in the database</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on manage DB button</td>
    <td>A new window opens that displays all item types in a list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on an item type</td>
    <td>A new window opens that displays all items of the selected type in a list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td>Add items to the database</td>
    <td>User opens the app</td>
    <td>App opens</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on manage DB button</td>
    <td>A new window opens that displays all item types in a list</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User clicks on add item button</td>
    <td>A dialog opens prompting user to add the item name and type</td>
    <td></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td>User adds information and clicks save</td>
    <td>New item gets added to the database</td>
    <td></td>
    <td></td>
  </tr>
</table>


