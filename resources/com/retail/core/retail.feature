Feature: Retail, UPC and Price Verification
Ensure that UPC and Price match on shipment.jsp

@Web
Scenario: UPC to Price
	Given the following Data:
	|567321101987	|19.99	|
	|567321101986	|17.99	|
	|567321101985	|20.49	|
	|567321101984	|23.88	|
	|467321101899	|9.75	|
	|477321101878	|17.25	|
	When User Navigates to Create Shipment Page
	
	Then upc should match corresponding price