package com.flipkartpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLoginPage {

	private WebDriver driver;

	public FlipkartLoginPage(WebDriver driver) throws IOException {

		 this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//div//span[@role='button']")
	public WebElement loginCloseButton;

	public void clickOnLogicCloseButton() {
		loginCloseButton.click();
	}

	@FindBy(xpath = ".//span[text()='Login']")
	public WebElement loginButton;

	public void clickOnLoginButton() {
		loginButton.click();
	}

	@FindBy(xpath = ".//input[@type='text' and contains(@class,'r4vIwl')]")
	private WebElement enterEmail;

	public void enterEmailId(String email) {
		enterEmail.sendKeys(email);
	}

	@FindBy(xpath = ".//button[text()='Request OTP']")
	private WebElement clickLoginButton;

	public void requestOtpButton() {
		clickLoginButton.click();
	}

	@FindBy(xpath = ".//button[text()='Verify']")
	private WebElement verifyButton;

	public void clickVerifyButton() {
		verifyButton.click();
	}
	
	@FindBy(xpath = "//a[@class='_1TOQfO' and @title='Suraj']")
	private WebElement profileButton;
	
	public void mouseHoverOnProfile() {
		Actions a = new Actions(driver);
		a.moveToElement(profileButton).perform();
	}
	
	
}
