@P2_ALL_DESKTOP_BASKET_US
Feature:BasketUpdateAndValidation_ApplyPromocode_US
  User update quantity and size,apply promocode,move to wishlist,remove from bag

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
  Scenario:  Search Product from Homepage and Move to PDP
    Given user searches for product from HomePage and lands on PDP
    When user selects the products from PLP
    Then user is on PDP page

  @ONPDPSELECTRANDOMSIZE
  Scenario:  From PDP select random size for the selected product
    When user selects randon size for the product
    Then user clicks add to bag button on PDP

  @GOTOBAGPAGE
  Scenario: Move to bag page
    When user clicks on view bag
    Then user is on basket page
    
  @APPLY_INVALID_PROMOCODE
  Scenario: Apply invalid promocode
    When user enters invalid promocode
      | Promocode |
      | 456A      |
    And user clicks on Apply button
    Then Coupon cannot be added to your cart error message is thrown
    
  @APPLY_VALID_PROMOCODE
  Scenario: Apply valid promocode
    When user  enters promocode
      | Promocode |
      | G10X      |
    And user clicks on Apply button
    Then promocode is applied