package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "RegistrationForm/src/test/java/feature",glue = "stepDefinition")
public class TestRunner 
{
	
}