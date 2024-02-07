package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features = {".//Features"}				// To execute all the feature files
		features = {".//Features/Login.feature"}, // To execute specific feature file
        // features= {".//Features/LoginDDTExcel.feature"}
		//features= {".//Features/Login.feature", ".//Features/Registration.feature"}, // To execute multiple feature files
		// features = {"@target/rerun.txt"},		// To execute only failed scenarios
		
		//features= {".//Features/LoginDDTExcel.feature"},
		//features= {".//Features/Registration.feature"},
		//features = {"@target/rerun.txt"}, // To run the failes feature directly from rerun.txt
		glue="stepDefinitions",
		plugin= {"pretty", "html:reports/myreport.html",  // To generate Junit Cucumber report stores inside reports folder
				"rerun:target/rerun.txt"},					// failed scenarios will be captured in rerun.txt
//				"html:test-output/SparkReport/Spark.html"},
//				"tech.grasshopper.reporter.*:"},// To generate extent reports for Cucumber
		
		dryRun = false,	 // checks mapping between scenario steps and step Definition methods with actual execution
		monochrome=true, // To remove the junk characters in console 
		publish = true, // To ensure cucumber report details provided in the console once published to Cucumber central server
		
//		tags = "@sanity"  // this will execute scenarios tagged with @sanity
//		tags = "@regression"   // this will execute scenarios tagged with @regression
//		tags = "@sanity and @regression" // scenarios tagged with both @sanity and @regression
//		tags = "@sanity and not @regression" // scenarios tagged with @sanity but not with @regression
		tags = "@sanity or @regression" // scenarios tagged with @sanity or @regression
		
		) 

public class TestRunner {

}
