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
Feature: Web Test
  I want to use this template for Web Test

  @tag1
  Scenario: User can search for the web site and Click link
    Given a user goes to google
    And search for HPE
    When he clicks on the link
    Then the page should appear 

  @tag2
  Scenario: Login to Flight management Successfully
    Given Navigate to Flight management site
    And Enter Username as Mercury
    And Enter Password as Mercury
    When user click on login button
    Then navigate to next page

  @tag3
  Scenario: User should be able to book ticket
    Given User is on Find Flight page
    When user select the  Flight Details
    And Select the Preferences for the flight
    And then click on continue
    Then user must be directed to Select Flight page
    And Select the Depart plane
    And Select the Return plan
    And Click on Continue button
    Then User must be directed to Book a flight page
    And Verify the Flight details
    And enter the Passenger Details
    And enter the Credit card details
    And Click on secure purchase button
    Then User must be  directed to Flight confirmation page
    And Click on Log out button
    And User will be directed to Sign on page
