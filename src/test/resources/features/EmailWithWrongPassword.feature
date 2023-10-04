@login
Feature: Home page to Login

  Background:
    Given I am at the Homepage
    And Click the X button
    When I will click the Login page
    Then Should be at Login page and Click the Email section

  Scenario Outline: Login using wrong Account password
    Given I enter a "<validEmail>" address and a "<invalidPassword>"
    And Click the hidden eye button
    When I will click the Login button
    And Gee-test will prompt
    Then The prompt of wrong password will show
    And I quit the Driver
    Examples:
      | validEmail                 | invalidPassword     |
      | bibvip.mananabas@gmail.com | Admin@12345678901 |