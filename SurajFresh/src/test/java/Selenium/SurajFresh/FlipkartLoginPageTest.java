package Selenium.SurajFresh;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import WebPage1.FlipkartLoginPage;
import WebPage1.BaseClass;

public class FlipkartLoginPageTest extends BaseClass {

	@Test
	public void test() throws IOException, InterruptedException {
		FlipkartLoginPage addNewCustomer = new FlipkartLoginPage(driver);

		addNewCustomer.clickOnLoginButton();
		addNewCustomer.enterEmailId(prop.getUsername());
		addNewCustomer.requestOtpButton();
		Thread.sleep(30000);
	//	addNewCustomer.clickVerifyButton();
	//	assert.assertEquals(null, null);
		Assert.assertFalse(addNewCustomer.loginButton.isDisplayed(), "Case is passed");
		

	}
}
