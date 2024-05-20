Feature: Amazon Shopping for Laptop



  Scenario: Search and add laptop to cart
   Given User launch amazon website 
    When I type Laptop in search field 
    Then List of monitors are displayed 
    When Select the second item in the List
    Then Product Page is loaded
    When Add the item to cart by clicking on Add to Cart
    And Open Cart from the top-left
    Then Verify that the price is identical to the product page
    And Verify that the sub total is identical to the product page