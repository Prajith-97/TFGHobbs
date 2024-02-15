@P2_ALL_MOBILE_NAVIGATION_UK
Feature:BurgerNavValidation_UK
  Tap on burger-nav and close burger-nav

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "UK" in "Mobile"
    When user closes country selector gateway modal
    Then user is on home page for website "UK"

  @TAPONBURGERNAV
  Scenario: Tap on burger nav
    When user clicks on burger menu
    Then subnav panel is opened

  @CLOSE_BURGERNAV
  Scenario: Close burger nav
    When user clicks on X close button
    Then burger menu closed

    