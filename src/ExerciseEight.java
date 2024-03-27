import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import helper.CustomListener;
import helper.DriverManager;
import helper.URLManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseEight {
	
public static void main(String[] args) {
	
	    WebDriver normalDriver = DriverManager.getDriver();
	    WebDriverListener listener = new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		
		
		eventDriver.get("https://app-tst-training.azurewebsites.net");
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		AdminPage admin = new AdminPage();
		
		PageFactory.initElements(eventDriver, menu);
		PageFactory.initElements(eventDriver, login);
		PageFactory.initElements(eventDriver, welcome);
		PageFactory.initElements(eventDriver, admin);
		
		//Loging in with the admin account
		menu.logout();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		login.loginWith("admin","superduper");
		
		menu.clickOnElementThatCannotBeFound();
		
	

	}

}
