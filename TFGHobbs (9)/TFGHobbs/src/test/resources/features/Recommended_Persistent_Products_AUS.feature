@P3_ALL_DESKTOP_BASKET_AUS
Feature:Recommended_Persistent_Products_AUS
  purchase products ,select recommended products and check persistent products

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "AU" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "AU"


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
    
  @RECOMMENDATIONS
  Scenario: Recommendations display
    When user scrolldowns from the basket page to view the recommended products
    Then user views the recommended products

  @PERSISTENT_PRODUCTS
  Scenario: Change country and retain products
    When user clicks on the country icon from the header
    Then user is on country panel
    When user selects a "DE" from drop down list
    Then user is on to "DE" website
    And user clicks on the bag icon from the header
    And user is on basket page
    Then user views the  products available for the current selected "DE"
