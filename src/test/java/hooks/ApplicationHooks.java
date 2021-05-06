package hooks;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import testBase.BrowserFactory;
import testBase.DriverFactory;
import utilities.PropertyReader;

public class ApplicationHooks {

	BrowserFactory browserFactory = new BrowserFactory();
	
	@Before
	public void launchBrowser() {
		String browserName = PropertyReader.getPropertyValueByKey("browser");
		DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browserName));
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(PropertyReader.getPropertyValueByKey("applicationURL"));
	}
	
	@After
	public void tearDown() {
		DriverFactory.getInstance().CloseCurrentBrowser();
	}
}
