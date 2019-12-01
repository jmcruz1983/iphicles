@test @price
Feature: Format price

  Scenario: Big list of naughty strings
    When Fetched list of naughty strings
    Then All prices should be NaN