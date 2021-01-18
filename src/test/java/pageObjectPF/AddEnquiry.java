package pageObjectPF;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEnquiry {
	
	public WebDriver driver;

	public AddEnquiry(WebDriver driver) {
	     super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="/html/body/div[1]/div[5]")
	private WebElement drawerMenu;
	
	@FindBy (xpath="/html/body/div[1]/div[5]/div/div[1]/ul/li[6]/a")
	private WebElement enquiryButton;
	
	@FindBy (xpath = "//*[@class='title-admin']")
	private WebElement veriftTitltleEn;

	@FindBy (xpath="//*[@class='add button']")
	private WebElement AddEnquiryButton;
	
	@FindBy (xpath="//*[@id='person_name']")
	private WebElement personName;
	
	@FindBy (xpath="/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/a")
	private WebElement doctor;
	
	@FindBy (xpath="//*[@id='description']")
	private WebElement description;
	
	@FindBy (xpath="//*[@id='address']")
	private WebElement Address;
	
	@FindBy (xpath="//*[@id='contactno1']")
	private WebElement contactNo1;
	
	@FindBy (xpath="//*[@id='contactno2']")
	private WebElement contactNo2;
	
	@FindBy (xpath = "//*[@type='submit']")
	private WebElement enquirySave;
	
	@FindBy (xpath = "//*[@class='success-icon']")
	private WebElement successMessage;
	
	public WebElement drawerMenuMethod() {
		
		Actions  actions = new Actions(driver);
	    actions.moveToElement(drawerMenu).perform();
		return drawerMenu;
	}
	
	
	public WebElement enquiryButtonMethod() {
		Actions  actions = new Actions(driver);
        actions.moveToElement(enquiryButton).perform();
        return enquiryButton;
	}
	
	public WebElement AddEnquiryButtonMethod() {
		return AddEnquiryButton;
	}
	

	public WebElement veriftTitltleEnMethod() {
		return veriftTitltleEn;
	}
	
	public WebElement personNameMethod() {
		return personName;
	}
	
	public WebElement doctorMethod() {
        doctor.click();
	    WebElement builder = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/div/div/input"));
	    builder.sendKeys("Jaideep");
	    builder.sendKeys(Keys.ENTER);
		return doctor;
	}
	
	public WebElement descriptionMethod() {
		return description;
	}
	
	public WebElement AddressMethod() {
		return Address;
	}
	
	public WebElement contactNo1Method() {
		return contactNo1;
	}
	
	public WebElement contactNo2Method() {
		return contactNo2;
	}
	
	public WebElement enquirySaveMethod() {
		return enquirySave;
	}
	
	
	public WebElement successMessageMethod() {
		
		return successMessage;
	}
	

}
