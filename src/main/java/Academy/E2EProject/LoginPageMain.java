package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectPF.LoginPage;

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
    	driver.close();
    }

}
