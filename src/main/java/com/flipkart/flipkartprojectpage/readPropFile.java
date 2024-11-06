package com.flipkart.flipkartprojectpage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readPropFile {
	private Properties property;

	public readPropFile() throws IOException {
		property = new Properties();
		InputStream input = new FileInputStream("resources/config.properties");
		property.load(input);
	}

	public String getURL() {
		String appURL = property.getProperty("URL");
		return appURL;
	}

	public String getUsername() {
		String username = property.getProperty("username");
		return username;
	}
	
	public String getBrowser() {
		return property.getProperty("browser");
	}
	
	public String getSearchMobile() {
		return property.getProperty("searchmobile");
	}
	
	

}
