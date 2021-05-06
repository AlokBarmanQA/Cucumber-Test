package stepDefinitions;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HRM_LoginPage_Objects;

public class HRM_LoginPage_Steps {

	HRM_LoginPage_Objects loginPage_Objects = new HRM_LoginPage_Objects();
	
	@Given("User is on application login page")
	public void user_is_on_application_login_page() {
//		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("Execution is starting..>>>...");
//		driver.get(PropertyReader.getPropertyValueByKey("applicationURL"));
	}

	@When("User login using userid as {string} and password as {string}")
	public void user_login_using_userid_as_and_password_as(String un, String pwd) {
		loginPage_Objects.login_application(un, pwd);
	}

	@Then("User should be get {string} login status")
	public void user_should_be_get_login_status(String expectedResult) {
		String actualResult = null;
		try {
			if(loginPage_Objects.get_error_message().contains("Password cannot be empty")) {
				actualResult = "Password cannot be empty";
			}
			else if(loginPage_Objects.get_error_message().equalsIgnoreCase("Username cannot be empty")) {
				actualResult = "Username cannot be empty";
			}
		} catch (Exception e) {
			actualResult = loginPage_Objects.get_dashboard_text();
		}
		Assert.assertEquals(expectedResult, actualResult);
	}
}
