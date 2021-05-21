Feature: Favorite

  Scenario Outline: positive Remove From favorite
    Given open the login in the chrome browser
    When enter login details "<userName>","<password>"
    And i click the Login button
    Then verify the PopUp Message.
    And click on Favorite button in header
    Then Page Url should be "http://localhost:4200/favourite"
    Then remove book from favorite with title "<title>"
    And verify book removed successfully
    Then Click on logout
    Then Page Url should be "http://localhost:4200/register"
    And close browser

    Examples: 
      | userName | password | title        |
      | user15   | pass     | ROCK OF AGES |

  Scenario Outline: negative Remove From favorite
    Given open the login in the chrome browser
    When enter login details "<userName>","<password>"
    And i click the Login button
    Then verify the PopUp Message.
    And click on Favorite button in header
    Then Page Url should be "http://localhost:4200/favourite"
    And verify book with title "<title>" already absent
    Then Click on logout
    Then Page Url should be "http://localhost:4200/register"
    And close browser

    Examples: 
      | userName | password | title        |
      | user15   | pass     | ROCK OF AGES |
