Feature: Account Registration
  
  #@regression
  Scenario: Successful Account Registration
    Given the user navigates to Register Account Page
    When the user enters the details into below fields
    	|firstname|John1|
    	|lastname|Kenedy1|
    	|email|johnkenedy2@gmail.com|
    	|telephone|1234567891|
    	|password|test@120|
    	|confirmpassword|test@120|
    And the user selects Privay Policy	
    And the user clicks on Continue button
    Then the user account should get created successfully
