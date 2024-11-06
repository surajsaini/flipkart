package com.flipkart.flipkartprojectsdet;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.flipkartprojectpage.FlipkartHomePage;

public class FlipkartHomePageTest extends BaseClass {

	@Test
	public void findIphoneBelowOneLakh() {

		FlipkartHomePage fhp = new FlipkartHomePage(driver);

		fhp.enterTextinSearchBox(prop.getSearchMobile());
		fhp.searchBox.sendKeys(Keys.ENTER);
		Assert.assertTrue(fhp.productPrice() >= 6, "List of product with price above 1lakh are less then 6");
	}

}
