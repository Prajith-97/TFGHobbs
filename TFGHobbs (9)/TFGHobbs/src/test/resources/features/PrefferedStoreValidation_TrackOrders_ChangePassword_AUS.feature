@P3_ALL_DESKTOP_ACCOUNT_AUS
Feature:PrefferedStoreValidation_TrackOrders_ChangePassword_AUS
  Add and remove preffered store,track orders,change password

  @LANDONHOMEPAGE
  Scenario: Land on Home page
    Given website HOBBS url is launched for "AUS" in "Desktop"
    When user closes country selector gateway modal
    Then user is on home page for website "AUS"

 @MY_ACCOUNT_ICON
  Scenario: Click on my account icon on header and lands on account page
    When user clicks on my account icon on header
    Then user is on Login or Register page

  @CREATE_ACCOUNT_INVALI_EMAIL
  Scenario: Attempt to create an account with a bad email address
    When user enters email address to create Account
      | Email                   |
      | g10Xtestg10x.com@gmail78 |
    And clicks on Create account button
    Then please enter a valid email address error is thrown

  @CREATE_ACCOUNT_EXISTING_EMAIL
  Scenario: Attempt to create an account with an existing email address
    When user enters email address to create Account
      | Email                    |
      | G10X_test_G10X@gmail.com |
    And clicks on Create account button
    Then email address already in use error is thrown

  @Create_accoentersunt_and_login_to_account
  Scenario: Create account and login to account
    When user enters a valid Email address
    And clicks on Create account button
    Then user is on account register page
    And user enters registraion details
      | Title | First_Name | Last_Name | Password   | Confirm_Password |
      | Miss  | Olivia     | Dixon     | olivia@123 | olivia@123       |
    And user clicks on Agree & Continue button
    Then new account is created and user is on account management page

  @MY_ACCOUNT_ICON
  Scenario: From login page click on my account icon on header and lands on account page
    When user clicks on my account icon on header
    Then user is on Login or Register page

  @Login_with_a_valid_account
  Scenario: Login with a valid account
    When user enters  valid email and password
      | password   |
      | olivia@123 |
    And user clicks on signin button
    Then user is on account management page

#not applicable for non Uk regions
  #@PREFER_STORE_ADD
  #Scenario: Add a preferred store
    #When user clicks on preference centre button
    #Then user is on Account-preference page
    #When user enters prefered town
      #| Town      |
      #| Greenwich |
    #And user selects "EDINBURGH, 47 GEORGE STREET" from the  address dropdown
    #And user clicks on add a preferred store button
    #Then preferred store is added to the site
#
  #@PREFER_STORE_CHANGE
  #Scenario: Change preferred store
    #When when user clicks on the change button from Account-preference page
    #And user enters prefered town
      #| Town     |
      #| White Plains|
    #And user selects "ABERDEEN, 17/18 BON ACCORD CTR GEORGE ST" from the  address dropdown
    #And user clicks on add a preferred store button
    #Then preferred store is added to the website
#
  #@PREFER_STORE_REMOVE
  #Scenario: Remove preferred store
    #When user clicks on the remove choice button from Account-preference page
    #Then preferred store is removed from the website

   @CHANGE_PASSWORD
  Scenario: Attempt to change password
    When user clicks on update details button
    Then user is on account details page
    And user enters current password and new password
      | current_password | New_password |
      | olivia@123       | olivia@123A  |
    And user confirms the new password
      | Confirm_password |
      | olivia@123A      |
    And user clicks on save changes button
    Then user is on account management page

  @UPDATE_DETAILS
  Scenario: Attempt to update details
    When user clicks on update details button
    Then user is on account details page
    And user updates title and Mobile number
      | Mobile_Number |
      |    4481298985 |
    And enters password
      | Password    |
      | olivia@123A |
    And clicks on save changes button
    Then user is on account management page

  @LOGOUT_FROM_ACCOUNT
  Scenario: user logs out
    When user clicks on the Log out button from the account management page
    Then user is logged out from account management page

  @MY_ACCOUNT_ICON
  Scenario: CClick on my account icon on header and lands on account page to track order
    When user clicks on my account icon on header
    Then user is on Login or Register page


  @TRACK_ORDER
  Scenario: Attempt to track an order
    When user enters <Order number><Order email> and <Billing postcode>
      | Order number			 | Order email    		     | Billing postcode |
      | 32395504, 60031032 | G10X_catherine@gmail.com | L7 0LR          |
    And clicks on view status button
    Then user is on order tracking page



  @MY_ACCOUNT_ICON
  Scenario: Click on my account icon on header and lands on account page to view orders
    When user clicks on my account icon on header
    Then user is on Login or Register page

  @LOGIN_WITH_A_VALID_ACCOUNT
  Scenario: Login with valid account
    When user enters Email and Password
      | Email            			   | Password   |
      | G10X_test_G10X@gmail.com | test@123 	|
    And user clicks on signin button
    Then user is on account management page

  @ORDER_DETAILS_VIEW
  Scenario: Click order details button on account management page
    When user clicks on view orders button
    Then user views the order details

  @UPDATE_CARD_DETAILS
  Scenario: Attempt to update card details
    When user clicks on the edit payment and billing option
    Then user is on account payment page
    And user clicks on edit address option
    And user updates the current details in the card
      | city     |
      | Birstall |
    And clicks on save card details button
    Then user is on account payment page