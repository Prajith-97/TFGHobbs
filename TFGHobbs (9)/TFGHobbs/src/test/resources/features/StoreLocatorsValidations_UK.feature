@P3_ALL_DESKTOP_STORE_LOCATOR_UK
Feature:StoreLocatorsValidations_UK
  Positive and negative validations for store locators

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

  @CLICK_ON_STORE_LOCATOR
  Scenario: Click on store locator
    When user clicks on find a hobbs store link from the footer
    Then user is on store locator page
  
  #@NO_RESULT_SEARCH
  #Scenario: Try to run a null search
    #When user enters <Place> in the City field
      #| Place    |
      #| Sumburgh |
    #And user clicks on search button
     #Then validation error is thrown

  @SHOW_STORE_LIST
  Scenario: view all stores list
    When user enters a town in uk
      | Town |
      | w11  |
    And user clicks on search button
    Then user views all stores in the given town

  @INVALID_SEARCH
  Scenario: Try to run an invalid search
    When user enters a town
      | Town   |
      | Mumbai |
    And user clicks on search button
     Then user views all stores in the given town

  @ADDRESSD_SEARCH
  Scenario: Search for UK address in international websites
    When user selects a country
    And user enters <Place> in the City field
      | Address |
      | w11     |
    And user clicks on search button
    Then validation error is thrown

  @BLANK_SEARCH
  Scenario: Try to run a blank search
    When user selects a country
    And keeps the city blank
    And user clicks on search button
    Then validation error is thrown
