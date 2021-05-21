Feature: Book

  
  Scenario Outline: positive Add To favorite
    Given open login in the chrome browser
    When enter the login details "<userName>","<password>"
    And i click Login button
    Then verify PopUp Message.
    And click on Book button in header
    Then page Url should be "http://localhost:4200/books"
    Then add book to favorite with title "<title>" 
    And verify book added successfully
    Then Click on the logout
    Then page Url should be "http://localhost:4200/register"
    And close the browser

    Examples: 
      | userName | password | title        |
      | username201   | pass201     | ROCK OF AGES |

  Scenario Outline: negative Add To favorite
    Given open login in the chrome browser
    When enter the login details "<userName>","<password>"
    And i click Login button
    Then verify PopUp Message.
    And click on Book button in header
    Then page Url should be "http://localhost:4200/books"
    Then add book to favorite with title "<title>" 
    And verify PopUp Message.
    Then Click on the logout
    Then page Url should be "http://localhost:4200/register"
    And close the browser

    Examples: 
      | userName | password | title        |
      | username201   | pass201     | ROCK OF AGES |
