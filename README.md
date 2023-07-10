# Low-Level Design (UML Class Diagram)
                              +------------------+
                              |   TravelPackage  |
                              +------------------+
                              | - name: String   |
                              | - passengerCapacity: int |
                              | - itinerary: List<Destination> |
                              | - passengers: List<Passenger> |
                              +------------------+
                              | + addDestination(destination: Destination): void |
                              | + addPassenger(passenger: Passenger): void |
                              | + printItinerary(): void |
                              | + printPassengerList(): void |
                              | + printPassengerDetails(passengerNumber: int): void |
                              | + printAvailableActivities(): void |
                              +------------------+

                                     / | \
                                    /  |  \
                                   /   |   \
                                  /    |    \
                            +-------+  |  +--------+
                            |Destination|  |Activity|
                            +-------+  |  +--------+
                            | - name: String    | - name: String
                            | - activities: List<Activity> | - description: String
                            +-------+  |  | - cost: double
                              | |   |    | - capacity: int
                              | |   |    +--------+
                              | |   |          /|\
                              | |   |         / | \
                              | |   |        /  |  \
                              | |   |       /   |   \
                      +---------+  |  +-----+ +------+     
                      |  Passenger  |  |  ActivityRegistration  |
                      +---------+  |  +-----+ +------+
                      | - name: String    | | - activity: Activity
                      | - passengerNumber: int  | | - pricePaid: double
                      | - balance: double | +------+
                      | - activities: List<ActivityRegistration> |
                      +---------+
                        |   |   |
                        |   |   |
                        |   |   |
                     +---+   |   +---+
                     |    PremiumPassengerType   |
                     +---+   +---+
                     | - calculatePricePaid()  |
                     +---+
                     |   |   |
                  +--+   |   +--+
                  |   StandardPassengerType |
                  +--+   +--+
                  | - calculatePricePaid() |
                  +--+
                  |   |   |
                  +--+   +--+
                  |   GoldPassengerType  |
                  +--+   +--+
                  | - calculatePricePaid() |
                  +--+
