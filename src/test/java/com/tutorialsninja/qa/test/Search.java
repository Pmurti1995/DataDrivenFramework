 package com.tutorialsninja.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorials.ninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base {
	WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;
	
	public Search(){
		super();
	}
	@BeforeMethod 
	public void setup() {
		driver = initializeBrowsweAndOpenApplicationURL(prop.getProperty("browser"));
		homePage =  new HomePage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProducts() {
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));

		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"Valid hp message is not displayed in the search box");

	}
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		searchPage = homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));

		Assert.assertEquals(searchPage.retriveNoProductMessageText(), dataProp.getProperty("NoProductTextInSearchResults"),"No product in search results is not displayed" );

	}
	@Test(priority = 3)
	public void verifySearchWithoutProvidingProductDetail() {
		searchPage = homePage.clickOnSearchButton();
		Assert.assertEquals(searchPage.retriveNoProductMessageText(),dataProp.getProperty("NoProductTextInSearchResults"),"No product message in search results is not displayed");	
	}

}
