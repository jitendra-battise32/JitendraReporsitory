package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	
	public static ExtentReports getReportObject() {
		
	   String path = System.getProperty("user.dir")+"\\reports\\index.html";    // path fro Extent report
  	   ExtentSparkReporter reporter = new ExtentSparkReporter(path);  // 
  	   
  	   reporter.config().setReportName("HMS Rajbahadur Report");   // for selenium  report name 
  	   reporter.config().setDocumentTitle("HMS Document Title");  // Document titlte 
  	   
  	   extent = new ExtentReports();
  	   
  	   
  	   
  	   
  	   extent.attachReporter(reporter);
  	   extent.setSystemInfo("Tester", "Jitendra Battise");
		
  	   return extent;
	}

}
