package pageObjectPF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class attendPatient {

public WebDriver driver;

	
	public attendPatient(WebDriver driver) {
		 super();
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	
	

	
	
	
	
}
