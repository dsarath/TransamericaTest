package br.dsarath.TransamericaTest.Tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.junit.Test;

import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Path;
import br.dsarath.TransamericaTest.Utils.Web;
import junit.framework.Assert;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = {Path.LOGINDATAPATH}, loaderType = LoaderType.CSV)
public class TC001_Login_Success_JunitDataDriven {	

	private WebDriver browser;
	
	
	@Before
	public void setUp() {
		browser = Web.createChrome();
	}

	@After
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void LoginSuccess(@Param(name="username")String username, @Param(name="password")String password) {
		LoginPage page = new LoginPage(browser);
		page.SignIn(username,password);
		Assert.assertTrue(page.IsLogged());
	}
}
