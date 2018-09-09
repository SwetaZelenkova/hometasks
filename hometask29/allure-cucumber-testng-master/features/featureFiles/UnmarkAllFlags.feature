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
Feature: Uncheck flag from the email
	@GorillaTests
  Scenario: Uncheck flag from the email
    Given I am on main application page
    When I login as correct user
    And I click on the button filter the emails marked with a check mark
    And I choose all emails
    And I click on the button more actions
    And I click on the uncheck the flag link
    Then I see message no emails that fall under the filter conditions
