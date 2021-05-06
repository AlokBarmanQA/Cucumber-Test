package pageObjects;

import org.openqa.selenium.By;
import testBase.DriverFactory;
import utilities.PropertyReader;

public class HRM_LoginPage_Objects {

//	By ERROR_MESSAGE =By.cssSelector("span#spanMessage");
	
	By txt_username = By.name("txtUsername");
	By txt_password = By.id("txtPassword");
	By btn_loginButton = By.xpath("//*[@id='btnLogin']");
	By dashboardText = By.xpath("//*[@id='content']/div/div[1]/h1");
	By txt_welcome = By.id("welcome");
	By error_message = By.id("spanMessage");
	
	public String get_page_title() {
		return DriverFactory.getInstance().getDriver().getTitle();
	}
	public void login_application(String un, String pwd) {
		DriverFactory.getInstance().getDriver().findElement(txt_username).sendKeys(PropertyReader.getPropertyValueByKey("username"));
		DriverFactory.getInstance().getDriver().findElement(txt_password).sendKeys(PropertyReader.getPropertyValueByKey("password"));
		DriverFactory.getInstance().getDriver().findElement(btn_loginButton).click();
	}
	public String get_dashboard_text() {
		return DriverFactory.getInstance().getDriver().findElement(dashboardText).getText();
	}
	public String verify_welcome_text() {
		return DriverFactory.getInstance().getDriver().findElement(txt_welcome).getText();
	}
	public String get_error_message() {
		return DriverFactory.getInstance().getDriver().findElement(error_message).getText();
	}
}
