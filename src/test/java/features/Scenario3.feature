Feature: Amazon Shopping for Laptop



  Scenario: Search and add laptop to cart
    Given User launch amazon website 
    When I type headphones in search field 
    Then List of headphones are displayed 
    When Select the first item in the List
    Then Product Page is loaded
    When Add the item to cart by clicking on Add to Cart
    When I type Keyboard in search field
    Then List of Keyboard are displayed 
    When Select the first item from second window in the List
    Then Product Page is loaded
    When Add the item to cart by clicking on Add to Cart
    And Open Cart from the top-left
    Then Verify that the price is identical to the product page
    And Verify that the sub total is identical to the product page