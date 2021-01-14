package pageObjectPF;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

	@FindBy (xpath="//*[@id='enquiry_id_chosen']")
	 WebElement enquiryNo;
	
	@FindBy (xpath= "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[1]/td[2]/div/div/div/input")
     WebElement enquiryNoSearch;	
	
	@FindBy (xpath="/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[2]/td[2]/div/a")
	WebElement upload;	

	@FindBy (xpath="//*[@id=\"manage\"]/div[3]/form/table/tbody/tr[2]/td[2]/div/span/span")
	WebElement uploadedOrNot;	
	
	@FindBy (xpath = "//*[@id='user_id_chosen']")
	WebElement parentCons;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[3]/td[1]/div/div/div/input")
	WebElement parentConsSearch;
	
	@FindBy (xpath="//*[@id='ward_id_chosen']")
    WebElement ward;
	
	@FindBy (xpath="/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[3]/td[2]/div/div/div/input")
	WebElement wardSearch;
	
	@FindBy (xpath= "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[4]/td[2]/div")
	List<WebElement> bed;
	
	@FindBy (xpath= "//*[@id='admission_dt']")
	WebElement admissionDate;
	
	@FindBy (xpath = "//*[@id='age']")
	WebElement age;
	
	@FindBy (xpath="//*[@id='Patients_gender_chosen']")
	WebElement gender;
	
	@FindBy (xpath="//*[@id='Patients_permanent_address']")
	WebElement patientAdd;
	
	@FindBy (xpath="//*[@id='Patients_sameAddress']")
	WebElement patientSameAddr;
	
	@FindBy (xpath="//*[@type='submit']")
	WebElement submitButton;
	
	@FindBy (xpath="//*[@id='Patients_TPA']")
	WebElement TPA;
	
	@FindBy (xpath="//*[@id='Patients_tpa_id_chosen']")
	WebElement insuranceCompany;
	
	@FindBy (xpath="/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[22]/td[1]/div/div/div/input")
	WebElement insuranceCompanySearch;
	
	@FindBy (xpath="//*[@id='Patients_TPA_no']")
	WebElement policynumber;
	
	@FindBy (xpath="//*[@id='grid']/div")
	WebElement successMess;
	
	
	
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

public WebElement enquiryNoMethod() {
	
	Select s = new Select(enquiryNo);
	s.selectByValue("10011");
	
	return enquiryNo;
}


public void enquiryNoSearchMethod() {
		
	enquiryNo.click();
	enquiryNoSearch.click();
    enquiryNoSearch.sendKeys("15");
	enquiryNoSearch.sendKeys(Keys.ENTER);
	
}

public void  uploadMethod() throws AWTException {
	
     	 upload.click();

	     //put path to your image in a clipboard
	     StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\java\\Files\\TomJerry.png");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot = new Robot();
	     robot.delay(250);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);

}


public WebElement uploadedOrNotMethod() {
	
	return uploadedOrNot;
}

public WebElement parentConsMethod() {
	
	return parentCons;
}

public void parentConsSearchMethod(String parentConsultant) throws InterruptedException {
	
//	return parentConsSearch;
	
	parentCons.click();
	Thread.sleep(3000);
	parentConsSearch.click();
	parentConsSearch.sendKeys(parentConsultant);
	parentConsSearch.sendKeys(Keys.ENTER);
}

public void wardSearchMethod(String wardSelect) throws InterruptedException {
	
	ward.click();
	wardSearch.click();
	wardSearch.sendKeys(wardSelect);
	wardSearch.sendKeys(Keys.ENTER);
	}


public void bedMethod() throws InterruptedException {
	
	  //driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[4]/td[2]/div/div[41]/input")).click();
	  
	  
	  
	   /* List<WebElement> bakeries = bed;
       for (WebElement webElement : bakeries) {
        String name = webElement.getText();
        System.out.println(name); */
        
        String beforeXpath = "/html/body/div[1]/div[7]/div[2]/div[3]/form/table/tbody/tr[4]/td[2]/div/div[";
        String afterXpath = "]";
        
        for(int i=42;i<=45;i++) {
        	String actualXpath = beforeXpath+i+afterXpath;
        	WebElement element =driver.findElement(By.xpath(actualXpath));
        	System.out.println(element.getText());
        	element.click();
        }
   	
        // if(element.getText().equals("COMMON WARD")){
      //  		Thread.sleep(3000);
      //  		element.click();
      //  	} 
        	
        }


public void admissionDateMethod() {
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("document.getElementById('admission_dt').value='01-01-2021'");
	
	//return admissionDate;
}

public void scroll() {
	
	   JavascriptExecutor js = (JavascriptExecutor) driver;
 	  js.executeScript("window.scrollBy(0,400)");
}


public WebElement ageMethod() {
	
	 return age;
}


public void genderMethod() {
	
//	gender.click();

JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//jsExecutor.executeScript("document.getElementsByName('Patients_gender').value='Male'");

jsExecutor.executeScript("document.getElementById('Patients_gender').style.display='block';");
jsExecutor.executeScript("document.getElementById('Patients_gender').value='Male'");
//Select gender = new Select(driver.findElement(By.name("Patients.gender")));
//gender.selectByVisibleText("Male");
//gender.selectByIndex(1); 

}


public WebElement patientAddMethod() {
	
	 return patientAdd;
}

public WebElement patientSameAddrMethod() {
	
	 return patientSameAddr;
}



public WebElement submitButtonMethod() {
	
	 return submitButton;
}


public WebElement TPAMethod() {
	
	 return TPA;
}

public void insuranceCompanyMethod(String insurance) {
	
	insuranceCompany.click();
	insuranceCompanySearch.click();
	insuranceCompanySearch.sendKeys(insurance);
	insuranceCompanySearch.sendKeys(Keys.ENTER);
	
}
public WebElement policynumberMethod() {
	
	 return policynumber;
}


public WebElement successMessMethod() {
	
	 return successMess;
}


}
	








