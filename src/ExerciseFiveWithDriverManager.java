import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import helper.URLManager;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseFiveWithDriverManager {

	public static void main(String[] args) {
		
		//DriverManager.setFireFoxDriver();
		URLManager.OpenApplication();
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		
		menu.logout();
		login.loginWith("admin","superduper");
		
		if (welcome.getWelcomeMessage().contains("Welcome")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		DriverManager.quitDriver();

	}

}
