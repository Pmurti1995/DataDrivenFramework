package com.tutorials.ninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.tutorialsninja.utils.utilities;


public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public  Base() {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis = new FileInputStream(dataPropFile);
		dataProp.load(datafis);
		}
		catch(Throwable e) {
			e.printStackTrace();
			
		}
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
			
		}

	}

	public WebDriver initializeBrowsweAndOpenApplicationURL(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.Implicit_Wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PageLoad_Wait_Time));
		driver.get(prop.getProperty("url"));

		return driver;



	}

}
