package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;

	//objects
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInformationOption;


	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//actions
	public boolean getDisplayStatusOfAccountInformationOption() {
		boolean displayStatus = editAccountInformationOption.isDisplayed();
		return displayStatus;
	}

}
