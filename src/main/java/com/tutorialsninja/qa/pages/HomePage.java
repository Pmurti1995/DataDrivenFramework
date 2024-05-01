package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;


	//objects
	@FindBy(xpath = "//span[text() = 'My Account']") 
	private WebElement myAccountDropPage;


	@FindBy(linkText = "Login")
	private WebElement loginOptions;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchOptionField;

	@FindBy(xpath = "//div[@id = 'search']/descendant::button")
	private WebElement searchButton;

	//Create a constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//actions
	public void clickOnMyAccountDropMenu() {
		myAccountDropPage.click();

	}
	public LoginPage selectLoginOption() {
		loginOptions.click();
		return new LoginPage(driver);

	}

	public LoginPage navigateToLoginPage() {
		myAccountDropPage.click();
		loginOptions.click();
		return new LoginPage(driver);



	}
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);

	}
	
	public RegisterPage navigateToRegisterMenu() {
		myAccountDropPage.click();
		registerOption.click();
		return new RegisterPage(driver);
		
	}

	public void enterProductIntoSearchBoxField(String productText) {
		searchOptionField.sendKeys(productText);

	}

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);

       }
	
	public SearchPage searchForAProduct(String productText) {
		searchOptionField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
		
	}

}
