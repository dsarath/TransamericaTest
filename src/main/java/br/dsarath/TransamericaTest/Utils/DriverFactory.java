package br.dsarath.TransamericaTest.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver createChrome() {
		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", Properties.WEBDRIVERPATH);
		WebDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Navegando para a main URL!
		browser.get(Properties.BASEURL);
		
		return browser;
	}
}
