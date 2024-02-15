@P2_ALL_MOBILE_NAVIGATION_ROW
Feature:BurgerNavValidation_ROW
  Tap on burger-nav and close burger-nav


  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "ROW" in "Mobile"
    When user closes country selector gateway modal
    Then user is on home page for website "ROW"

@COUNTRYSELECTOR
  Scenario: Country Selector
    Given user clicks on country selector button
    When user selects a "US" from drop down list
    Then user is on to "US" website

  @TAPONBURGERNAV
  Scenario: Tap on burger nav
    When user clicks on burger menu
    Then subnav panel is opened

  @CLOSE_BURGERNAV
  Scenario: Close burger nav
    When user clicks on X close button
    Then burger menu closed

    