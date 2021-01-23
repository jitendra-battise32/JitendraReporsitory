package Academy.E2EProject;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjectPF.IPDReg;
import pageObjectPF.ipdDetails;
import resources.ExtentReporterNG;
import resources.base;

public class ipdAddUpdateMain extends base {
	
//	public WebDriver driver;
ExtentTest test;
ExtentReports extent = ExtentReporterNG.getReportObject();

	@Test (priority = 1)
         public void IPDRegistration() throws InterruptedException, AWTException {
		try {
		
		  driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/IPDs#NoBack");
		  IPDReg ipd =new IPDReg(driver);
		  ipd.addIPDButtonMethod().click();
		  ipd.enquiryNoSearchMethod();
		  Thread.sleep(3000);
		  ipd.uploadMethod();
	      String uploaded = ipd.uploadedOrNotMethod().getText();
	      Assert.assertEquals(uploaded, "File uploaded successfully.");
	      Thread.sleep(3000);
	      ipd.parentConsSearchMethod("Dr Jaideep Rajebahadur");
	      ipd.wardSearchMethod("DELUX");
	     // Thread.sleep(3000);
	      ipd.bedMethod();
	      ipd.admissionDateMethod();
	      ipd.scroll();
	      ipd.ageMethod().sendKeys("26");
	      //ipd.scroll();
	      Thread.sleep(3000);
	      
	      ipd.genderMethod();
	      ipd.patientAddMethod().click();
	      ipd.patientAddMethod().clear();
	      ipd.patientAddMethod().sendKeys("Row House No. 04, Anupam row house Nashik,422003");
	      ipd.scroll();
	      ipd.patientSameAddrMethod().click();
	      ipd.scroll();
	      ipd.scroll();
	      ipd.TPAMethod().click();
	      Thread.sleep(3000);
	      ipd.insuranceCompanyMethod("ADITYA BIRLA");
	      ipd.policynumberMethod().sendKeys("1234567910");
	      ipd.submitButtonMethod().click();
	      String msg =   ipd.successMessMethod().getText();
	      Assert.assertTrue(msg.contains("added successfully"));
		}
		
		catch(Exception e) {
			 System.out.println("Something Went Wrong in while adding the IPD");
			 System.out.println(e.getMessage());
		//	 System.out.println(e.getStackTrace());
			 test.fail(e);
	         Assert.fail();
	         extent.flush();
			}

		}
	
	 	@Test(priority = 2)
		public void IPDUpdate() throws InterruptedException {
	 		try {
			
			driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/IPDs#NoBack");
			
			ipdDetails ipdDet = new ipdDetails(driver);
			ipdDet.ipdNoSearchMethod("IPD/2021/Jan/00022");
			Thread.sleep(3000);
			ipdDet.actionButtonMethod().click();
			ipdDet.clickDetailsMethod().click();
		    String ipd = ipdDet.ipdDetailsPageVerifyMethod().getText();
			Assert.assertTrue(ipd.contains("IPD Details"));
			ipdDet.historyOptionMethod();
		 // String ipd = ipdDet.ipdDetailsPageVerifyMethod().getText();
		    Assert.assertTrue(ipd.contains("IPD Details"));
		    ipdDet.editIPDMethod().click();
		 
		    IPDReg ipd1 =new IPDReg(driver);
		    ipd1.scroll();
	        ipdDet.weightMethod().sendKeys("25");
		    ipd1.scroll();
		    ipdDet.saveButtonMethod().click();
		    Thread.sleep(2000);
		    String succ = ipdDet.updateSuccessMessageMethod().getText();
		    Assert.assertTrue(succ.contains("IPD details updated successfully"));
	 		}
	 		
	 		catch(Exception e) {
	 			 System.out.println("Something Went Wrong while Update the IPD");
	 			 System.out.println(e.getMessage());
	 		//	 System.out.println(e.getStackTrace());
	 			 test.fail(e);
		         Assert.fail();
		         extent.flush();
	 			}
		
		}


}
