package Selenium.SurajFresh;

import java.util.List;
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
	
	abstract void bb ();
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
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone14");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		System.out.println(
				driver.findElement(By.xpath("//div[contains(@class,'WOvzF4')]//span[@class='BUOuZu']")).getText());

		// driver.findElement(By.xpath("//ul//li[3]")).click();

		driver.quit();

	}
}
