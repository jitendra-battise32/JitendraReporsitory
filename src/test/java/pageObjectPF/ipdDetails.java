package pageObjectPF;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ipdDetails {
	
	WebDriver driver;
	
	public ipdDetails(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath = "//*[@id='_ipd_no']")
	WebElement ipdNoSearch;		
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[10]/div/div[1]")
	WebElement detailsButton;
	
	@FindBy (xpath = "//*[@href='/HMS-Rajebahadur/IPDs/Details/22']")
	WebElement clickDetails;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[1]")
	WebElement ipdDetailsPageVerify;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/ul/li[2]/a")
	WebElement historyOption;
	
	//@FindBy (xpath = "//*[@id='TB_window']")
	//WebElement windowPopup;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/ul/li[3]/a")
	WebElement editIPD;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[1]")
	WebElement editVerify;
	
	@FindBy (xpath = "//*[@id='weight']")
	WebElement weight;
	
	@FindBy (xpath = "//*[@type='submit']")
	WebElement saveButton;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[1]/form/div/div")
	WebElement updateSuccessMessage;
	
	
	
	public WebElement ipdNoSearchMethod(String ipdNo) {
		
		ipdNoSearch.sendKeys(ipdNo);
		ipdNoSearch.sendKeys(Keys.ENTER);
		
		return ipdNoSearch;
		
	}

	
    public WebElement actionButtonMethod() {
	
		return detailsButton;
		
	}
	
    public WebElement clickDetailsMethod() {
    	
		return clickDetails;
		
	}
    
   public WebElement ipdDetailsPageVerifyMethod() {
    	
 		return ipdDetailsPageVerify;
 		
 	}
     
    public void historyOptionMethod()
    {
    	
    	String parentHandle = driver.getWindowHandle(); // get the current window handle
    	historyOption.click(); // click some link that opens a new window

    	for (String winHandle : driver.getWindowHandles()) 
    	{
    	    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
     	}
    	
        String get = driver.findElement(By.xpath("//*[@id='TB_ajaxWindowTitle']")).getText();
        System.out.println(get);
        // driver.close(); // close newly opened window when done with it
        // driver.switchTo().window(parentHandle); // switch back to the original window
        driver.findElement(By.xpath("//*[@id='TB_closeWindowButton']")).click();
       
     }
    

    public WebElement editIPDMethod() {
    	
 		return editIPD;
 		
 	}
    
    
 public WebElement editVerifyMethod() {
    	
 		return editVerify;
 		
 }

 
 public WebElement weightMethod() {
 	
		return weight;
		
	}
 
 
 public WebElement saveButtonMethod() {
	 	
		return saveButton;
		
	}
 
 //updateSuccessMessage
 public WebElement updateSuccessMessageMethod() {
	 	
		return updateSuccessMessage;
		
	}
 
}