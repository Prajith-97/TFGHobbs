@P2_ALL_DESKTOP_Checkout_registered_error_forms_ROW
Feature:CheckoutAsGuest_RegisteredCustomer_EmailAndPasswordValidation_ROW
  checkout as guest with invalid email,valid email and registered customer with incorrect password

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "ROW" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "ROW"

  @COUNTRYSELECTOR
  Scenario: Country Selector
    Given user clicks on country selector button
    When user selects a "DE" from drop down list
    Then user is on to "DE" website
    
  @SEARCHPRODUCTFROMHOMEPAGE @LANDONPDP
  Scenario:  Search Product in Homepage and Land on PDP
    Given user searches for product from HomePage and lands on PDP
    When user selects the products from PLP
    Then user is on PDP page

 @ONPDPSELECTRANDOMSIZE
  Scenario:  Select random size on PDP
    When user selects randon size for the product
    Then user clicks add to bag button on PDP

  @GOTOBAGPAGE
  Scenario: Go to bag page
    When user clicks on view bag
    Then user is on basket page

  @CLICKONCHECKOUTSECURELY
  Scenario: Click on checkout securely
    When user clicks on check out securely button
    Then user is on check out login page

  @CHECKOUTASGUEST
  Scenario: Checkout as guest with invalid email address
    When user enters Email ID on check out login page
      | Email           |
      | Helen.gmail.com |
    And user selects continue as guest option
    And user clicks Continue Securely button

  @CHECKOUTASREGISTERED
  Scenario: Checkout as registered customer with incorrect password
    When user enters Email ID on check out login page
      | Email                    |
      | steivejackson@gmail.com  |
    And user selects Yes my password is option
    And user enters incorrect password
      | Password   |
      | 123jackson |
    And user clicks Continue Securely button
    Then Invalid login or password error is shown

  @CHECKOUTASGUEST
  Scenario: Checkout as guest with registered email address and checkout as guest
    When user enters Email ID on check out login page
      | Email                    |
      | steivejackson@gmail.com  |
    And user selects continue as guest option
    And user clicks Continue Securely button
    Then user is on checkout delivery page

  @DONOTENTER_MANDATORY_INFO
  Scenario: Checkout - Delivery verify mandatory info
    Given user checks continue to payment without enter manadtory fields
    When user enters the customer details for "ROW"
    And the user clicks on Enter address manually link
    And user inputs address details
    And user uncheck save delivery address checkBox
    Then continue to Payment CTA button is enabled

