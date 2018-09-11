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
Feature: Testing the creation of a letter for the group of people with data from XML
	@BasicFunctionality
  Scenario: Create email for the group of people with data from DB
    Given I am on main application page
    When I login as correct user
    And I click on the button create mail
    And I enter the recipients email address, more addresses as copyTo, subject of the email, body of the email with 2 from XML
    And I click on the button send mail
    Then I see message Your letter has been sent