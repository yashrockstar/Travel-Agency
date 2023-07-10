# Low-Level Design (UML Class Diagram)

In the Lower Level Diagram, we have identified the main classes and their relationships in the travel agency system. The classes include:

1. **TravelPackage**        : Represents a travel package name , capacity, list destinations and list of passengers, and related methods.
2. **Destination**          : Represents a destination and contains activities available at that destination.
3. **Activity**             : Represents an activity available at a destination with cost and capacity information.
4. **Passenger**            : Represents a passenger and contains passenger information, balance, and activity registrations.
5. **PassengerType**        : Represents the type of a passenger (e.g., Standard, Gold, Premium). Basically it is an interface which is implemented by 3 class PremiumPassengerType, StandardPassengerType & GoldPassengerType
6. **ActivityRegistration** : Represents the registration for an activity by a passenger.
   
![image](https://github.com/yashrockstar/Travel-Agency/assets/72990999/1cac5933-c136-4698-b52e-5d0d0da59c64)

                                           
# High-Level Design (Block Diagram)

In this diagram, each component represents a major functionality or module of the travel agency system. The arrows indicate the interactions between the components. Here's a brief description of each component:

1. **User Interface**            : Handles user interactions and provides features such as search functionality, package selection, passenger registration, and activity sign-ups.
2. **Travel Package Management** : Manages travel packages, including creating and updating packages, adding destinations and activities, managing capacity, and generating itineraries.
3. **Passenger Management**      : Handles passenger-related tasks such as registration, tracking passenger details, managing balances, and handling activity sign-ups.
4. **Activity Management**       : Deals with managing activities available at various destinations, including adding and updating activities, tracking capacity, and coordinating with passenger registrations.
5. **Database**                  : Stores and manages data related to travel packages, destinations, activities, passengers, and activity registrations, providing persistent storage and retrieval.
6. **External APIs/Services**    : Represents external services or APIs that the travel agency system interacts with, such as payment gateways, booking systems, or third-party APIs.
7. **Reporting and Analytics**   : Focuses on generating reports, analyzing data, and providing insights related to travel packages, passenger activities, revenue, and other relevant metrics.

          +-------------------+
          |    User Interface |
          +-------------------+
                     |
           +-------------------------------+
           |   Travel Package Management   |
           +-------------------------------+
                     |
           +----------------------------+
           |    Passenger Management    |
           +----------------------------+
                     |
           +-----------------------------+
           |     Activity Management     |
           +-----------------------------+
                     |
           +-------------------------+
           |        Database         |
           +-------------------------+
                     |
        +----------------------------+
        |   External APIs/Services   |
        +----------------------------+
                     |
         +-----------------------------+
         |   Reporting and Analytics   |
         +-----------------------------+

![image](https://github.com/yashrockstar/Travel-Agency/assets/72990999/25b1fd4b-edcb-435b-b172-9dbfb2d8bd12)


