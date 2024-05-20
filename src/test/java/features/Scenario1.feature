Feature: Amazon Shopping 

Scenario: Search and add monitor to cart 
	Given User launch amazon website 
	When I type Monitor in search field 
	Then List of monitors are displayed 
	When I add the first item in the cart
	Then Product Page is loaded
	When Add the item to cart by clicking on Add to Cart
    When Open Cart from the top-left
	Then Verify that the price is identical to the product page
	Then Verify that the sub total is identical to the product page
	And I close the browser
	
	