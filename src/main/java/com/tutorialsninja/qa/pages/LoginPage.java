package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	//objects
	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value = 'Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarningMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);

	}
	public void enterPasswordAddress(String passwordText) {
		passwordField.sendKeys(passwordText);

	}
	public AccountPage clickLoginButton() {
		loginButton.click();
		return new AccountPage(driver);


	}

	public AccountPage login(String emailText, String passwordText) {
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);


	}

	public String emailPasswordWarningMessage() {
		String warningText = emailPasswordNotMatchingWarningMessage.getText();
		return warningText;

	}


}
