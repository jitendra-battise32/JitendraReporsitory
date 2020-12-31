package stepDefinations;
import java.util.List;

//import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.junit.Cucumber;
import pageObjectPF.AddEnquiry;
import pageObjectPF.LoginPage;
import resources.base;

//@RunWith(Cucumber.class)
public class stepDefination extends base{

	
	@Given("^Innitialise browser with chrome$")
    public void innitialise_browser_with_chrome() throws Throwable {
        //throw new PendingException();
    	driver = initialisationBrowser();
    	driver.manage().window().maximize();
    }
	
    @When("^User login with following details and clicked on the submit button$")
    public void user_login_with_following_details_and_clicked_on_the_submit_button(DataTable data) throws Throwable {
       // throw new PendingException();
       	 List<List<String>> obj = data.asLists();
    	 String username = obj.get(0).get(0);
    	 String password = obj.get(0).get(1);
         LoginPage lp = new LoginPage(driver);
         lp.usernameMethod().sendKeys(username);
         lp.passwordMethod().sendKeys(password);
         lp.loginButtonMethod().click();
    }

    @Then("^Verify that user is successfully login and Dashboard is displayed$")
    public void verify_that_user_is_successfully_login_and_dashboard_is_displayed() throws Throwable {
     //   throw new PendingException();
        LoginPage lp = new LoginPage(driver);
	    String actualTitle = lp.getTitleMethod().getText();
 	    Assert.assertEquals(actualTitle,"DashBoard");
     	Assert.assertTrue(lp.getTitleMethod().isDisplayed());
     //	driver.close();
 	
    }
    

    @When("^User login with following details (.+) and (.+) and clicked on the submit button$")
    public void user_login_with_following_details_and_and_clicked_on_the_submit_button(String username, String password) throws Throwable {
       // throw new PendingException();
    	LoginPage lp = new LoginPage(driver);
        lp.usernameMethod().sendKeys(username);
        lp.passwordMethod().sendKeys(password);
        lp.loginButtonMethod().click();
   }
    

    @And("^Navigate to the \"([^\"]*)\" site$")
    public void navigate_to_the_something_site(String strArg1) throws Throwable {
        //throw new PendingException();
    	driver.get(strArg1);
    }
   // Enquiry
    
 //   @After("@SmokeTest")
    @Then("^Verify that user is successfully added the enquiry$")
    public void verify_that_user_is_successfully_added_the_enquiry() throws Throwable {
      //  throw new PendingException();
    	
    	   AddEnquiry En = new AddEnquiry(driver); 
    	   En.successMessageMethod().getText();
   	       System.out.println( En.successMessageMethod().getText());
    }

    @And("^Go to Enquiry from Drawer menu$")
    public void go_to_enquiry_from_drawer_menu() throws Throwable {
      //  throw new PendingException();
    	
    	
	    AddEnquiry En = new AddEnquiry(driver);
	    
	    En.drawerMenuMethod();
	    Thread.sleep(3000);
	    En.enquiryButtonMethod().click();
	    String titleEnq = En.veriftTitltleEnMethod().getText();
	    Assert.assertEquals(titleEnq, "Enquiry List");
	    En.AddEnquiryButtonMethod().click();
    }

    @And("^Add Enquiry Enter all the details (.+) and (.+) and (.+) and (.+) and (.+) and clicked on submit button$")
    public void add_enquiry_enter_all_the_details_and_and_and_and_and_clicked_on_submit_button(String patientname, String descriptionfield, String addressfield, String contact1, String contact2) throws Throwable {
    
    	  AddEnquiry En = new AddEnquiry(driver);
    	  En.personNameMethod().sendKeys(patientname);
  	      En.doctorMethod();   
  	      Thread.sleep(3000);
  	      En.descriptionMethod().sendKeys(descriptionfield);
  	      En.AddressMethod().sendKeys(addressfield);
  	      En.contactNo1Method().sendKeys(contact1);
  	      En.contactNo2Method().sendKeys(contact2);
  	      En.enquirySaveMethod().click();
   }
    
}

