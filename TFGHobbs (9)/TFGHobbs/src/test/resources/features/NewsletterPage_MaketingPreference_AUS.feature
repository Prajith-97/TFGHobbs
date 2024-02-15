@P2_ALL_DESKTOP_NEWSLETTER_AUS
Feature:NewsletterPage_MaketingPreference_AUS
  User lands on newsletter page,select marketing preference and enters mandatory info


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

  @SCROLLTOGLOBALFOOTER
  Scenario: Scroll to gobal footer
    When user scrolls down
    Then user is on  global footer

  @SIGNUPTONEWSLETTER
  Scenario: Signup news letter with invalid Email
    When user enters an invalid Email
      | Email                   |
      | @56$Eric67.@Johnson.com |
    And user clicks on signup button
    Then error message is thrown

  @SIGNUPTONEWSLETTERINVALID
  Scenario: Signup news letter with valid Email
    When user enters a valid Email
    And user clicks on signup button
    Then user is on news letter page

  @FAILEDMANDATORYINFO
  Scenario: Fail to enter mandatory info and signup
    When user keeps all the  mandatory fields empty
    Then Accept and continue button is disabled

  @MANDATORYINFO
  Scenario: Enter mandatory info
    When user selects the title from the title dropdown
    And user enters <Firstname> <Lastname>
      | Firstname | Lastname |
      | Eric      | Johnson  |
    And user clicks on Accept and continue button
    Then user is on next page

  @MARKETINGPREFERENCE
  Scenario: Tick a marketing preference and sign up
    Given user is on news letter page
    #When user ticks on i would like to receive texts from Hobbs about offers and promotions.
    #And user eneters a mobile number
      #| mobileNumber |
      #|   8281944382 |
    When user clicks on the Accept and continue button
    Then user is on the next page
