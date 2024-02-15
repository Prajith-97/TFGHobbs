@P3_ALL_DESKTOP_EMPTYBASKET_US
Feature:EmptybasketValidation_US
  Verifying empty basket

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

  @EMPTY_BAG
  Scenario: Click on bag icon and verify empty basket
    When user clicks on the bag icon from the header
    Then user is on basket page and views the empty basket
