package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.AddEnquiry;
import pageObjectPF.LoginPage;
import resources.ExtentReporterNG;
import resources.Xls_Reader;
import resources.base;

public class AddEnquiryMain extends base {
  
	public WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();

	@BeforeTest
	
	public void before() throws IOException{
		
		driver = initialisationBrowser();
	    String urls = prop.getProperty("url");
	    driver.get(urls);
	    driver.manage().window().maximize();
		}
	
	
	@Test//(dataProvider ="getData")
    public void enquiryAdd(/*String Username, String Password*/) throws IOException, InterruptedException {

		try {
		 Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
			
         //int rowCount = reader.getRowCount("LoginCredentials");
		 String username = reader.getCellData("LoginCredentials","Username", 2);
         String password = reader.getCellData("LoginCredentials","Password", 2);

		
	    LoginPage lp2 = new LoginPage(driver);
	    
	    lp2.usernameMethod().sendKeys(username);
	    lp2.passwordMethod().sendKeys(password);
     	lp2.loginButtonMethod().click();
     	Thread.sleep(3000);
     	
     	
     	 String personName = reader.getCellData("AddEnquiries","PersonName",2);
     	 String descrioptionField = reader.getCellData("AddEnquiries","DescriptionField",2);
     	 String addressField = reader.getCellData("AddEnquiries","AddressField",2);
       	 String contactNo1 = reader.getCellData("AddEnquiries","ContactNoOne",2);
    	 String contactNo2 = reader.getCellData("AddEnquiries","ContactNoTwo",2);
    	
        AddEnquiry En = new AddEnquiry(driver);
	    
	    En.drawerMenuMethod();
	    Thread.sleep(3000);
	    En.enquiryButtonMethod().click();
	    String titleEnq = En.veriftTitltleEnMethod().getText();
	    Assert.assertEquals(titleEnq, "Enquiry List");
	    En.AddEnquiryButtonMethod().click();
	    En.personNameMethod().sendKeys(personName);
	    En.doctorMethod();   
	    Thread.sleep(3000);
	    En.descriptionMethod().sendKeys(descrioptionField);
	    En.AddressMethod().sendKeys(addressField);
	    En.contactNo1Method().sendKeys(contactNo1);
	    En.contactNo2Method().sendKeys(contactNo2);
	    En.enquirySaveMethod().click();
	    En.successMessageMethod().getText();
	    System.out.println( En.successMessageMethod().getText());
		}
		
		catch(Exception e) {
			 System.out.println("Something Went Wrong in Enquiry Method");
			 System.out.println(e.getMessage());
		//	 System.out.println(e.getStackTrace());
			 test.fail(e);
	         Assert.fail();
	         extent.flush();
			}
	   	    
}
	
	/*  @DataProvider
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

	  */
	
	
	  @AfterTest
	  public void after() {
		  
		//  driver.close();
		  
	  }
	
}