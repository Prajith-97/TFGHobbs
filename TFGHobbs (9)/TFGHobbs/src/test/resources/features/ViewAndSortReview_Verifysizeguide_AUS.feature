@P3_ALL_DESKTOP_PDP_AUS
Feature:ViewAndSortReview_Verifysizeguide_AUS
  Sort reviews,click on size guide,load more reviews and cick on accordion


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
    
  @SWATCH_CLICK
  Scenario: Click the swatches in PDP
    When user clicks on the swatches
    Then color of the selected product is changed
    
  @REVIEW_SORT
  Scenario: Sort reviews in PDP
    When user clicks on the review button
    Then user is on review panel
    And user sorts the ratings

  @LOADMORE_REVIEWS
  Scenario: Load more reviews
    When user clicks the Loadmore button from the review panel
    Then more reviews are loaded in review panel

  @CLOSE_REVIEW_PANEL
  Scenario: Close review panel
    And user clicks on close button
    Then review panel is closed

  @CLICK_OUT_OF_PANEL
  Scenario: Click out of review panel
    When user clicks on the review button
    Then user is on review panel
    When user clicks out of review panel
    Then review panel is closed

  @CLICK_SIZEGUIDE
  Scenario: Click size guide link
    When user clicks on size guide link
    Then size guide tables are displayed in panel

  @SIZE-GUIDE_CLOSE
  Scenario: Close size guide panel
    When user clicks the close button on the size guide panel
    Then size guide panel is closed

  @ACCORDIONMENU_OPEN
  Scenario: Click the accordion link
    When user clicks on Delivery and Returns button
    Then user is on Delivery and Returns panel

  @ACCORDIONMENU_CLOSE
  Scenario: Click the accordion link a second time
    When user clicks on the X close button in delivery and returns panel
    Then delivery and return panel is closed

  @RECPRODUCT_CLICK
  Scenario: Click product on recommendations
    When user clicks on the recommended product
    Then user is on PDP
