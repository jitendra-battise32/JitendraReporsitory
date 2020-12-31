package pageObjectPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IPDReg {
	
	
	public WebDriver driver;

	
	public IPDReg(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	

	@FindBy (xpath="/html/body/div[1]/div[5]")
	 WebElement drawerMenu;
	
	@FindBy (xpath="//*[@href='/HMS-Rajebahadur/IPDs']")
	 WebElement IPDButton;
	
	@FindBy (xpath="//*[@href='/HMS-Rajebahadur/IPDs/Create']")
	 WebElement addIPDButton;
	
	@FindBy (xpath="//*[@id='Patients_name']")
	 WebElement patientName;
		
	@FindBy (xpath="//*[@id='enquiry_id']")
	 WebElement enquiryNo;
	
	
	@FindBy (xpath="//*[@id='user_id']")
     WebElement ParentConsultant1;

	
	@FindBy (xpath="//*[@id='ward_id']")
     WebElement ward;
	

public WebElement drawerMenuMethod() {
	
    Actions actions = new Actions(driver);
    actions.moveToElement(drawerMenu).perform();
	return drawerMenu;
}


public WebElement IPDButtonMethod() {
	
	return IPDButton;
}

public WebElement addIPDButtonMethod() {
	
	return addIPDButton;
}


public WebElement patientNameMethod() {
	
	return patientName;
}


public WebElement enquiryNoMethod() {
	
	Select s = new Select(enquiryNo);
	s.selectByValue("10011");
	
	return enquiryNo;
}

public WebElement ParentConsultant1Method() {
	
	return ParentConsultant1;
}

public WebElement wardMethod() {
	
	return ward;
}


}