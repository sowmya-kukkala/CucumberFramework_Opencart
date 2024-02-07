Feature: Login with Valid Credentials

	@sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given the user navigates to login page
    When  user enters email as "sowmyak@gmail.com" and password as "qwerty@123"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page
    
  #@regression
  #Scenario Outline: Login DataDriven
  #	Given the user navigates to login page
  #	When user enters email as "<email>" and password as "<password>"
  #	And the user clicks on the Login button
  #	Then the user should be redirected to the MyAccount Page
  #	
  #	Examples:
  #		|email						|password  |
  #		|sowmya@gmail.com |qwerty123 |
  #		|sowmyak@gmail.com|qwerty@123|

