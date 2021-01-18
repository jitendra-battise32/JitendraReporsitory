package Academy.E2EProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.IPDReg;
import pageObjectPF.loginAsDoctorAttendPatient;
import resources.ExtentReporterNG;
import resources.base;

public class addPrescription extends base{
	//public WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@Test(priority = 5)
	public void DoctorAddPrescription() throws InterruptedException {
		
		try {
			loginAsDoctorAttendPatient doc = new loginAsDoctorAttendPatient(driver);
		    Thread.sleep(2000);
			doc.actionBut().click();
			doc.addPrescriptionButtonMethod().click();
			String presc = doc.prescriptionPageMethod().getText();
			Assert.assertTrue(presc.contains("Add Prescription"));
			Thread.sleep(2000);
			IPDReg ipd1 =new IPDReg(driver);
			ipd1.scroll();
			doc.addMedicineDropDownMethod().click();
			doc.searchMedicineMethod("Ashpi");
			doc.durationMethod("30");
			//driver.findElement(By.xpath("//div[@id='_dose1_chosen']//span[contains(text(),'0')")).click();
			doc.dayMethod();
		//	doc.midMethod();
		//	doc.nightMethod();
			//doc.nightMethod();
			doc.dosingInstructorMethod().click();
			doc.dosingSearchMethod("6");
			doc.addMedicineMethod().click();
			ipd1.scroll();
			doc.savePresciptionMethod().click();
			String  pres = doc.successPresMethod().getText();
			Assert.assertTrue(pres.contains("Prescription updated successfully for IPD."));
			
        	}
		
		catch(Exception e) {
			 System.out.println("Something Went Wrong in AddPrescription");
			 System.out.println(e.getMessage());
		//	 System.out.println(e.getStackTrace());
			 test.fail(e);
	         Assert.fail();
	         extent.flush();
			}
	   	    
	
	}
}
