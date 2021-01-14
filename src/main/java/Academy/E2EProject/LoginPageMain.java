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

import pageObjectPF.AddEnquiry;
import pageObjectPF.IPDReg;
import pageObjectPF.LoginPage;
import pageObjectPF.OPDRegistration;

import pageObjectPF.ipdDetails;
import resources.Xls_Reader;
import resources.base;



public class LoginPageMain extends base { 
//The extends keyword extends a class (indicates that a class is inherited from another class).

	public WebDriver driver;
	
	
    @BeforeTest 
    
    public void before() throws IOException {
    	driver = initialisationBrowser();
    	
	    String urls = prop.getProperty("url");
	    driver.get(urls);
	    driver.manage().window().maximize();
    }

	
	@Test(priority = 0)
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


	//@Test(priority = 1)
	 
	public void ipdRegistration() throws InterruptedException, AWTException {
		
	  driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/IPDs#NoBack");
	  IPDReg ipd =new IPDReg(driver);
	  ipd.addIPDButtonMethod().click();
	  ipd.enquiryNoSearchMethod();
	  Thread.sleep(3000);
	  ipd.uploadMethod();
      String uploaded = ipd.uploadedOrNotMethod().getText();
      Assert.assertEquals(uploaded, "File uploaded successfully.");
      Thread.sleep(3000);
      ipd.parentConsSearchMethod("Dr Jaideep Rajebahadur");
      ipd.wardSearchMethod("COMMON WARD");
      //Thread.sleep(3000);
      ipd.bedMethod();
      ipd.admissionDateMethod();
      ipd.scroll();
      ipd.ageMethod().sendKeys("26");
      //ipd.scroll();
      Thread.sleep(3000);
      
      ipd.genderMethod();
      ipd.patientAddMethod().click();
      ipd.patientAddMethod().clear();
      ipd.patientAddMethod().sendKeys("Row House No. 04, Anupam row house Nashik,422003");
      ipd.scroll();
      ipd.patientSameAddrMethod().click();
      ipd.scroll();
      ipd.scroll();
      ipd.TPAMethod().click();
      Thread.sleep(3000);
      ipd.insuranceCompanyMethod("ADITYA BIRLA");
      ipd.policynumberMethod().sendKeys("1234567910");
      ipd.submitButtonMethod().click();
      String msg =   ipd.successMessMethod().getText();
      Assert.assertTrue(msg.contains("added successfully"));

	}
	
	@Test(priority = 1)
	public void ipdDetailsMethods() throws InterruptedException {
		
		driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/IPDs#NoBack");
		
		ipdDetails ipdDet = new ipdDetails(driver);
		ipdDet.ipdNoSearchMethod("IPD/2021/Jan/00022");
		Thread.sleep(3000);
		ipdDet.detailsButtonMethod().click();
		ipdDet.clickDetailsMethod().click();
	    String ipd = ipdDet.ipdDetailsPageVerifyMethod().getText();
		Assert.assertTrue(ipd.contains("IPD Details"));
		ipdDet.historyOptionMethod();
	  //  String ipd = ipdDet.ipdDetailsPageVerifyMethod().getText();
	    Assert.assertTrue(ipd.contains("IPD Details"));
	    ipdDet.editIPDMethod().click();
	 
	    IPDReg ipd1 =new IPDReg(driver);
	    ipd1.scroll();
	    
	    ipdDet.weightMethod().sendKeys("25");
	    ipd1.scroll();
	    ipdDet.saveButtonMethod().click();
	    Thread.sleep(2000);
	    String succ = ipdDet.updateSuccessMessageMethod().getText();
	    Assert.assertTrue(succ.contains("IPD details updated successfully"));
	    
	   // Assert.assertTrue(edit.contains("Edit IPD"));
		
	//	String popup = ipdDet.windowPopupMethod().getText();
	//	System.out.println(popup);
	//	ipdDet.windowPopupMethod();
		//Assert.assertTrue(popup.contains("Patient's History"));
		
	}

    @AfterTest 
    public void after() {
    //	driver.close();
    }

}
