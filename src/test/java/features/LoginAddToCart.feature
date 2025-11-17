Feature: Login, add iPhone X to cart and purchase

  Scenario: User logs in, adds iPhone X to cart and completes purchase
    Given User launches the application
    When User logs in with username "rahulshettyacademy" and password "learning"
    And User selects User role and clicks okay
    And User selects "Teacher" from dropdown
    And User accepts terms and logs in
    And User adds "iphone X" to cart
    And User proceeds to cart
    Then The product "iphone X" should be present in cart
    When User checks out the product
    And User selects country "India"
    Then Order should be successfully placed

  Scenario: Invalid login should display proper error message
    Given User launches the application
    When User logs in with username "wrongUser" and password "wrongPass"
    And User accepts terms and logs in
    Then An error message "Incorrect username/password." should be displayed
