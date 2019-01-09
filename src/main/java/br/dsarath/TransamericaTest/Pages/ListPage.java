package br.dsarath.TransamericaTest.Pages;

import org.openqa.selenium.WebDriver;

public class ListPage extends BasePage {
	public ListPage(WebDriver browser) {
		super(browser);
	}
	
	public DetailsPage AccessInvoiceDetails() {
		dsl.click_byXpath("//a[@href='/invoice/0']");
		//muda o foco para janela de detalhes que foi aberta
		browser.switchTo().window((String)browser.getWindowHandles().toArray()[1]);
		return new DetailsPage(browser);
	}
}
