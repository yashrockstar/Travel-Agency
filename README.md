# Low-Level Design (UML Class Diagram)
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
	|                                            |
        |                     +-------------------------------------------------------+
        |                     |                                                       |
        |                     |                                                       |
        |                     v                                                       v
        |               +-----------+                                             +--------+
        |               |Destination|                                             |Activity|
        |               +------------------------------+                      +------------------------+
        |               | - name: String               |                      | - name: String         |
        |               | - activities: List<Activity> |                      | - description: String  |
        |               +------------------------------+                      | - cost: double         |
        |                                                                     | - capacity: int        |
        |                                                                     +------------------------+
        |                                                                             /|\
        |                                                                            / | \
        |                                                                           /  |  \
        |                                                                          /   |   \
        |          +-------------+                                          +------------------------+     
        |          |  Passenger  |                                          |  ActivityRegistration  |
        |          +-------------+ --------------------------+              +------------------------+
        |         | - name: String                           |              | - activity: Activity   |
        |         | - passengerNumber: int                   |              | - pricePaid: double    |
        +-------->| - balance: double                        |              +------------------------+
                  | - activities: List<ActivityRegistration> |
                  +------------------------------------------+
                    |   |   |
                    |   |   |
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
