package Academy.E2EProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjectPF.loginAsDoctorAttendPatient;
import resources.base;

public class loginAsUserMain extends base {
	WebDriver driver;

	@Test(priority = 2)
	public void loginAsDoctor() throws InterruptedException {
		
		System.out.println("Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='add button']")).click();
     	//driver.navigate().to("http://projects.teamgrowth.net/HMS-Rajebahadur/Users#NoBack");
		//loginAsUser Doc = new loginAsUser(driver);
		//Doc.nameSearchMethod("drviki");

	}

}
