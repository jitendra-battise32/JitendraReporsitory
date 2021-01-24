package Academy.E2EProject;

import java.io.IOException;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal <ExtentTest> extentTest = new ThreadLocal <ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		
		   test = extent.createTest(result.getMethod().getMethodName());  	 
		   extentTest.set(test);
	}

	public void onFinish(ITestContext result) {
	 
		extent.flush();
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
     public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null ;
		// TODO Auto-generated method stub
		//For getting the method name on what method exact the test case is getting failed
      String testMethodName = result.getMethod().getMethodName();
      // Now we to send driver object of Test Listeners to Listeners on Test Failures
      //So whike running that particular @Test this instance driver can be used
      try {
	 driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	      } 
      catch (Exception e) 
      {
    	  test.log(Status.INFO, ExceptionUtils.getStackTrace(e));
	   }
       //Now we need to call the getScreenshot method from our base class
   try {
	   extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName/*driver*/), result.getMethod().getMethodName());

	//	getScreenShotPath(testMethodName,driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
   
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Case Is Passed");
		
	}
	
	
	

}
