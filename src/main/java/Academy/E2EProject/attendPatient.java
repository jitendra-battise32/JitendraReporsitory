package Academy.E2EProject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.IPDReg;
import pageObjectPF.ipdDetails;
import pageObjectPF.loginAsDoctorAttendPatient;
import resources.ExtentReporterNG;
import resources.base;

public class attendPatient extends base{
//	public WebDriver driver;
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@Test(priority = 3)
	public void DoctorAttendPatient() throws InterruptedException {
		  
		try {
		driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/Users#NoBack");
		loginAsDoctorAttendPatient doc = new loginAsDoctorAttendPatient(driver);
		doc.nameSearchMethod("Dr Jaideep Rajebahadur");
		Thread.sleep(2000);
		doc.actionbuttonMethod().click();
		Thread.sleep(2000);
		doc.loginAsUserMethod().click();
		driver.switchTo().alert().accept();
		String dash = doc.dashboardVerifyMethod().getText();
		Assert.assertTrue(dash.contains("Pendency List"));
		System.out.println("Test");
        driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/IPDs#NoBack");
        ipdDetails ipdDet = new ipdDetails(driver);
		ipdDet.ipdNoSearchMethod("IPD/2021/Jan/00022");
		ipdDet.actionButtonMethod().click();
		doc.attendMethod().click();
		String attendIOD = doc.verifyAttendIPDpageMethod().getText();
		Assert.assertTrue(attendIOD.contains("Attend IPD"));
		Thread.sleep(2000);
		IPDReg ipd1 =new IPDReg(driver);
		ipd1.scroll();
		ipd1.scroll();
		ipd1.scroll();
		ipd1.scroll();
		doc.saveAttendIPDMethod().click();
		String attend = doc.attendIPDSuccessMethod().getText();
		Assert.assertTrue(attend.contains("IPD attended successfully."));
		}
		
		catch(Exception e) {
			 System.out.println("Something Went Wrong while attending the Patient");
			 System.out.println(e.getMessage());
		//	 System.out.println(e.getStackTrace());
			 test.fail(e);
	         Assert.fail();
	         extent.flush();
			}

	}

}
