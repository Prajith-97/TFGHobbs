@DESKTOP_JOURNEY_1_UK
Feature:GuestCustomer_NoFilters_PayByCard_UK
  Guest customer with non registered Email address, no filters on PLP, pay by card

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "UK" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "UK"

#  @COUNTRYSELECTOR
#  Scenario: Country Selector
#    Given user clicks on country selector button
#    When user selects a "UK" from drop down list
#    Then user is on to "UK" website

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
    When user enters an <EmailID> on check out login page
      | EmailID                      |
      | G10X_userTest_G10X@gmail.com |
    And user selects continue as guest option
    And user clicks Continue Securely button
    Then user is on checkout delivery page


  @ENTERCUSTOMERDETAILS
  Scenario: Enter customer details
    When user enters the customer details for "UK"
    And the user clicks on Enter address manually link
    And user inputs address details
    And user uncheck save delivery address checkBox
    Then continue to Payment CTA button is enabled

  @SELECTHOMEDELIVERY
  Scenario: Select home delivery
    When user selects a <Delivery> method
      | Delivery |
      | Standard |
    Then the <Delivery> method is selected
      | Delivery |
      | Standard |

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
      | 4111 1111 1111 1111 | Accept     | 03/30      | 123          |
    Then user uncheck save card details
    Then place order and pay securely CTA button is enabled

  @CLICKONPAYMENTCTA @LANDONCONFIRMATIONPAGE
  Scenario: Click on payment CTA and lands on confirmation page
    When user clicks on place order and pay securely CTA
    Then user lands on confirmation page
    
    
  @RETURNTOHP
  Scenario: Return to HP
    When user clicks on brand logo
    Then user is navigated to home page
