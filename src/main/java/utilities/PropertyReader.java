package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertyReader {
	
	private static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) {
		// Load data from properties file
		try {
			FileInputStream fis = new FileInputStream("../Cucumber-Test/src/test/resources/config/config.properties");
			prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		// read data
		String propertyValue = prop.get(key).toString();
		
		if(StringUtils.isEmpty(propertyValue)) {
			try {
				throw new Exception("Value is not specified for: " + key + " in Properties file");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return propertyValue;
	}

}
