@P2_ALL_MOBILE_ACCOUNT_ROW
Feature:Loginvalidation_Accountandforgotpasswordvalidation_ROW
  Login validations,create account and forgot password validations

 @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "ROW" in "Mobile"
    When user closes country selector gateway modal
    Then user is on home page for website "ROW"

 @COUNTRYSELECTOR
  Scenario: Country Selector
    Given user clicks on country selector button
    When user selects a "DE" from drop down list
    Then user is on to "DE" website


  @MY_ACCOUNT_ICON
  Scenario: Click on my account icon on header and lands on account page
    When user clicks on my account icon on header
    Then user is on Login or Register page

  @CREATE_ACCOUNT
  Scenario: Create account and login to account
    When user enters a valid Email account
    And clicks on Create account button
    Then user is on account register page
    And user enters registraion details
      | Title | First_Name | Last_Name | Password | Confirm_Password |
      | Miss  | Annabelle  | Freddie   | kripa223 | kripa223         |
    And user clicks on Agree & Continue button
    Then new account is created and user is on account management page

  @MY_ACCOUNT_ICON
  Scenario: Click on my account icon on header and lands on account page for login validations
    When user clicks on my account icon on header
    Then user is on Login or Register page

  @LAND_ON_ACCOUNT_LOGIN_PAGE
  Scenario: Login with incorrect password
    When user enters Email and Password
      | Email                     | Password     |
      | G10X_emily_g10x@gmail.com | 123susenmarq |
    And user clicks on signin button
    Then validating the error message for Invalid login password

  @LOGIN_WITH_BLANK_EMAIL
  Scenario: Login with blank email
    When user keeps Email blank
    And user enters Password
      | Password |
      | test@123 |
    Then signin button is disabled

  @LOGIN_WITH_BLANK_PASSWORD
  Scenario: Login with blank password
    When user enters Email address
      | Email                    |
      | G10X_emily_g10x@gmail.com|
    And user keeps Password blank
    Then signin button is disabled

  @CHECK_FORGOTTEN_PASSWORD
  Scenario: Check forgotten password
    When user enters Email address
      | Email                    |
      |G10X_emily_g10x@gmail.com |
    And clicks on Forgotten your password link
    Then user is on password reset page
    And user reset Email ID
      | Email                     |
      | G10X_emily_g10x@gmail.com |
    And clicks on send reset password email button
    Then account recovery email is send to registered mobile number

  @CHECK_FORGOTTEN_PASSWORD_INVALID_EMAIL
  Scenario: Check forgotten password invalid email
    When clicks on Forgotten your password link
    Then user is on password reset page
    And user reset Email ID
      | Email                |
      | susenmarq.gmail@.com |
    And clicks on send reset password email button
    Then please enter a valid email address error is thrown

  @LOGIN_WITH_INVALID_EMAIL
  Scenario: Login with invalid email
    When user clicks on my account icon on header
    Then user is on Login or Register page
    When user enters Email and Password
      | Email                | Password |
      | paul@exapmle.com     | test@123 |
      | susenmarq.gmail@.com | test@123 |
    And user clicks on signin button
    Then Please enter a valid email address error  is caught

  @LOGIN_WITH_A_VALID_ACCOUNT
  Scenario: Login with a valid account
    When user enters Email and Password
      | Email                     | Password   |
      | G10X_emily_g10x@gmail.com | test@123   |
    And user clicks on signin button
    Then user is on account management page

  @LOGOUT_FROM_ACCOUNT
  Scenario: Logout from account and lands on home page
    When user clicks on Logout button
    Then user logout from account page