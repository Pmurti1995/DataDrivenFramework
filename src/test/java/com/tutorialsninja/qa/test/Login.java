package com.tutorialsninja.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.utils.utilities;
import com.tutorials.ninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;


public class Login extends Base {
	WebDriver driver;
	LoginPage loginPage;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		driver = initializeBrowsweAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		loginPage =homePage.navigateToLoginPage();


	} 

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	@Test (priority = 1,dataProvider = "validCredentialsSuppliers")
	public void loginWithValidCredentials(String email, String password){

		AccountPage accountPage = loginPage.login(email, password);
		Assert.assertTrue (accountPage.getDisplayStatusOfAccountInformationOption(),"Edit Your Account Information option is not displayed");

	}
	@DataProvider(name = "validCredentialsSuppliers")
	public Object[][] dataSupplier() {
		Object[][] data = utilities.getTestDataFromExcel("Login");

		return data;

	}
	@Test (priority = 2)
	public void loginwithInvalidcredentials() {
		loginPage.login(utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.emailPasswordWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected warning message is not displayed");


	}
	@Test(priority = 3)
	public void loginWithInvalidEmailValidPass() {
		loginPage.login(utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.emailPasswordWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected warning message is not displayed");


	}
	@Test(priority = 4)
	public void loginWithValidEmailInvalidPass() {
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.emailPasswordWarningMessage().contains(dataProp.getProperty("emailPasswordNoMatchWarning")),"Expected warning message is not displayed");

	}
	@Test(priority = 5)
	public void loginWithoutProvidingCredentials() {
		loginPage.clickLoginButton();
		String actualWarningMessage = loginPage.emailPasswordWarningMessage();
		String expectedWarningMessage =dataProp.getProperty("emailPasswordNoMatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected warning message is not displayed");

	}



}
