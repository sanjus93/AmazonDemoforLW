package TestRun;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"src/test/java/features/Scenario1.feature"},
		strict=true,
		glue= {"stepDefinition"}
	
		
		)

public class TestRunner   {

}
