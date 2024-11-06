package com.flipkart.flipkartprojectpage;

import java.util.*;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {
	private WebDriver driver;

	public FlipkartHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchBox;

	public void enterTextinSearchBox(String searchItem) {
		searchBox.sendKeys(searchItem);

	}

	@FindBy(className = "KzDlHZ")
	public List<WebElement> productList;

	public List<String> productListText() {
		List<String> iphoneList = new ArrayList<>();
		for (int i = 1; i < productList.size(); i++) {
			iphoneList.add(productList.get(i).getText());
		}
		return iphoneList;
	}

	public int productPrice() {
		int count = 0;
		Map<String, String> priceMap = new HashMap<>();
		for (int i = 0; i < productListText().size(); i++) {
			String aa = "//div[contains(text(),'" + productListText().get(i)
					+ "')]/parent::div/following-sibling::div/div[1]/div[1]/div[1]";
			WebElement productPrice = driver.findElement(By.xpath(aa));
			priceMap.put(productListText().get(i), productPrice.getText());
		}
		for (Entry<String, String> price : priceMap.entrySet()) {
			String eachPrice = price.getValue();
			StringBuilder modifyEachPrice = new StringBuilder();
			for (int j = 0; j < eachPrice.length(); j++) {
				if (Character.isDigit(eachPrice.charAt(j))) {
					modifyEachPrice.append(eachPrice.charAt(j));
				}
			}
			if (Integer.parseInt(modifyEachPrice.toString()) > 100000) {
				count++;
			}
		}
		return count;
	}
}
