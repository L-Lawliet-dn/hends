@activity3
Feature: Testing with Tags

  Scenario: Testing with Simple Alert
    Given User is on JavaScript Alerts page
    When User opens the Simple Alert
    Then User reads the Simple Alert text
    And User accepts the Simple Alert

  Scenario: Testing with Confirm Alert
    Given User is on JavaScript Alerts page
    When User opens the Confirm Alert
    Then User reads the Confirm Alert text
    And User accepts the Confirm Alert

  Scenario Outline: Testing with Prompt Alert
    Given User is on JavaScript Alerts page
    When User opens the Prompt Alert
    And User enters "<message>" in the Prompt Alert
    Then User reads the Prompt Alert text
    And User accepts the Prompt Alert

    Examples:
      | message           |
      | Hello Cucumber    |
      | Testing Prompt    |