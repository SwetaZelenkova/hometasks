Feature: Test search page

  Scenario Outline: Test positive search on the page
    Given I am on main application page
    When I enter in search field "<query>"
    And I click on a button to search 
    Then I see on the page list of links with results "<result>"
    Examples: 
      | query            | result   |
      | Валерий Харламов | Харламов |
      | Владимир Путин   | Путин    |