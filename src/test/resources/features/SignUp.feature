@signup
Feature: Signing Up to the fucking website

  Background:
    Given I am at the Sign Up page

  Scenario Outline: Negative Test - Sign Up with a non-valid email
    Given I enter a invalid "<invalidEmail>" address and a valid "<validPassword>"
    When I click the Sign Up button
    Then An error message should be prompted to the user
    And I quit the Driver
    Examples:
      | invalidEmail                 | validPassword     |
      | bibvip.mananabasgmail.com | Aaaa1234# |