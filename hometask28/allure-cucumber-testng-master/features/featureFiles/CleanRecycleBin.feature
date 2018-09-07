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
Feature: recycle bin functionality
	@AdditionalFunctionality
	Scenario: recycle bin cleaning test
		Given I am on main application page
    When I login as correct user
    And I click on the link recycle bin
    And I click on the button clean all
    And I click on the button for confirm
    Then I see message your recycle bin is empty