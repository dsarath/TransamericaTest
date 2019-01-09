package br.dsarath.TransamericaTest.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.DriverFactory;
import junit.framework.Assert;

public class TC002_Login_Fail {
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
	public void LoginFail1() {
		LoginPage page = new LoginPage(browser);
		page.SignIn("Demouser","abc123");
		Assert.assertTrue(page.IsWrongLoginData());
	}
	
	@Test
	public void LoginFail2() {
		LoginPage page = new LoginPage(browser);
		page.SignIn("demouser_","xyz");
		Assert.assertTrue(page.IsWrongLoginData());
	}
	
	@Test
	public void LoginFail3() {
		LoginPage page = new LoginPage(browser);
		page.SignIn("demouser","nananana");
		Assert.assertTrue(page.IsWrongLoginData());
	}
	
	@Test
	public void LoginFail4() {
		LoginPage page = new LoginPage(browser);
		page.SignIn("Demouser","abc123");
		Assert.assertTrue(page.IsWrongLoginData());
	}
}
