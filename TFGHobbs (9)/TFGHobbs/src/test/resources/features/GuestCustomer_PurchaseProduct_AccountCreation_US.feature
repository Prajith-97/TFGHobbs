@P2_DESKTOP_Guest_customer_checkout_US
Feature:GuestCustomer_PurchaseProduct_AccountCreation_US
  Guest customer purchase products and create account

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "US" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "US"

  #@COUNTRYSELECTOR
  #Scenario: Country Selector
    #Given user clicks on country selector button
    #When user selects a "US" from drop down list
    #Then user is on to "US" website

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
  Scenario: Checkout as guest with non-registered email address
    When user enters a valid email id on checkout login page
    And user selects continue as guest option
    And user clicks Continue Securely button
    Then user is on checkout delivery page

  @SELECTHOMEDELIVERY
  Scenario: Select home delivery
    When user selects default delivery method
    Then delivery method is selected

  @ENTERCUSTOMERDETAILS
  Scenario: Enter customer details
    When user enters the customer details for "US"
    And the user clicks on Enter address manually link
    And user inputs address details
    And user uncheck save delivery address checkBox
    Then continue to Payment CTA button is enabled

  @PROCEEDTOPAYMENTPAGE
  Scenario: Proceed to payment page
    When user clicks on continue to Payment CTA button
    Then user is on payment page

  @PAYBYCARD
  Scenario: Pay by Card
    When user selects <PaymentType> payment method
      | PaymentType |
      | Credit Card |
    And user enters the credit card details
      | CardNumber          | NameOnCard | ExpiryDate | SecurityCode |
      | 4111 1111 1111 1111 | Accept     | 03/30      |          123 |
    Then user uncheck save card details
    Then place order and pay securely CTA button is enabled

  @CLICKONPAYMENTCTA @LANDONCONFIRMATIONPAGE
  Scenario: Click on payment CTA and lands on confirmation page
    When user clicks on place order and pay securely CTA
    Then user lands on confirmation page

  @CREATEACCOUNT_INVALIDPASSWORD
  Scenario: Create guest account with invalid password format
    When user enters password and confirm password
      | password | confirmpassword |
      | /AB      | /AB             |
    And user clicks on create account button
    Then password validation error is thrown

  @CREATEGUESTACCOUNT_VALIDPASSWORD
  Scenario: Create guest account
    When user enters password and confirm password
      | password | confirmpassword |
      | ABC123@# | ABC123@#        |
    And user clicks on create account button
    Then guest account is created

  @RETURNTOHP
  Scenario: Return to HP
    When user clicks on brand logo
    Then user is navigated to home page
