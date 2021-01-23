package pageObjectPF;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OPDRegistration {
	
	public WebDriver driver;
	public OPDRegistration(WebDriver driver) {
		 super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[@href='/HMS-Rajebahadur/OPDs/Create']")
	WebElement AddOPD;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/a/span")
 	WebElement enquiryNo;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/div/div/input")
	WebElement enquiryNoSearch;
	
	@FindBy (xpath = "//*[@id='Patients_dob']")
	WebElement patientDOB;

	@FindBy (xpath = "//*[@id='app_date']")
	WebElement opdDate;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[5]/td[1]/div/a/span")
	WebElement gender;

	@FindBy (xpath="//*[@id='age']")
	WebElement age;
	
	@FindBy (xpath="//*[@id='Patients_permanent_address']")
	WebElement patientAddress;
	
	@FindBy (xpath = "//*[@id='Patients_present_address']")
	WebElement presentAddressTwo;
	
	@FindBy (xpath = "//*[@class='btn-green']")
	WebElement saveOPD;
	
	
	
	@FindBy (xpath = "//*[@class='success-icon']")
	WebElement opdSuccessMessage;

	public WebElement AddOPDMethod() {
		
	    return AddOPD;
	}
	
	
	public void DMMethod() {
		WebElement DM = driver.findElement(By.xpath("/html/body/div[1]/div[5]"));
	      Actions  actions = new Actions(driver);
		  actions.moveToElement(DM).perform();
	}
	
	public void OPDButtonMethod() {
		  Actions  actions = new Actions(driver);
		  WebElement op = driver.findElement(By.xpath("//*[@href='/HMS-Rajebahadur/OPDs']"));
	      actions.moveToElement(op).perform();
	      op.click();
	}
	
	public void enquiryNoMethod() {
	//	Select objSelect = new Select(enquiryNo);
	//	objSelect.selectByVisibleText("00013");
		
		//return enquiryNo;
		enquiryNo.click();
	    enquiryNoSearch.sendKeys("95");
		enquiryNoSearch.sendKeys(Keys.ENTER);
	   // WebElement builder = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/div/div/input"));
	 //   builder.sendKeys("41");
	 //   builder.sendKeys(Keys.ENTER);
    }

	public void patientDOBMethod(){
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('Patients_dob').value='09-02-1994'");

	}
	
	public void opdDateMethod() {
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		jsExecutor1.executeScript("document.getElementById('app_date').value='17-12-2020'");
	}
	
	public void genderMethod() {

		JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
		jsExecutor2.executeScript("document.getElementById('Patients_gender').value='Male'");
		
		
	}

	public WebElement ageMethod() {
		
	    return age;
	}

	public WebElement patientAddressMethod() {
		
	    return patientAddress;
	}
	
    public WebElement presentAddressTwoMethod() {
		
	    return presentAddressTwo;
	}
    
	public WebElement saveOPDMethod(){
		
	    return saveOPD;
	}
	
	
	public WebElement opdSuccessMessageMethod() {
		return opdSuccessMessage;
	}
	

}
