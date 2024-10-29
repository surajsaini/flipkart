package com.flipkartest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void flipkartSearchTest() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone15");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		System.out.println(driver.findElement(By.xpath(
				"//div[contains(text(),'Apple iPhone 15 Plus (Black, 128 GB)')]/parent::div/following-sibling::div/div[1]/div[1]/div[1]"))
				.getText());
	}
	
	

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}