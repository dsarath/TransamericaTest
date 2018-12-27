package br.dsarath.TransamericaTest.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DSL {
	private WebDriver browser;
	
	public DSL(WebDriver browser) {
		this.browser = browser;
	}

	public void write_byName(String value, String id) {
    	browser.findElement(By.name(id)).sendKeys(value);
	}
	public void click_byId(String id) {
		browser.findElement(By.id(id)).click();
	}
	public void click_byXpath(String xpath) {
		browser.findElement(By.xpath(xpath)).click();
	}
	public WebElement search_byXpath(String xpath) {
		return browser.findElement(By.xpath(xpath));
	}
	public WebElement searchText_byClass(String text, String className) {
		List<WebElement> list = browser.findElements(By.className(className));
		for (WebElement webElement : list) {
			if(webElement.getText().equals(text))
				return webElement;
		}
		return null;
	}
	public WebElement searchPartialText_byClass(String partialText, String className) {
		List<WebElement> list = browser.findElements(By.className(className));
		System.out.println(list);
		for (WebElement webElement : list) {
			if(webElement.getText().contains(partialText))
				return webElement;
		}
		return null;
	}
	public WebElement search_byClass(String className) {
		return browser.findElement(By.className(className));
	}
	public WebElement search_byLinkText(String text) {
		return browser.findElement(By.linkText(text));
	}
	public Boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}
}
