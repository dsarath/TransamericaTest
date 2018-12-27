package br.dsarath.TransamericaTest.Pages;

import org.openqa.selenium.WebDriver;

public class DetailsPage extends BasePage {

	public DetailsPage(WebDriver browser) {
		super(browser);
	}

	public String GetInvoiceDate() {
		return dsl.search_byXpath("/html/body/section/div/ul/li[1]").getText();
	}
	
	public String GetDueDate() {
		return dsl.search_byXpath("/html/body/section/div/ul/li[2]").getText();
	}

	public String GetInvoiceNumber() {
		return dsl.search_byXpath("/html/body/section/div/h6").getText();
	}

	public String GetBookingCode() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[1]/td[2]").getText();
	}

	public String GetCustomerDetails() {
		return dsl.search_byXpath("/html/body/section/div/div").getText();
	}

	public String GetRoom() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[2]/td[2]").getText();
	}

	public String GetCheckIn() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[5]/td[2]").getText();
	}

	public String GetCheckOut() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[6]/td[2]").getText();
	}

	public String GetTotalStayCount() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[3]/td[2]").getText();
	}

	public String GetTotalStayAmount() {
		return dsl.search_byXpath("/html/body/section/div/table[1]/tbody/tr[4]/td[2]").getText();
	}

	public String GetDepositNow() {
		return dsl.search_byXpath("/html/body/section/div/table[2]/tbody/tr/td[1]").getText();
	}

	public String GetTaxVAT() {
		return dsl.search_byXpath("/html/body/section/div/table[2]/tbody/tr/td[2]").getText();
	}

	public String GetTotalAmount() {
		return dsl.search_byXpath("/html/body/section/div/table[2]/tbody/tr/td[3]").getText();
	}

}
