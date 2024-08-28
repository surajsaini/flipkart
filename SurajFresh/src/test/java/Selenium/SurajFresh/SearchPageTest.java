package Selenium.SurajFresh;

import org.testng.Assert;
import org.testng.annotations.Test;

import WebPage1.SearchPage;
import WebPage1.BaseClass;

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
