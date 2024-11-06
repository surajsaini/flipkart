package com.flipkart.flipkartprojectpage;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchPage {
	
	public readPropFile prop;

//	WebDriverWait wait = new WebDriverWait(driver,10);

	public SearchPage(WebDriver driver, readPropFile prop) {
		PageFactory.initElements(driver, this);
		this.prop=prop;
	}

	@FindBy(xpath = ".//input[@type='text']")
	private WebElement searchBox;

	public void enterTextSearchBox() {
		searchBox.sendKeys("iphone");
	}

	@FindBy(xpath = "//ul//li//div//a//div[2]")
	private List<WebElement> suggestionOption;

	public void selectSuggestion() throws InterruptedException {
		for (WebElement we : suggestionOption) {
			try {
				if (we.getText().contains(prop.getSearchMobile())) {
					 Thread.sleep(3000);
					we.click();
					break;
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element is detected");
			}
		}

	}

	@FindBy(xpath = "//div[contains(@class,'WOvzF4')]//span[@class='BUOuZu']")
	private WebElement searchResultText;

	public String getSearchResultText() {
		String text = searchResultText.getText();
		return text;

	}

}
