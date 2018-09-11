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
@FunctionalTests
Feature: testing the creation of a letter for the group of people
	@BasicFunctionality
  Scenario: a letter for the group of people
    Given I am on main application page
    When I login as correct user
    And I click on the button create mail
    And I enter the recipients email address
    And I enter more recipients email addresses "lana_zelenkova@tut.by", "nika.benz@tut.by"
    And I enter the subject of the email
    And I enter the body of the email
    And I click on the button send mail
    Then I see message Your letter has been sent
