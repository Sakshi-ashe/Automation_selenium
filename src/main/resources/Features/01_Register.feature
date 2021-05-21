#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template



 @tag
Feature: Register Feature
  @tag1
  Scenario Outline: Multiple Value Test
    Given Open the web page in the chrome browser
    When Enter details "<userName>","<email>","<password>","<name>"
    And I click the Register button
    Then Verify the PopUp.

    Examples: 
  |userName    | email       | password | name    |
  |username201 | abc@bcd.com | pass201  | name201 |
  |username202 | abd@bcw.com | pass202  | name202 |
  |username203 | abr@bcr.com | pass203  | name203 |
  
 