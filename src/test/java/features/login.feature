Feature: Login into Application

@RegressionTest
Scenario: Positive test validating login 
Given Innitialise browser with chrome
And Navigate to the "http://projects.teamgrowth.net/HMS-Rajebahadur/Login#NoBack" site
When User login with following details and clicked on the submit button
|Administrator		|Supp0rt#123	|
Then Verify that user is successfully login and Dashboard is displayed

@RegressionTest
Scenario Outline: Positive test validating login 
Given Innitialise browser with chrome
And Navigate to the "http://projects.teamgrowth.net/HMS-Rajebahadur/Login#NoBack" site
When User login with following details <username> and <password> and clicked on the submit button
Then Verify that user is successfully login and Dashboard is displayed

Examples:
|username			|password		|
|Administrator		|Supp0rt#123	|
|jitendra			|123456			|


@SmokeTest
Scenario Outline: Add enquiry
Given Innitialise browser with chrome
And Navigate to the "http://projects.teamgrowth.net/HMS-Rajebahadur/Login#NoBack" site
When User login with following details and clicked on the submit button
|Administrator		|Supp0rt#123	|
And Go to Enquiry from Drawer menu
And Add Enquiry Enter all the details <patientName> and <descriptionField> and <addressField> and <contact1> and <contact2> and clicked on submit button
Then Verify that user is successfully added the enquiry

Examples:
|patientName 		|descriptionField 	    |addressField	    	|contact1 	    	|contact2|
|Jitedra Battise    |Test Description field |Test Address Field     |9049392142         |9823115986|




	
