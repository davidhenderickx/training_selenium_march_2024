import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseTen {
	
	
	public static MenuPage menu ;
	public static LoginPage login;
	public static WelcomePage welcome;
	public static AdminPage admin;
	

	@BeforeAll
	public static void setup() {
		menu = new MenuPage();
		login = new LoginPage();
		welcome = new WelcomePage();
		admin = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		PageFactory.initElements(DriverManager.getDriver(), admin);
	}
	
	@BeforeEach
	public void initializingApp() {
		DriverManager.getDriver().get("https://app-tst-training.azurewebsites.net");
		menu.logout();
	}
	
	@AfterAll
	public static void teardown() {
		DriverManager.quitDriver();
	}
	
	@Test
	public void loggingInWithCorrectUsernameAndPassword() {
		login.loginWith("admin", "superduper");
		Assert.assertTrue(welcome.isWelcomeMessageShown());
	}
	
	@Test
	public void loggingInWithIncorrectPassword() {
		login.loginWith("admin", "wrong");
		Assert.assertFalse(welcome.isWelcomeMessageShown());
	}
	
	
	@Test
	public void loggingInWithIncorrectUsername() {
		login.loginWith("wrong", "superduper");
		Assert.assertFalse(welcome.isWelcomeMessageShown());
	}
	
	@Test
	public void loggingInWithEmptyCredetials() {
		login.loginWith("", "");
		Assert.assertFalse(welcome.isWelcomeMessageShown());
	}
	
	
	
	

}
