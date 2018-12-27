package br.dsarath.TransamericaTest.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Path;
import br.dsarath.TransamericaTest.Utils.Web;
import junit.framework.Assert;

public class TC001_Login_Success {

	private WebDriver browser;
	
	@BeforeTest
	public void setUp() {
		browser = Web.createChrome();
	}

	@AfterTest
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void LoginSuccess() {
		LoginPage page = new LoginPage(browser);
		page.SignIn(Path.USERNAME,Path.PASSWORD);
		Assert.assertTrue(page.IsLogged());
	}
}
