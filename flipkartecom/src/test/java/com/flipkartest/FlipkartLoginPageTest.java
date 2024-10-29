package com.flipkartest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkartpages.FlipkartLoginPage;
// import com.flipkart.flipkartprojectsdet.BaseClass;

public class FlipkartLoginPageTest extends BaseClass {

	@Test
	public void test() throws IOException, InterruptedException {
		FlipkartLoginPage addNewCustomer = new FlipkartLoginPage(driver);

		addNewCustomer.clickOnLoginButton();
		addNewCustomer.enterEmailId(prop.getUsername());
		addNewCustomer.requestOtpButton();
		Thread.sleep(30000);
		addNewCustomer.mouseHoverOnProfile();
		// addNewCustomer.clickVerifyButton();
		// assert.assertEquals(null, null);
		// Assert.assertFalse(addNewCustomer.loginButton.isDisplayed(), "Case is
		// passed");

	//	Actions a = new Actions(driver);
	//	a.moveToElement(driver.findElement(By.xpath("//a[@class='_1TOQfO' and @title='Suraj']"))).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//div//img[@alt='Logout']")).isDisplayed());

	}
}
