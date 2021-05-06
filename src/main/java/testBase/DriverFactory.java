package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	// Singleton design pattern
	private DriverFactory() {

	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	// Factory design pattern->define separate factory methods for creating objects and create objects by calling methods
	//	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void setDriver(WebDriver driverParameter) {
		driver.set(driverParameter);
	}
	public  WebDriver getDriver() {
		return driver.get();
	}
	public void CloseCurrentBrowser() {
		driver.get().close();
		driver.remove();
	}

}
