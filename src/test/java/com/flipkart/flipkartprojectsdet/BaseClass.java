package com.flipkart.flipkartprojectsdet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.flipkart.flipkartprojectpage.readPropFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public readPropFile prop;

	@BeforeTest
	public void browserSetup() throws IOException {
		prop = new readPropFile();
		browserFactory(prop.getBrowser());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getURL());
	}

	@AfterTest
	public void browserQuit() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver browserFactory(String browser) {
		driver = null;

		if (browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Browser not support");
		}
		return driver;

	}
}
