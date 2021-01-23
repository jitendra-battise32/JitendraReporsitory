package pageObjectPF;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginAsDoctorAttendPatient {

public WebDriver driver;


    //public loginAsDoctorAttendPatient(WebDriver driver)

	

	public loginAsDoctorAttendPatient(WebDriver driver)

	{
		super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath= "//*[@id='_name']")
	WebElement nameSearch;
	                ///html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[10]/div/div[1]/a
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[6]/div/div[1]/a")
	WebElement actionbutton;
	                ///html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[6]/div/div[2]/ul/li[5]/a
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[6]/div/div[2]/ul/li[5]/a")
	WebElement loginAsUser;
	
	@FindBy (xpath = "//*[@id='grid']/div[1]/div/div[1]")
	WebElement dashboardVerify;
	
	@FindBy (xpath = "//*[@href='/HMS-Rajebahadur/IPDs/Attend/22']")
	WebElement attend;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[1]")
	WebElement verifyAttendIPDpage;
	
	@FindBy (xpath= "//*[@id='manage']/div[4]/form/table[2]/tbody/tr[15]/td/input[1]")
	WebElement saveAttendIPD;
	
	@FindBy (xpath = "//*[@id='grid']/div")
	WebElement attendIPDSuccess;
	
	
	//=====================================
	//Add Round Notes
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[1]/form/div/table[2]/tbody/tr/td[10]/div/div[1]")
	WebElement actionBut;
	
	
	@FindBy (xpath = "//*[@href='/HMS-Rajebahadur/RoundNotes/Create/22']")
	WebElement addRoundNotesButton;
	
	@FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[1]")
	WebElement roundNotesPage;
	
	@FindBy (xpath= "//*[@id='ondate']")
	WebElement dateRoundNote;
	
	@FindBy (xpath = "//*[@id='clinical_notes']")
	WebElement clinicalNotes;
	
	@FindBy (xpath ="//*[@type='submit']")
	WebElement saveAddRoundNotes;
	
    @FindBy (xpath = "//*[@class='success-icon']")
    WebElement roundNotesSuccess;
    
    //==========================================
    
    //Add Prescription
    
    
    @FindBy (xpath = "//*[@href='/HMS-Rajebahadur/IPDs/AddPrescriptions/22']")
    WebElement addPrescriptionButton;
    
    @FindBy (xpath="/html/body/div[1]/div[7]/div[2]/div[1]")
    WebElement prescriptionPage;
	
    @FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[1]/div/a/div/b")
    WebElement addMedicineDropDown;
    
    @FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[1]/div/div/div/input")
    WebElement searchMedicine;

    @FindBy (xpath = "//*[@id='_duration']")
    WebElement duration;
    
    @FindBy (xpath = "//*[@id='_dose1_chosen']")
    WebElement day;

  //*[@id='_dose2_chosen']
    
    @FindBy (xpath = "//*[@id='_dose2_chosen']")
    WebElement mid;
    
    @FindBy (xpath = "//*[@id='_dose2_chosen']")
    WebElement night;
    
    @FindBy (xpath = "//*[@id='_dosing_instruction_id_chosen']")
    WebElement dosingInstructor;
    
    @FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[4]/div/div/div/input")
    WebElement dosingSearch;
    
    @FindBy (xpath = "/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[5]/a")
    WebElement addMedicine;
    
    @FindBy (xpath = "//*[@type='submit']")
    WebElement savePresciption;
    
    @FindBy (xpath = "//*[@id='grid']/div")
    WebElement successPres;
      
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
	
   
    public WebElement dashboardVerifyMethod() 
    {
 		return dashboardVerify;
	}
    

    public WebElement attendMethod() 
    {
 		return attend;
	}

	
    public WebElement verifyAttendIPDpageMethod() 
    {
 		return verifyAttendIPDpage;
	}

    
    public WebElement saveAttendIPDMethod() 
    {
 		return saveAttendIPD;
	}

    public WebElement attendIPDSuccessMethod() 
    {
 		return attendIPDSuccess;
	}
	
    public WebElement addRoundNotesButtonMethod() 
    {
 		return addRoundNotesButton;
	}
    
    
    public WebElement roundNotesPageMethod() 
    {
 		return roundNotesPage;
	}
	//@FindBy (xpath= "")
	
    public void dateRoundNoteMethod() 
    {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("document.getElementById('ondate').value='15-01-2021'");
 		//return dateRoundNote;
	}
    
    public WebElement clinicalNotesMethod(String notes) 
    {
    	clinicalNotes.sendKeys(notes);
    	return clinicalNotes;
	}
    

    public WebElement saveAddRoundNotesMethod()
    {
    	
    	return saveAddRoundNotes;
	}
    
    public WebElement roundNotesSuccessMethod()
    {
    	
    	return roundNotesSuccess;
	}
    
    
    public WebElement actionBut()
    {
    	
    	return actionBut;
	}
    
    
    
    
    public WebElement addPrescriptionButtonMethod()
    {
    	
    	return addPrescriptionButton;
	}
    
    
    public WebElement prescriptionPageMethod()
    {
    	
    	return prescriptionPage;
	}
    

    public WebElement addMedicineDropDownMethod()
    {
    	
    	return addMedicineDropDown;
	}
   
    
    public WebElement searchMedicineMethod(String medicineName)
    {
    	searchMedicine.sendKeys(medicineName);
    	searchMedicine.sendKeys(Keys.ENTER);
    	return searchMedicine;
	}
 
    
    public WebElement durationMethod(String durations)
    {
    	duration.sendKeys(durations);
    	return duration;
	}
    
    public void dayMethod()
    {
    	day.click();
  //  	/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[3]/div[1]/div/ul/li[2]
    	//day.sendKeys(Keys.DOWN);
    	
        WebElement ele = driver.findElement(By.xpath("/html/body/div[1]/div[7]/div[2]/div[4]/form/table[2]/tbody/tr[1]/td/table[1]/tbody/tr/td[3]/div[1]/div/ul/li[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
        ele.click();
    	

          //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//jsExecutor.executeScript("document.getElementsByName('Patients_gender').value='Male'");

         //jsExecutor.executeScript("document.getElementById('_dose1_chosen').style.display='block';");
         //jsExecutor.executeScript("document.getElementById('_dose1_chosen').value='2'");
    	//day.click();
    	//day.sendKeys(Keys.DOWN);
    	//day.sendKeys(Keys.ENTER);
    //	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	//	jsExecutor.executeScript("document.getElementById('_dose1').value='1'");
    	//return day;
	}
    
    public void midMethod()
    {
    	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
          jsExecutor.executeScript("document.getElementById('_dose2_chosen').style.display='block';");
    	  jsExecutor.executeScript("document.getElementById('_dose2_chosen').value='2'");
    	//mid.click();
    	//mid.sendKeys(Keys.DOWN);
    	//mid.sendKeys(Keys.DOWN);
    	//mid.sendKeys(Keys.ENTER);
    	
    	//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("document.getElementById('_dose2').value='2'");
    	//return mid;
	}
    
    public void nightMethod()
    {
    	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
          jsExecutor.executeScript("document.getElementById('_dose3_chosen').style.display='block';");
    	  jsExecutor.executeScript("document.getElementById('_dose3_chosen').value='1'");
    	  //jsExecutor.executeScript("document.getElementById('_dose1').value='2'");
    	  //JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	      //jsExecutor.executeScript("document.getElementById('_dose3').value='3'");
          //return night;
	}
    
  
    public WebElement dosingInstructorMethod()
    {
    	
    	return dosingInstructor;
	}
   
    public WebElement dosingSearchMethod(String instructor)
    {
    	dosingSearch.sendKeys(instructor);
    	dosingSearch.sendKeys(Keys.ENTER);
    	
    	return dosingSearch;
	}
    

    public WebElement addMedicineMethod()
    {
    	
    	return addMedicine;
	}
  
    public WebElement savePresciptionMethod()
    {
    	
    	return savePresciption;
	}
    
    public WebElement successPresMethod()
    {
    	
    	return successPres;
	}
    
    
}
