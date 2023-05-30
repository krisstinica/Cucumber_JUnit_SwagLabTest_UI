
@swag
Feature: Login Functionality
  User Story:
  As a User, the user should be able to login with valid credentials to different accounts.
  Valid Accounts are: standard_user, problem_user, performance_glitch_user
  Invalid Accounts are: locked_out user

  User Story:
  As a User, the user with invalid credentials should not be able to login and see error message

  Background: For all scenarios User is on the login login
    Given :User is on the login login

  @valid
  Scenario: Login as Standard User
    When User enters valid password and username "standard_user"
    Then User should see "Products" displayed on Products login

  @lockedUser
  Scenario: Login as locked out user
    When User enters valid password and username "locked_out_user"
    Then "Epic sadface: Sorry, this user has been locked out." should be displayed

  @problemUser
  Scenario: Login as Problem User
    When User enters valid password and username "problem_user"
    Then User should not be able to add Sauce Labs Fleece Jacket

  @GlitchUser
  Scenario: Login as Performance glitch User
    When User enters valid password and username "performance_glitch_user"
    Then User should wait for five seconds to launch to Product login

  @unsuccess
  Scenario: Login with invalid credentials
    When User enters invalid password and username "incorrectUsername"
    Then Error message should be displayed

  @emptyFields
  Scenario: Login with an empty input in both fields
    When User enters a blank username
    And User enters a blank password
    And User clicks on login button
    Then "Epic sadface: Username is required" message should be displayed

  @emptyusernameField
  Scenario: Login with an empty username input field
    When User enters a blank username
    And User enters valid password "secret_sauce"
    And User clicks on login button
    Then "Epic sadface: Username is required" message should be displayed

  @emptypasswordField
  Scenario: Login with an empty password input field
    When User enters non-blank valid username "standard_user"
    And User enters a blank password
    And User clicks on login button
    Then "Epic sadface: Password is required" message should be displayed


  @multipleUsers
  Scenario Outline: Validate all successful logins
    When User enters valid userName "<username>"
    And User should see "Products" displayed on Products login
    Then User logs out


    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |

