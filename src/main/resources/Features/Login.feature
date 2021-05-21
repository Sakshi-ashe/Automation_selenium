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
Feature: Login Feature
  @tag2
  Scenario Outline: Multiple Value Test
    Given Open the login in the chrome browser
    When Enter login details "<userName>","<passwrod>"
    And I click the Login button
    Then Verify the PopUp Message.

    Examples: 
  |userName    | password | 
  |username201 | pass201  | 
  |username202 | pass202  |
  |username203 | pass203  | 
  