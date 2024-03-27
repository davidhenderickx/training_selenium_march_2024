import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseEleven {
	
	
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
	
	@ParameterizedTest
	@CsvSource({
		"admin,incorrect,Unable to log in with the given credentials. Please try again.",
		"incorrect,superduper,Unable to log in with the given credentials. Please try again.",
		",,Please fill in all the fields."
	})
	public void loggingInWithIncorrectCredentials(String username, String password, String error) {
		
		if(username == null) {
			username = "";	
		}
		if(password == null) {
			password = "";	
		}
		login.loginWith(username, password);
		Assert.assertTrue(login.getError().equals(error));
	}
	
	
	
	
	

}
