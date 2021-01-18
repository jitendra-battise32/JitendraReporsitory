package Academy.E2EProject;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.util.thread.TryExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.IPDReg;
import pageObjectPF.loginAsDoctorAttendPatient;
import resources.ExtentReporterNG;
import resources.base;

public class addRoundNotes extends base {
 
	//public WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@Test(priority = 4)
	public void DoctorAddRoundNotes() throws InterruptedException {
		
	try {
		loginAsDoctorAttendPatient doc = new loginAsDoctorAttendPatient(driver);
	    Thread.sleep(2000);
		doc.actionBut().click();
		doc.addRoundNotesButtonMethod().click();
		String  round= doc.roundNotesPageMethod().getText();
		Assert.assertTrue(round.contains("Add Round Note"));
		Thread.sleep(1000);
		IPDReg ipd1 =new IPDReg(driver);
		ipd1.scroll();
		doc.dateRoundNoteMethod();
	    doc.clinicalNotesMethod("Testing the clinical Notes");
	    ipd1.scroll();
	    Thread.sleep(2000);
	    doc.saveAddRoundNotesMethod().click();
		String roundSucc = doc.roundNotesSuccessMethod().getText();
		Assert.assertTrue(roundSucc.contains("Round Note details added successfully."));
	
		}
	
		catch(Exception e) {
		 System.out.println("Something Went Wrong in RoundNotes");
		 System.out.println(e.getMessage());
	//	 System.out.println(e.getStackTrace());
		 test.fail(e);
         Assert.fail();
         extent.flush();
		}

	}
	
	
}
