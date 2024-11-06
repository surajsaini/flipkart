package com.flipkart.flipkartprojectsdet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

abstract class abc2 implements abc3 {

	public void aa() {
		System.out.println("suraj");
	}

	abstract void bb();
}

interface abc3 {

	public void aa();
}

public class TestClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone15");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		List<String> iphoneList = new ArrayList<>();
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		Map<String, String> priceMap = new HashMap<>();

		for (int i = 1; i < productList.size(); i++) {
			iphoneList.add(productList.get(i).getText());
		}

		System.out.println(iphoneList);
		System.out.println(iphoneList.size());

		for (int i = 0; i < iphoneList.size(); i++) {

			String aa = "//div[contains(text(),'" + iphoneList.get(i)
					+ "')]/parent::div/following-sibling::div/div[1]/div[1]/div[1]";

			WebElement productPrice = driver.findElement(By.xpath(aa));

			priceMap.put(iphoneList.get(i), productPrice.getText());

		}

		System.out.println(priceMap);

		driver.quit();

	}
}
