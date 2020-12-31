package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectPF.AddEnquiry;
import pageObjectPF.LoginPage;
import resources.base;

public class AddEnquiryMain extends base {
  
	public WebDriver driver;
	
	
	@BeforeTest
	
	public void before() throws IOException{
		
		driver = initialisationBrowser();
	    String urls = prop.getProperty("url");
	    driver.get(urls);
	    driver.manage().window().maximize();
		}
	
	
	@Test(dataProvider ="getData")
    public void enquiryAdd(String user, String pass) throws IOException, InterruptedException {

	    LoginPage lp2 = new LoginPage(driver);
	    
	    lp2.usernameMethod().sendKeys(user);
	    lp2.passwordMethod().sendKeys(pass);
     	lp2.loginButtonMethod().click();
     	Thread.sleep(3000);
     	
     	
	    AddEnquiry En = new AddEnquiry(driver);
	    
	    En.drawerMenuMethod();
	    Thread.sleep(3000);
	    En.enquiryButtonMethod().click();
	    String titleEnq = En.veriftTitltleEnMethod().getText();
	    Assert.assertEquals(titleEnq, "Enquiry List");
	    En.AddEnquiryButtonMethod().click();
	    En.personNameMethod().sendKeys("Jitendra Battise");
	    En.doctorMethod();   
	    Thread.sleep(3000);
	    En.descriptionMethod().sendKeys("Test Description Field");
	    En.AddressMethod().sendKeys("Test Address Field");
	    En.contactNo1Method().sendKeys("9049392143");
	    En.contactNo2Method().sendKeys("9823115988");
	    En.enquirySaveMethod().click();
	    En.successMessageMethod().getText();
	    System.out.println( En.successMessageMethod().getText());
}
	
	  @DataProvider
	    public Object[][] getData() {
	    	//row stands for the how many different data type should run
	    	//column stands for the how many values per each test
	    	Object[][] data = new Object[1][2];
	    	//[2][2];
	    	//Row is 0,1  so total is 2 thats why [2][2] is given
	    	//Column is 0,1 so total is 2  thats why [2][2] is given
	    	//0th row
	    	data[0][0] = "Administrator";
	    	data[0][1] = "Supp0rt#123";
	    	
	    	//2nd row
	    	//data[1][0]= "Test";
	    //	data[1][1]= "Supp0rt#123";
	    	
	    	//As we provide every time username and password then script will run multiples time
	    	//Here we have provided 2 data then script will run 2 times
	    		
	    	
	    	return data;
	    }

	  
	  @AfterTest
	  public void after() {
		  
		  driver.close();
		  
	  }
	
}