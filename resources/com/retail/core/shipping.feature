Feature: Shipping
Confirm Prices and Mileage to and from different cities

@Web4
Scenario:
	Given These packages "<upcList>" are being shipped by "<empName>"
	And The shipping route will be from "<fromCity>" to "<toCity>" with <mileage> distance
	When The User Navigate to Create Shipment Page
	Then The employee number will be displayed
	And The total cost should be <totalCost>
	
Examples:
| 			upcList		   |empName |fromCity|  toCity|	totalCost| mileage|
|477321101878 567321101984 |Andrew  |Atlanta |Tampa   |   9.28	 | 	456	  |
|467321101899              |Susan   |Seattle |Tampa   |   6.57	 | 3090	  |
|567321101986 567321101985 |Andrew  |Seattle |Seattle |   5.93	 |	0	  |
|567321101987 567321101984 |Eric    |Atlanta |Seattle |   5.89	 | 2636	  |