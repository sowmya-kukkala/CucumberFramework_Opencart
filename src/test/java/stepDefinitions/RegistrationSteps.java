package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RegistrationSteps {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AccountRegistrationPage regpage;
	
	@Given("the user navigates to Register Account Page")
	public void the_user_navigates_to_register_account_page() {
	    
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
	}
	
	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		// To convert datatable data to Map
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		
		regpage = new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstname")); // passing the values for keys (Ex: firstname:John - which is key:value format)
		regpage.setLastName(dataMap.get("lastname"));
		regpage.setEmail(dataMap.get("email"));
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("confirmpassword"));	
	}
	
	@When("the user selects Privay Policy")
	public void the_user_selects_privay_policy() {
		regpage.setPrivacyPolicy();
	}
	
	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
		regpage.clickContinue();
	}
	
	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
}
