package br.dsarath.TransamericaTest.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Properties;
import br.dsarath.TransamericaTest.Utils.DriverFactory;
import junit.framework.Assert;

public class TC001_Login_Success {

	private WebDriver browser;
	
	@BeforeMethod
	public void setUp() {
		browser = DriverFactory.createChrome();
	}

	@AfterMethod
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void LoginSuccess() {
		LoginPage page = new LoginPage(browser);
		page.SignIn(Properties.USERNAME,Properties.PASSWORD);
		Assert.assertTrue(page.IsLogged());
	}
}
