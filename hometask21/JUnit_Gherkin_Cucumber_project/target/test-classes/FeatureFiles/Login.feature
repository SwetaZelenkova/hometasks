#Author: lana_zelenkova@tut.by
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
@FunctionalTests
Feature: login page functionality

	Background: 
		Given I am on main application page
	@SmokeTests	
	Scenario: valid login test
    When I login as correct user
    Then I see logout link
	@SmokeTests
  Scenario Outline: invalid login test
    When I login as user with "<name>" and "<domain>" and "<password>"
    Then I see error message
    Examples: 
      | name            | domain | password    |
      | zelenkova-sveta | @bk.ru | Benzz2503   |
      | zelenkova_sveta | @bk.ru | Benz2503    |
