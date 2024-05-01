package com.tutorialsninja.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.utils.utilities;
import com.tutorials.ninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;

public class Register extends Base {
	WebDriver driver; 
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;

	public Register(){
		super();

	}

	@BeforeMethod	
	public void setUp() {
		driver = initializeBrowsweAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		registerPage = homePage.navigateToRegisterMenu();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test (priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		accountSuccessPage = registerPage.registerWithMandatoryField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPage(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");


	}
	@Test(priority = 2)
	public void verifyRegisteringAnAccountWithAllFields() {
		accountSuccessPage = registerPage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPage(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");


	}


	@Test (priority = 3)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(dataProp.getProperty("privacyPolicyWarning"),dataProp.getProperty("firstNameWarning"),dataProp.getProperty("lastNameWarning"),dataProp.getProperty("emailWarning"),dataProp.getProperty("telephoneWarning"),dataProp.getProperty("passwordWarning")));


	}


}


