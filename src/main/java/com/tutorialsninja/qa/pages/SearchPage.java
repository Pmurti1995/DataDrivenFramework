package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	 
	@FindBy(xpath = "//input[@type = 'button']/following-sibling::p")
	private WebElement invalidHondaProduct;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean displayStatusOfHPValidProduct() {
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
		
	}
	
	public String retriveNoProductMessageText() {
		String noProductMessageText = invalidHondaProduct.getText();
		return noProductMessageText;
		
	}

}
