@P2_ALL_DESKTOP_PDP_UK
Feature:BreadcrumbNavigation_AddRemoveWishlist_ViewProductImage_UK
  User clicks on breadcrumb,add to wishlist and remove from wishlist ,image click and review click

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

   @SEARCHPRODUCTFROMHOMEPAGE @LANDONPDP
   Scenario:  Search Product in Homepage and Land on PDP
   Given user searches for product from HomePage and lands on PDP  
   When user selects the products from PLP
   Then user is on PDP page

  @CLICK_ON_REVIEW_BUTTON
  Scenario: Click the review button
   When user clicks on the review button
   Then user is on review panel

  @CLOSE_REVIEW_PANEL
  Scenario: Close review panel
    When user clicks on close button of the review panel
    Then review panel is closed

  @CLICK_OUT_OF_PANEL
  Scenario: Click out of review panel
    When user clicks on the review button
    Then user is on review panel
    When user clicks out of review panel
    Then review panel is closed

  @ADD_TO_WISHLIST
  Scenario: Click add to wishlist
    When user clicks on the wishlist button
    Then product is added to wishlist

  @REMOVE_FROM_WISHLIST
  Scenario: Click remove from wishlist
    When user clicks on the selected wishlist button
    Then Product is removed from wishlist

  @CLICK_THE_LARGE_IMAGE
  Scenario: Click the large image
    When user clicks on the  selected product image
    #Then product image is expanded
#
  #@BREADCRUMBLINK
  #Scenario: Click on each breadcrumb link
    #When user clicks on breadcrumb link for maincategory
    #Then user is on PLP
    #When user clicks on breadcrumb link for Home
    #Then user is on home page
