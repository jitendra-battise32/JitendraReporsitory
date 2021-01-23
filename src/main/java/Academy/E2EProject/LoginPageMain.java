package Academy.E2EProject;

import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.AddEnquiry;
import pageObjectPF.IPDReg;
import pageObjectPF.LoginPage;
import pageObjectPF.OPDRegistration;

import pageObjectPF.ipdDetails;

import pageObjectPF.loginAsDoctorAttendPatient;
import resources.ExtentReporterNG;
import resources.Xls_Reader;
import resources.base;

public class LoginPageMain extends base { 
//The extends keyword extends a class (indicates that a class is inherited from another class).

	//public WebDriver driver;
ExtentTest test;
ExtentReports extent = ExtentReporterNG.getReportObject();

	
    @BeforeTest 
    
    public void before() throws IOException {
    	driver = initialisationBrowser();
  	
	    String urls = prop.getProperty("url");
	    driver.get(urls);
    	
	    driver.manage().window().maximize();
    }

	
	@Test(priority = 0)
        public void login() throws IOException, InterruptedException {
		
	try {
		    Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
		  
		    
		   
		    
		    
			String username = reader.getCellData("LoginCredentials","Username", 2);
            String password = reader.getCellData("LoginCredentials","Password", 2);
    	
		    LoginPage lp = new LoginPage(driver);
	        lp.usernameMethod().sendKeys(username);
	        lp.passwordMethod().sendKeys(password);
	        
     	    lp.loginButtonMethod().click();
            String actualTitle = lp.getTitleMethod().getText();
     	    Assert.assertEquals(actualTitle,"DashBoard");
         	Assert.assertTrue(lp.getTitleMethod().isDisplayed());
	}
	
	catch(Exception e) {
		 System.out.println("Something Went Wrong in Login");
		 System.out.println(e.getMessage());
	//	 System.out.println(e.getStackTrace());
		 test.fail(e);
         Assert.fail();
         extent.flush();
		
		}
         }

	
	
    @AfterTest 
    public void after() {
    //	driver.close();
    }

}
