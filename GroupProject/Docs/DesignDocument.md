# Design Document
**Author**: \<Team 16\>

## 1 Design Considerations
The application is a single user end operated in an android system for grocery lists management. This application will be operated independently by each end user, and the database will be updated by both user and database administrators.

### 1.1 Assumptions
The users will be required to open and navigate the interface via their android phones. They will be able to operate the software by clicking buttons, selecting radio button, check/uncheck boxes. The device has internet connections and will be able to pull remote data from a database server.
- the user will have access to a Android 4.0+ smart phone or tablet
- the user is capable of using common Android 4.0+ UI components
- the parse.com data store will continue to operate through the use of the application
- the security of this application is not required.

### 1.2 Constraints

Constraints that have significant impact on the system design are:
* Storage Space: The design must accomodate application and application data
* Display Size: Lists and user capabilities must fit within available screen space
* 

### 1.3 System Environment

*Describe the hardware and software that the system must operate in and interact with.*

**Hardware:**

* Android phones
* Minimum network capability (at least one)
	* EDGE, HSPA, EV-DO, 802.11g
* Minimum memory and storage
	* Minimum 30mb of free storage to accomodate application and application data
* Display
	* Less than 6 inch screen size 
	* Supported resolutions: HDPI, XDPI, XXHDPI, XXXHDPI
	* Touchscreen capabilities


**Software**

* The minimum software requirements for this application will be Android API Level 19. 
* The Application will be developed using Java JDK 7


## 2 Architectural Design

### 2.1 Component Diagram

The following diagram shows the overall system architecture and it's components. Our design encorporates a Three Tier architecture that decouples UI, Logic, and Data Storage components of the system. This helps improve system maintainability.

#![alt tag](Images/ArchitectureComponent.png)


### 2.2 Deployment Diagram

The components created in the design of this application are all held on a single device. Any part of the system that doesn't reside on the Android device is third party software that is not designed her. A deployment Diagram is unnecessary in this case.

## 3 Low-Level Design

The following sections describe the implemented functions of the system and how they work together. The class diagram sections shows each class, its attriutes, and functions. It also describes how each class fits into our architecture. In the other diagrams section we've added a sequence diagram to show the steps necessary to add an item to a list from a Hierarchy.

### 3.1 Class Diagram

How our classes fit into our architecture:
* Presentation Layer: Application, HierarchicalList, SpecifySearch
* Logic Layer: GroceryList, Item, Database(class)
* Database Layer: None (This layer contains the physical data and the server that provides the data) 

#![alt tag](../Design-Team/images/design-team.png)

### 3.2 Other Diagrams

## 4 User Interface Design

Base UI View for user
#![alt tag](Images/MockUp2.png)

GroceryList Selection and Deletion
#![alt tag](Images/ListsSelectDelete.png)

Hierarchical List for Item selection (Opened by Find Item Button in Base UI):
#![alt tag](Images/HierArchicalList.png)
