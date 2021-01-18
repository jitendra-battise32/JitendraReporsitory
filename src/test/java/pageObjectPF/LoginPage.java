package pageObjectPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		 super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//input[@id='user_name']")
	WebElement userName;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy (xpath ="//input[@id='login_submit']")
	WebElement loginButton;
	
	@FindBy (xpath ="//*[@class='title-admin']")
	WebElement title;
	
	
	
	

	@FindBy (xpath ="//*[@class='box-body']")
	WebElement dashBoardReports;
	


	public WebElement usernameMethod() {
		return userName;
		
	}
		
	public WebElement passwordMethod() {
		return password;
	}
		
	public WebElement loginButtonMethod() {
		return loginButton;
	}
		
	public WebElement getTitleMethod() {
		return title;
	}
		
	public WebElement dashBoardReportsMethod() {
		return dashBoardReports;
	}
	
		
	

}
