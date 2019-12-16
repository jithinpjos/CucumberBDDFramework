@RegressionTesting
Feature: Validation of Google search result
Scenario: Google Page validation
    Given Open chrome browser and enter url 
    And Enter the Search text
    When Click on the Search button
    Then Click on the result and Validating the result page