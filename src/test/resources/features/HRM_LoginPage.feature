@all @login
Feature: Orange HRM login feature
  I want to test login functionality of Orange HRM login functionality

  @tag1
  Scenario Outline: Orange HRM Login Scenario
    Given User is on application login page
    When User login using userid as "<username>" and password as "<password>"
    Then User should be get "<expectedResult>" login status
    Examples:
    |username	|password	|ExpectedResult										|
    |Admin			|admin123|Dashboard													|
    |Admin			|								|Password cannot be empty	|
    |								|admin123	|Username cannot be empty	|
    |								|admin			|Username cannot be empty	|
    |								|								|Username cannot be empty	|
