@P2_ALL_DESKTOP_WISHLIST_US
Feature:GuestCustomer_ViewRemoveWishlist_AddToBagFromWishlist_US
  Guest customer view wishlist,remove wishlist,add to bag from wish list and load more wishlist items


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

  @VIEW_WISHLIST_AS_GUEST @VIEW_EMPTY_WISHLIST
  Scenario: view wishlist as guest and view empty wishlist as guest
    When user clicks on wishlist icon from header
    Then user is on wishlist page and views the empty wishlist

  @SEARCHPRODUCTFROMHOMEPAGE @LANDONPDP
  Scenario:  Search Product in Homepage and Land on PDP
  Given user searches for product from HomePage and lands on PDP  
  When user selects the products from PLP
  Then user is on PDP page

  @ONPDPSELECTRANDOMSIZE
  Scenario: Select random size on PDP
    When user selects randon size for the product
    Then selected size is applied to the product

  @ADDTO_WISHLIST
  Scenario: Add to wishlist
    When user clicks on the wishlist button
    Then product added to wishlist

  @CLICKON_WISHLIST_VIAHEADER
  Scenario: Click on wishlist via header
    When user clicks on wishlist icon from header
    Then user is on wishlist Page

  @REMOVE_FROM_WISHLIST
  Scenario: Attempt to remove from wishlist as guest
    When user clicks on close button of the product
    Then product is removed from wishlist

   @SEARCHPRODUCTFROMHOMEPAGE @LANDONPDP
  Scenario:  Search Product from Homepage and navigate to PDP
    Given user searches for product from HomePage and lands on PDP
    When user selects the products from PLP
    Then user is on PDP page


  @ADDTO_WISHLIST
  Scenario: Add to wishlist from PDP
    When user clicks on the wishlist button
    Then product added to wishlist

  @ADDTOBAG_FROM_WISHLIST
  Scenario: Attempt to add to bag from wishlist as guest
    When user clicks on wishlist icon from header
    And user selects the size from the size dropdown
    And user clicks on ADD button
    Then product is added to bag

  @CLICKONRANDOMNAVCATEGORY @LANDONPLP
  Scenario: Navigate to PLP by clicking on random nav category 
    When user clicks on <SubCategory> from <MainCategory> category
    Then user is on <SubCategory> PLP

   @LOADMORE
  Scenario: Click load more button on wishlist as guest
    When user adds products to wishlist from plp
    And user clicks on wishlist icon from header
    Then user is on wishlist Page
    And user clicks on load more button
    Then next set of products are loaded
