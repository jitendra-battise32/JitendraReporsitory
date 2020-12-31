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

	
	@Test//(dataProvider ="getData")
	                              //(String username, String password)
        public void loginMethod() throws IOException, InterruptedException {

	//	ExcelDataConfig ex = new ExcelDataConfig("C:\\Users\\User\\eclipse-workspace\\JitendraBattise\\MyRepository\\src\\test\\java\\resources\\TestData.xlsx");
	//	String Username = ex.getData(0, 0, 0);
	//	String Password = ex.getData(0, 0, 1);
		
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

	/*	

	@Test(dataProvider ="getData")
    public void enquiryAdd(String user, String pass) throws IOException, InterruptedException {

		
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
	*/
	
//	@Test//(dataProvider ="getData")
	
//    public void /*loginMethod*/ OPDRegMethod(/*String username, String password*/) throws IOException, InterruptedException {

//	 Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\TestData.xlsx");
		
  	//int rowCount = reader.getRowCount("LoginCredentials");
/*	String username = reader.getCellData("LoginCredentials","Username", 2);
    String password = reader.getCellData("LoginCredentials","Password", 2);

	
	
	LoginPage lp = new LoginPage(driver);
    lp.usernameMethod().sendKeys(username);
    lp.passwordMethod().sendKeys(password);
 	lp.loginButtonMethod().click();

 	String actualTitle = lp.getTitleMethod().getText();
   
 	Assert.assertEquals(actualTitle, "DashBoard");
 	Assert.assertTrue(lp.getTitleMethod().isDisplayed());
 	
 	OPDRegistration opd = new OPDRegistration(driver);
 	opd.DMMethod();
 	Thread.sleep(2000);
 	opd.OPDButtonMethod();
 	Thread.sleep(3000);
 	opd.AddOPDMethod().click();;
 	Thread.sleep(3000);
 	
//   	opd.enquiryNoMethod().click();
 	
 //	opd.enquiryNoMethod().click();
// 	opd.enquiryNoSearchMethod().sendKeys("41");
 //	opd.enquiryNoSearchMethod().sendKeys(Keys.ENTER);
 	opd.enquiryNoMethod();
 	opd.patientDOBMethod();
 	opd.opdDateMethod();
 	opd.ageMethod().sendKeys("20");
 	opd.genderMethod();
 	
  //int rowCount1 = reader.getRowCount("OPDRegistration");
	String patientAdd = reader.getCellData("OPDRegistration","PatientAddress", 2);
    String presentAdd = reader.getCellData("OPDRegistration","PresentAddress", 2);
 	
 	
 	
 	opd.patientAddressMethod().sendKeys(patientAdd);
 	opd.presentAddressTwoMethod().sendKeys(presentAdd);
 	JavascriptExecutor js = (JavascriptExecutor) driver;
 	js.executeScript("window.scrollBy(0,1000)");
 	opd.saveOPDMethod().click();
 	String succMsg = opd.opdSuccessMessageMethod().getText();
 //	Assert.assertTrue(succMsg.isDisplayed());
    Assert.assertTrue(opd.opdSuccessMessageMethod().isDisplayed());	
 	
 	Assert.assertTrue(succMsg.contains("added successfully"));
	//System.out.println(succMsg);
 	
 	

}
	*/
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

  */ /*
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
	 */
	 
	
    @AfterTest 
    public void after() {
    	driver.close();
    }

}
