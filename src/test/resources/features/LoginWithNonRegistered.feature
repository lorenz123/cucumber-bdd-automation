@login
Feature: Home page to Login

  Background:
    Given I am at the Homepage
    And Click the X button
    When I will click the Login page
    Then Should be at Login page and Click the Email section

  Scenario Outline: Login using non-registered account
    Given I enter a "<nonRegisteredEmail>" address and a "<validPassword>"
    And Click the hidden eye button
    When I will click the Login button
    And Gee-test will prompt
    Then The prompt of non-registered email will show
    And I quit the Driver
    Examples:
      | nonRegisteredEmail          | validPassword         |
      | lorenzburat@gmail.com | Admin@1234567890 |