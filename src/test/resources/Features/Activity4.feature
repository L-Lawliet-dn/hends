@activity4
Feature: DataTable Example

  Scenario: Login using a DataTable
    Given User is on Login page
    When User enters login credentials
      | username | password |
      | admin    | password |
    Then Read the page title and confirmation message
    And Close the Browser