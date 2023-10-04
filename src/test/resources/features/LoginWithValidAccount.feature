@login
Feature: Home page to Login

  Background:
    Given I am at the Homepage
    And I will click the Login page
    When I will click the Login page
    Then Should be at Login page and Click the Email section

  Scenario Outline: Login using registered account
    Given I enter a "<validEmail>" address and a "<validPassword>"
    And Click the hidden eye button
    When I will click the Login button
    Then Gee-test will prompt
    And I quit the Driver
    Examples:
      | validEmail                      | validPassword         |
      | bibvip.mananabas@gmail.com | Admin@1234567890 |
