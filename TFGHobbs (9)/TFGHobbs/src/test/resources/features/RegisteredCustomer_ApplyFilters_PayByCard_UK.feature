@DESKTOP_JOURNEY_4_UK
Feature:RegisteredCustomer_ApplyFilters_PayByCard_UK
  Registered customer, apply filters on PLP, pay by card

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "UK" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "UK"

  #@COUNTRYSELECTOR
  #Scenario: Country Selector
    #Given user clicks on country selector button
    #When user selects a "US" from drop down list
    #Then user is on to "US" website

  @CLICKONRANDOMNAVCATEGORY @LANDONPLP
  Scenario:  Click on random nav category and Land on PLP
    When user clicks on <SubCategory> from <MainCategory> category
    Then user is on <SubCategory> PLP


  @ENGAGEWITHFILTER
  Scenario: Hide filter and Show filter on PLP
    When user clicks on hide filter button on PLP
    Then hide filter option is displayed on PLP
    When user clicks on show filter button on PLP
    Then show filter section is displayed on PLP

  @APPLYFILTER
  Scenario: Apply filter on PLP
    When user applies a filter of <FilterName> in <MainFilter> on PLP
      | MainFilter | FilterName |
      | FIT        | Regular    |
    Then <FilterName> filter is applied on PLP
      | FilterName |
      | Regular    |

  @SELECTRANDOMPRODUCT @LANDONPDP
  Scenario: Select random product in PLP and Land on PDP
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

  @CHECKOUTASREGISTEREDCUSTOMER
  Scenario: Checkout as registered customer
    When user enters an <EmailID> on check out login page
      | EmailID                    |
      | G10X_emily_g10x@gmail.com  |
    And user selects password radio button
    And user enters valid <Password>
      | Password  |
      | test@123  |
    And user clicks Continue Securely button
    Then user is on checkout delivery page



  @ENTERCUSTOMERDETAILS
  Scenario: Enter customer details
    When user enters the customer details for "UK"
    And the user clicks on Enter address manually link
    And user inputs address details
    And user uncheck save delivery address checkBox
    Then continue to Payment CTA button is enabled
    Then user uncheck save delivery address checkBox
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
   
    
  @USERLOGSOUT
  Scenario: User logs out
    When user clicks on log out button
    Then user is logged out

  @RETURNTOHP
  Scenario: Return to HP
    When user clicks on brand logo
    Then user is navigated to home page
