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
@vkcom
Feature: Save profile info vk.com

  Scenario: Save profile info vk.com
    Given I want to save my profile info vk.com: bdate_visibility 2, home_town "8888877777", status "8888877777"    
    When I get my profile info vk.com
    Then I validate the saving Info and getting Info