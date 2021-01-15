package pageObjectPF;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginAsUser {

public WebDriver driver;

	
	public loginAsUser(WebDriver driver)
	{
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath= "//*[@id='_name']")
	WebElement nameSearch;
	
	@FindBy (xpath = "//*[@class='button']")
	WebElement actionbutton;
	
	@FindBy (xpath = "//*[@href='/HMS-Rajebahadur/Users/LoginAsUser/10046']")
	WebElement loginAsUser;
	
	
	public WebElement nameSearchMethod(String name) 
	{
       nameSearch.sendKeys(name);
       nameSearch.sendKeys(Keys.ENTER);
	   return nameSearch;
        
	}
	

	public WebElement actionbuttonMethod() 
	{
    	return actionbutton;
	}
	
	
    public WebElement loginAsUserMethod() 
    {
 		return loginAsUser;
	}
	
    
    
	
	
	
	
	
	
	


	
	//@FindBy (xpath= "")
	
	
}
