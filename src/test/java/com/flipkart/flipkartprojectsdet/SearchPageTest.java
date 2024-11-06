package com.flipkart.flipkartprojectsdet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.flipkartprojectpage.SearchPage;

public class SearchPageTest extends BaseClass {
	SearchPage SP = new SearchPage(driver, prop);

	@Test
	public void testSearchResult() throws InterruptedException {

		SP.enterTextSearchBox();
		SP.selectSuggestion();
		// Assert.assertEquals(SP.getSearchResultText(), "iphone 14");
		Assert.assertTrue(SP.getSearchResultText().contains(prop.getSearchMobile()));

	}
	
	@Test
	public void testSearchPrice() {
		
		
	}
}
