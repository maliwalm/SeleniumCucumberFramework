Feature: TC01_flightBooking

Scenario Outline: Book Flight

Given Login with Username as "<userName>" and Password as "<password>"
And Search Flight for Type as "<type>" , Passenger Count "<passenger>" , Departure from "<departure>" , On "<fromMonth>" "<fromDay>" , Arrival to "<arrival>" , On "<toMonth>" "<toDay>" in Class as "<serviceClass>" and Preferred class as "<preference>"
And Entering Passenger details First Name as "<firstName>" , Last Name as "<lastName>" and Creditcard No as "<credirCard>"
When User Books Confirms Flight Booking
Then Flight Should be booked successfully 
Then User SignOut


Examples:

|userName|password|type      |passenger|departure|fromMonth|fromDay|arrival|toMonth|toDay|serviceClass    |preference       |firstName|lastName|credirCard|
|mohit   |mohit   |Round Trip|	2      |London	 |July     |	25 |Paris  |   July|   29|First Class     |	Pangea Airlines	|lorem	  |ipsum   |12345     |
|mohit   |mohit   |Round Trip|	3      |Paris	 |August   |	25 |London | August|   29|Business Class  |	Unified Airlines|lorem	  |ipsum   |12345     |
