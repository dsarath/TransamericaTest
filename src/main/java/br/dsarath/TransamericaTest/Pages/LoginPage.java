package br.dsarath.TransamericaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver browser) {
		super(browser);
	}
	
	public void SignIn(String username, String password) {
		dsl.write_byName(username, "username");
		dsl.write_byName(password, "password");
		dsl.click_byId("btnLogin");
	}
	
	public Boolean IsLogged() {
		try {//Valida se o botão de Logout e o texto de Invoice List estão presentes na página
			return dsl.isDisplayed(dsl.search_byLinkText("Logout"))
					&& dsl.isDisplayed(dsl.searchText_byClass("Invoice List", "mt-5")); 
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
	
	public Boolean IsWrongLoginData() {
		try {//Valida se a mensagem de erro está sendo exibida e se o texto está correto
			return dsl.isDisplayed(dsl.search_byXpath("//div[@role='alert']"))
					&& dsl.search_byXpath("//div[@role='alert']").getText().equals("Wrong username or password."); 
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}
