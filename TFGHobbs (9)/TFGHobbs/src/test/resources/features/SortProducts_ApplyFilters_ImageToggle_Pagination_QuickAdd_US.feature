@P2_ALL_DESKTOP_PLP_US
Feature:SortProducts_ApplyFilters_ImageToggle_Pagination_QuickAdd_US
  Sort products,Apply filters,Image toggle,Pagination and Quick add to bag


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

 @CLICKONRANDOMNAVCATEGORY @LANDONPLP
  Scenario:  Click on random nav category and Land on PLP
    When user clicks on <SubCategory> from <MainCategory> category
    Then user is on <SubCategory> PLP

  @SORT_BY_PRICE_LOW_TO_HIGH
  Scenario: Sort by price Low to High
    When user selects sort option from the sort dropdown
      | Price - Low to High |
    Then products are sorted in low to high price

  @SORT_BY_PRICE_HIGH_TO_LOW
  Scenario: Sort by price high to low
    When user selects sort option from the sort dropdown
      | Price - High to Low |
    Then products are sorted in High to Low price

  @APPLY_SINGLE_FILTER_ON_PLP
  Scenario: Apply single filter on PLP
    When user applies a single filter of <FilterName> in <MainFilter> on PLP
      | MainFilter | FilterName |
      | COLOR     | Black    |
    Then <FilterName> filter is applied on PLP
      | FilterName |
      | Black      |

  @REMOVE_SINGLE_FILTER_ON_PLP
  Scenario: Remove single filter on PLP
    When user clicks on the cross icon of a single filter applied on PLP
    Then single filter is removed from applied filter on plp
     

  @APPLY_MULTIPLE_FILTER_ON_PLP
  Scenario: Apply multiple filter on PLP
    When user applies multiple filter of <FilterName> in <MainFilter> on PLP
      | MainFilter | FilterName |
      |   COLOR   | Blue       |
      |   PATTERN  | Plain      |

  @REMOVE_MULTIPLE_FILTER_ON_PLP
  Scenario: Remove multiple filter on PLP
    When user removes multiple filter from applied filter on PLP
      | FilterName  |
      | Blue        |
      | Plain       |

  @APPLY_ALL_FILTERS_ON_PLP
  Scenario: Apply all  filters on PLP
    When user applies all filters <FilterName> in <MainFilter> on PLP
      | MainFilter  			 | FilterName   |
      | COLOR       			 | 	Blue	     		|
      | US SIZE            | 12           |
      | SLEEVE 						 | Long Sleeve  |
      | PATTERN       		 | Printed        |
      | FIT       				 | Regular      |
      | NECKLINE  				 | Shirt Collar |
      

 @REMOVE_ALL_FILTERS_ON_PLP
  Scenario: Remove all  filters on PLP
    When user clicks on clearAll filters 
    Then all applied filters are removed from plp

  @CLICK_ON_XX_ITEMS_PER_PAGE
  Scenario: Click on show XX items per page
    When user clicks on xx items per page
    Then user clicks on available items per page

 @CLICK_ON_NEXT_AND_PREVIOUS_PAGE
  Scenario: Click on next and previous page
    When user clicks on forward_arrow button
    Then user is on NEXT page
    When user clicks on backward_arrow button
    Then user is on PREVIOUS page

  @CLICK_ON_IMAGE_TOGGLE
  Scenario: Click model image toggle
    When user click on model image toggle 
    Then verify products on model image toggle 

  #@QUICK_ADD_TO_BAG_FROM_PLP
  #Scenario: Quick add to bag from PLP
    #When user clicks on image and select quick add option
    #And user select size and add to bag
    #Then user verify product in basket
      #
      #
  