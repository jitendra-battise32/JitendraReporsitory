package Academy.E2EProject;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectPF.AddEnquiry;
import pageObjectPF.LoginPage;
import pageObjectPF.OPDRegistration;
import resources.Xls_Reader;
import resources.base;
public class LoginEnqOPD extends base {
	
	
public WebDriver driver;
	
	
    @BeforeTest 
    
    public void before() throws IOException {
    	driver = initialisationBrowser();
    	
	    String urls = prop.getProperty("url");
	    driver.get(urls);
	    driver.manage().window().maximize();
    }
    
    
    
    @Test
       public void loginMethod() throws IOException, InterruptedException {
        
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
    
    @Test
         public void enquiryAdd() throws IOException, InterruptedException {

		 Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
         String personName = reader.getCellData("AddEnquiries","PersonName",2);
    	 String descrioptionField = reader.getCellData("AddEnquiries","DescriptionField",2);
    	 String addressField = reader.getCellData("AddEnquiries","AddressField",2);
      	 String contactNo1 = reader.getCellData("AddEnquiries","ContactNoOne",2);
   	     String contactNo2 = reader.getCellData("AddEnquiries","ContactNoTwo",2);
   	
   	     Thread.sleep(3000);
   	     AddEnquiry En = new AddEnquiry(driver);
   	 	 Thread.sleep(3000);
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
    
    
    @Test
	
    public void OPDRegMethod() throws IOException, InterruptedException {

	 Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
		
  	OPDRegistration opd = new OPDRegistration(driver);
 	Thread.sleep(3000);
 	opd.DMMethod();
 	Thread.sleep(2000);
 	opd.OPDButtonMethod();
 	Thread.sleep(3000);
 	opd.AddOPDMethod().click();;
 	Thread.sleep(3000);
 	opd.enquiryNoMethod();
 	opd.patientDOBMethod();
 	opd.opdDateMethod();
 	opd.ageMethod().sendKeys("20");
 	opd.genderMethod();
 	
	String patientAdd = reader.getCellData("OPDRegistration","PatientAddress", 2);
    String presentAdd = reader.getCellData("OPDRegistration","PresentAddress", 2);
	
 	opd.patientAddressMethod().sendKeys(patientAdd);
 	opd.presentAddressTwoMethod().sendKeys(presentAdd);
 	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,1000)");
 	opd.saveOPDMethod().click();
 	String succMsg = opd.opdSuccessMessageMethod().getText();
 
    Assert.assertTrue(opd.opdSuccessMessageMethod().isDisplayed());	
 	
 	Assert.assertTrue(succMsg.contains("added successfully"));
	

}

    
    

}
