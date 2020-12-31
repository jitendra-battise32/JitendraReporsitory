package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

    public WebDriver driver;
    public Properties prop;
	
public WebDriver initialisationBrowser() throws IOException {
	
    prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\data.properties");
	prop.load(fis);
	
    String browserName = System.getProperty("browser");

	//String browserName = prop.getProperty("browser");
	
	
if (browserName.contains("chrome"))
{ 
     System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
     ChromeOptions options = new ChromeOptions();
     if(browserName.contains("headless"))
     {
     options.addArguments("headless");
	 }
     driver = new ChromeDriver(options);
}





if (browserName.equals("firefox")) 
{
	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\lib\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 
}

if (browserName.equals("IE")) 
{
	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\lib\\IEDriverServer.exe");  
     driver=new InternetExplorerDriver();  	
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

return driver;
}

public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	//abovedriver is another driver we need to capture the  driver of the that particular test case
	
	File source = ts.getScreenshotAs(OutputType.FILE);
	//File is now in virtual location to get in our local we need to use below code
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destinationFile));
	return destinationFile;
	
}


		
}
