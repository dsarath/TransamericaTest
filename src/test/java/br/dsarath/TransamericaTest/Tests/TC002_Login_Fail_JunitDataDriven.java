package br.dsarath.TransamericaTest.Tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Properties;
import br.dsarath.TransamericaTest.Utils.DriverFactory;
import junit.framework.Assert;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {Properties.LOGINDATAPATH}, loaderType = LoaderType.CSV)
public class TC002_Login_Fail_JunitDataDriven {
	
	private WebDriver browser;
	
	
	@Before
	public void setUp() {
		browser = DriverFactory.createChrome();
	}

	@After
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void LoginFail(@Param(name="username")String username, @Param(name="password")String password) {
		LoginPage page = new LoginPage(browser);
		page.SignIn(username,password);
		Assert.assertTrue(page.IsWrongLoginData());
		
	}
}
