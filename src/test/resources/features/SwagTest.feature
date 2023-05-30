
@swag
Feature: Login Functionality
  User Story:
  As a User, the user should be able to login with credentials to different accounts. And log out.
  Valid Accounts are: standard_user, problem_user, performance_glitch_user
  Invalid Accounts are: locked_out user

  Background: For all scenarios User is on the login page
    Given :User is on the login page

  @valid
  Scenario: Login as Standard User
    When User enters valid username "standard_user"
    Then User should see "Products" displayed on Products page

  @lockedUser
  Scenario: Login as locked out user
    When User enters locked out username "locked_out_user"
    Then "Epic sadface: Sorry, this user has been locked out." should be displayed

  @problemUser
  Scenario: Login as Problem User
    When User enters problem username "problem_user"
    Then User should not be able to add Sauce Labs Fleece Jacket

  @GlitchUser
  Scenario: Login as Performance glitch User
    When User enters username "performance_glitch_user"
    Then User should wait for five seconds to launch to Product page

  @unsuccess
  Scenario: Login with invalid credentials
    When User enters invalid username "incorrectUsername"
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
    When User enters valid username "standard_user"
    And User enters a blank password
    And User clicks on login button
    Then "Epic sadface: Password is required" message should be displaye


  @multipleUsers
  Scenario Outline: Validate all successful logins
    When User enters valid username "<username>"
    And User enters valid password "<password>"
    And User clicks on login button
    Then User should see "Products" displayed on Products page and log out


    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |


