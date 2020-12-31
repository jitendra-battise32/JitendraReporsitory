package cucumberOptions;

//--------import org.junit.runner.RunWith;

//----import io.cucumber.junit.Cucumber;
//-----import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
		features = "C:\\Users\\jitendra.battise\\Jitu\\E2EProject\\src\\test\\java\\features",
		glue="stepDefinations", tags = "@SmokeTest",monochrome=true,
		plugin = {"pretty", "html:HMS1"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {		

}

