#USER MANUAL FOR GLM

## 1 Overview

This document provides a basic guide for users of the GLM (Grocery List Manager) application. The following sections will describe user tasks and how the user should interact with the application to perform those tasks.
  
## 2 Working With Users/Profiles

When the application starts, the user is presented with a list of usernames/profiles to choose from. Selecting a username/profile gives the current user access to grocerylists under that profile.

:arrow_down_small: Profile Screen
#![profile screen](Images/screenshot_profiles.png)

* CHANGE User: User can click native backwards key from your device to go back to the previous page


:scroll: _STEPS_
* STEP 1: Select User/Profile


## 3 Working With Grocery Lists
After selecting a user profile a screen is displayed that contains the selected user's grocery lists.

### 3.1 Creating Lists
To create a list on this screen the user is given an "Add List" button at the bottom of the screen.

:arrow_down_small: Grocery List Screen Empty
#![empty grocerylists](Images/screenshot_addlist_empty.png)

:arrow_down_small: Grocery List screen after "Add List" button is clicked
#![add list](Images/screenshot_addlist_clicked.png)

:arrow_down_small: Grocery List screen after updating the name for the new Grocery List
#![add list edited](Images/screenshot_addlist_clicked_updated.png)

:arrow_down_small: Grocery List screen after the new list is added
#![list added](Images/screenshot_addlist_onelist.png)

* CANCEL the action : User can click native backwards key from your device to go back to the previous page


:scroll: _STEPS_
* STEP 1: Select Add List.
* STEP 2: Enter a name for the grocery list.
* STEP 3: Select Save

### 3.2 Renaming Lists
After a list is added to the profile, there is an option to rename the list by selecting the <img src="Images/edit_button.png" alt="pencil icon" width="20" height="20"/> button.

:arrow_down_small: Renamed List
#![rename list](Images/screenshot_addlist_clicked_updated.png)

* CANCEL the action : User can click native backwards key from your device to go back to the previous page

:scroll: _STEPS_
* STEP 1: Select Pencil Icon.
* STEP 2: Enter a name for the grocery list.

### 3.3 Removing Lists
After a list is added to the profile, there is also an option to remove the list by selecting the <img src="Images/remove_sign.png" alt="X icon" width="20" height="20"/>  button.

:arrow_down_small: List Removed
#![remove list](Images/screenshot_addlist_empty.png)

:scroll: _STEPS_
* STEP 1: Select X button.
* STEP 2: Observe that the selected list has been removed.

## 4 Working With Grocery List Items

:arrow_down_small: Item Screen
#![item screen empty](Images/screenshot_firstlist_selected.png)

### 4.1 Adding Items

:arrow_down_small: Screen shown after "Add Item" clicked 
#![add item clicked](Images/screenshot_additem_clicked.png)

* CANCEL the action : User can click native backwards key from your device to go back to the previous page


#### 4.1.1 Text Search

:arrow_down_small: Screen shown after "Search Name" clicked
#![search name clicked](Images/screenshot_searchname_clicked.png)

:arrow_down_small: Editing the search criteria
#![search name edit](Images/screenshot_searchname_edited.png)

:arrow_down_small: Screen shown after the add button is clicked
#![search name add clicked](Images/screenshot_searchname_add_clicked.png)

:arrow_down_small: Editing the new item
#![search name add edit](Images/screenshot_searchname_add_edited.png)

:arrow_down_small: Item added to list
#![item added from search](Images/screenshot_itemAddedFromSearchName.png)

:scroll: _STEPS_
* STEP 1: Select Add Item
* STEP 2: Select Search Name
* STEP 3: Type in Item Name
* STEP 4: Select Add
* STEP 5: Set the Item's type, quantity, and unit
* STEP 6: Select Save
* STEP 7: Observe that the new item has been added to the list

#### 4.1.2 Hierarchical Search

:arrow_down_small: Screen shown after clicking "Hierarchical List" is clicked
#![hierarchy clicked](Images/screenshot_hierarchy_clicked.png)

### 4.2 Removing Items

After an item is added to the list, there is an option to remove the item by selecting the <img src="Images/remove_sign.png" alt="X icon" width="20" height="20"/> button next to the item.

:scroll: _STEPS_
* STEP 1: Select X button.
* STEP 2: Observe that the selected item has been removed.

### 4.3 Checking Off Items

After an item is added to the list, there is an option to check off the item by selecting the check box next to the item.

:arrow_down_small: Screen shown when no items are checked off or "uncheck all" is clicked
#![no checks](Images/screenshot_multipleitems_unchecked.png)

:arrow_down_small: Screen shown when one item is checked off
#![one check](Images/screenshot_multipleitems_onechecked.png)

:arrow_down_small: Screen shown when all items are checked off or "check all" is clicked
#![all checked](Images/screenshot_multipleitems_allchecked.png)

:scroll: _STEPS_
* STEP 1: Click an empty checkbox.
* STEP 2: Observe that the cooresponding item is checked off.
* STEP 3: Click the Check All button
* STEP 4: Observe that all items are checked off
* STEP 5: Click Uncheck All
* STEP 6: Observe that all items are unchecked

### 4.4 Editing Items

After a list is added to the profile, there is also an option to remove the list by selecting the <img src="Images/edit_button.png" alt="pencil icon" width="20" height="20"/> button.

:arrow_down_small:  Screen shown after edit icon clicked
#![edit item clicked](Images/screenshot_edititem_clicked.png)

:arrow_down_small: Editing (Allows user to modify product quantity)
#![editing item](Images/screenshot_edititem_edited.png)

:arrow_down_small: Item changes saved
#![saved edit](Images/screenshot_edititem_saved.png)

:scroll: _STEPS_
* STEP 1: Click the edit icon for an item.
* STEP 2: Modify the items quantity 
* STEP 3: Click Save
* STEP 4: Observe that the item's quantity has changed

## 5 Conclusion
This is the alpha version of grocery list manger. It has the ability to add/edit shopping list, add item to the list by hierarchical search or specified name search. In addition, users can add item by specified search and save it to database for future use and add it to current list.

