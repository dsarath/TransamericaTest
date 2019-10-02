package br.dsarath.TransamericaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends BasePage {

	public DetailsPage(WebDriver browser) {
		super(browser);
	}

	public String GetInvoiceDate() {
		return dsl.search_byXpath("//span[contains(text(), 'Invoice Date')]/..").getText();
	}
	
	public String GetDueDate() {
		return dsl.search_byXpath("//span[contains(text(), 'Due Date')]/..").getText();
	}

	public String GetInvoiceNumber() {
		return dsl.search_byXpath("//h6").getText();
	}

	public String GetBookingCode() {
		return dsl.search_byXpath("//td[.='Booking Code']/../*[last()]").getText();
	}

	public String GetCustomerDetails() {
		return dsl.search_byXpath("//div[@class='container']//div").getText();
	}

	public String GetRoom() {
		return dsl.search_byXpath("//td[.='Room']/../*[last()]").getText();
	}

	public String GetCheckIn() {
		return dsl.search_byXpath("//td[.='Check-In']/../*[last()]").getText();
	}

	public String GetCheckOut() {
		return dsl.search_byXpath("//td[.='Check-Out']/../*[last()]").getText();
	}

	public String GetTotalStayCount() {
		return dsl.search_byXpath("//td[.='Total Stay Count']/../*[last()]").getText();
	}

	public String GetTotalStayAmount() {
		return dsl.search_byXpath("//td[.='Total Stay Amount']/../*[last()]").getText();
	}

	public String GetDepositNow() {
		return dsl.search_byXpath("//td[contains(text(),'Deposit Nowt')]/../../../tbody//td[1]").getText();
	}

	public String GetTaxVAT() {
		return dsl.search_byXpath("//td[contains(text(),'Tax&VAT')]/../../../tbody//td[2]").getText();
	}

	public String GetTotalAmount() {
		return dsl.search_byXpath("//td[contains(text(),'Total Amount')]/../../../tbody//td[3]").getText();
	}
	
	public WebElement GetHotelName() {
		return browser.findElement(By.xpath("//div[@class='container']/h4"));
	}
	
	public Boolean ValidateHotelName(String name) {
		return name.equals(dsl.search_byXpath("//div[@class='container']/h4").getText());
	}
}
