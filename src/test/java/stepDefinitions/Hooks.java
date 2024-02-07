package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.*;

public class Hooks {
	
	WebDriver driver;
	Properties p;
	
	@Before
	public void setup() throws IOException 
	{
		driver = BaseClass.initializeBrowser();
		
		p = BaseClass.getProperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@After
	public void tearDown(Scenario scenario) 
	{
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) 
	{
		// this is for Cucumber junit report
		if(scenario.isFailed()) 
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
		}
	}

}
