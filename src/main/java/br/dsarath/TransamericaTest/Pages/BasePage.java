package br.dsarath.TransamericaTest.Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver browser;
    protected DSL dsl;

    public BasePage(WebDriver browser) {
        this.browser = browser;
        this.dsl = new DSL(browser);
    }
}
