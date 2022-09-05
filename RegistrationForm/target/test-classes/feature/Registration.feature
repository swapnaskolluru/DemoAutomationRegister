Feature: Registration

	Scenario: To verify that the user is able to Register on the click of Submit button
		Given I enter URL
		When I enter Full Name
		And I enter Address
		And I enter Email address
		And I enter Phone number
		And I select Gender
		And I select Hobbies
		And I select Languages
		And I select Skills
		And I enter Country
		And I select Country
		And I select Date Of Birth
		And I enter Password
		And I enter Confirm Password
		Then I click on Submit 
		And I quit 
	
	Scenario: To verify the Refresh button clears all the filled in data
		Given I enter URL
		When I enter Full Name
		And I enter Address
		And I enter Email address
		And I enter Phone number
		And I select Gender
		And I select Hobbies
		And I select Languages
		And I select Skills
		And I enter Country
		And I select Country
		And I select Date Of Birth
		And I enter Password
		And I enter Confirm Password
		Then I click on Refresh
		Then I click on Submit 
		And I verify First Name is blank
		And I quit

	Scenario: To verify the media link on the page footer
		Given I enter URL
		When I click on Facebook link
		Then I verify Facebook page is opened
		And I quit	