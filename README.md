# Low-Level Design (UML Class Diagram)

In the Lower Level Diagram, we have identified the main classes and their relationships in the travel agency system. The classes include:

1. TravelPackage        : Represents a travel package name , capacity, list destinations and list of passengers, and related methods.
2. Destination          : Represents a destination and contains activities available at that destination.
3. Activity             : Represents an activity available at a destination with cost and capacity information.
4. Passenger            : Represents a passenger and contains passenger information, balance, and activity registrations.
5. PassengerType        : Represents the type of a passenger (e.g., Standard, Gold, Premium). Basically it is an interface which is implemented by 3 class PremiumPassengerType, StandardPassengerType & GoldPassengerType
6. ActivityRegistration : Represents the registration for an activity by a passenger.
   
                          +------------------+
                          |   TravelPackage  |
                          +--------------------------------+
                          | - name: String                 |
                          | - passengerCapacity: int       |
                          | - itinerary: List<Destination> |
                          | - passengers: List<Passenger>  |
         +----------------+-----------------------------------------------------+
        |                 | + addDestination(destination: Destination): void    |
        |                 | + addPassenger(passenger: Passenger): void          |
        |                 | + printItinerary(): void                            |
        |                 | + printPassengerList(): void                        |
        |                 | + printPassengerDetails(passengerNumber: int): void |
        |                 | + printAvailableActivities(): void                  |
        |                 +-----------------------------------------------------+
        |                     |
        |                     |                                                       
        |                     |                                                       
        |                     v                                                       
        |               +-----------+                                          +------------------------+
        |               |Destination|                              +---------> |Activity                |
        |               +------------------------------+           |           +------------------------+
        |               | - name: String               |           |           | - name: String         |
        |               | - activities: List<Activity> |-----------+           | - description: String  |----------------------+ 
        |               +------------------------------+                       | - cost: double         |					             
        |                                                                      | - capacity: int        |                      |
        |                                                                      +------------------------+                      |
        |                                                                                /|\                                   |
        |                                                                               / | \                                  |
        |                                                                              /  |  \                                 |
        |                                                                             /   |   \                                |
        |          +-------------+                                             +------------------------+                      |
        |          |  Passenger  |                                      +----> |  ActivityRegistration  |                      |
        |          +-------------+ --------------------------+          |      +------------------------+                      |                      
        |         | - name: String                           |          |      | - activity: Activity   |                      |
        |         | - passengerNumber: int                   |          |      | - pricePaid: double    |                      |
        +-------->| - balance: double                        |----------+      +------------------------+                      |
                  | - activities: List<ActivityRegistration> |                                                                 |
                  +------------------------------------------+                                                                 | 
                    |   |   																								                                                   
                    |   |   +--------------------------------------------------------------------------------------------------+
                    |   |   |
                 +---------------------------+
                 |    PremiumPassengerType   |
                 +----------+   +------------+
                 | - calculatePricePaid()    |
                 +---------------------------+
                 |   |   |
              +-------------------------+
              |   StandardPassengerType |
              +-----------+   +---------+
              | - calculatePricePaid()  |
              +-------------------------+
              |   |   |
              +-------------------------+
              |   GoldPassengerType     |
              +------------+   +--------+
              | - calculatePricePaid()  |
              +-------------------------+


                                           
# High-Level Design (Block Diagram)
         +-----------------+
         |   User Interface   |
         +-----------------+
         | - Input/Output handling |
         | - Interaction with the user |
         +-----------------+
                   |
                   |
                   v
         +-----------------+
         |   Application   |
         +-----------------+
         | - Business logic |
         | - Data management |
         | - Integration with external systems |
         +-----------------+
                   |
                   |
                   v
         +-----------------+
         |    Database     |
         +-----------------+
         | - Persistence of data |
         | - Data retrieval and storage |
         +-----------------+
