package br.dsarath.TransamericaTest.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.dsarath.TransamericaTest.Pages.DetailsPage;
import br.dsarath.TransamericaTest.Pages.ListPage;
import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Path;
import br.dsarath.TransamericaTest.Utils.Web;
import junit.framework.Assert;

public class TC003_Invoice_Validation {
	
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
	public void Invoice_Validation() {
		new LoginPage(browser).SignIn(Path.USERNAME,Path.PASSWORD);
		DetailsPage page = new ListPage(browser).AccessInvoiceDetails();
		
		Assert.assertTrue(page.GetInvoiceDate().contains("14/01/2018"));
		Assert.assertTrue(page.GetDueDate().contains("15/01/2018"));
		Assert.assertTrue(page.GetInvoiceNumber().contains("110"));
		Assert.assertEquals("0875",page.GetBookingCode());
		Assert.assertTrue(page.GetCustomerDetails().contains("JOHNY SMITH"));
		Assert.assertTrue(page.GetCustomerDetails().contains("R2, AVENUE DU MAROC"));
		Assert.assertTrue(page.GetCustomerDetails().contains("123456"));
		Assert.assertEquals("Superior Double",page.GetRoom());
		Assert.assertEquals("14/01/2018",page.GetCheckIn());
		Assert.assertEquals("15/01/2018",page.GetCheckOut());
		Assert.assertEquals("1",page.GetTotalStayCount());
		Assert.assertEquals("$150",page.GetTotalStayAmount());
		Assert.assertEquals("USD $20.90",page.GetDepositNow());
		Assert.assertTrue(page.GetTaxVAT().contains("USD $19"));
		Assert.assertTrue(page.GetTotalAmount().contains("USD $209"));
		
	}
}
