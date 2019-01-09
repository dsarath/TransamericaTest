package br.dsarath.TransamericaTest.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.dsarath.TransamericaTest.Pages.DSL;
import br.dsarath.TransamericaTest.Pages.DetailsPage;
import br.dsarath.TransamericaTest.Pages.ListPage;
import br.dsarath.TransamericaTest.Pages.LoginPage;
import br.dsarath.TransamericaTest.Utils.Properties;
import br.dsarath.TransamericaTest.Utils.DriverFactory;
import junit.framework.Assert;

public class TC003_Invoice_Validation {
	
	private WebDriver browser;
	private DetailsPage page;
	
	
	@BeforeClass
	public void setUp() {
		browser = DriverFactory.createChrome();
		new LoginPage(browser).SignIn(Properties.USERNAME,Properties.PASSWORD);
		page = new ListPage(browser).AccessInvoiceDetails();
	}

	@AfterClass
	public void tearDown() {
		browser.quit();
	}
	
	@Test
	public void Invoice_Validation_InvoiceDate() {
		Assert.assertTrue(page.GetInvoiceDate().contains("14/01/2018"));
	}
	
	@Test
	public void Invoice_Validation_DueDate() {
		Assert.assertTrue(page.GetDueDate().contains("15/01/2018"));
	}
	
	@Test
	public void Invoice_Validation_InvoiceNumber() {
		Assert.assertTrue(page.GetInvoiceNumber().contains("110"));
	}
	@Test
	public void Invoice_Validation_BookingCode() {
		Assert.assertEquals("0875",page.GetBookingCode());
	}
	@Test
	public void Invoice_Validation_CustomerDetails() {
		Assert.assertTrue(page.GetCustomerDetails().contains("JOHNY SMITH"));
		Assert.assertTrue(page.GetCustomerDetails().contains("R2, AVENUE DU MAROC"));
		Assert.assertTrue(page.GetCustomerDetails().contains("123456"));
	}
	@Test
	public void Invoice_Validation_Room() {
		Assert.assertEquals("Superior Double",page.GetRoom());
	}
	@Test
	public void Invoice_Validation_CheckIn() {
		Assert.assertEquals("14/01/2018",page.GetCheckIn());
	}
	@Test
	public void Invoice_Validation_CheckOut() {
		Assert.assertEquals("15/01/2018",page.GetCheckOut());
	}
	@Test
	public void Invoice_Validation_StayCount() {
		Assert.assertEquals("1",page.GetTotalStayCount());
	}
	@Test
	public void Invoice_Validation_HotelName() {
		Assert.assertTrue((browser.findElement(By.xpath("//div[@class='container']/h4")).getText()).equals("Rendezvous Hotel"));
	}
	@Test
	public void Invoice_Validation_Amount() {
		Assert.assertTrue(page.GetTotalAmount().contains("USD $209"));
	}
	@Test
	public void Invoice_Validation_TaxVAT() {
		Assert.assertTrue(page.GetTaxVAT().contains("USD $19"));
	}
	@Test
	public void Invoice_Validation_DepositNow() {
		Assert.assertEquals("USD $20.90",page.GetDepositNow());
	}
	@Test
	public void Invoice_Validation_StayAmount() {
		Assert.assertEquals("$150",page.GetTotalStayAmount());
	}
}
