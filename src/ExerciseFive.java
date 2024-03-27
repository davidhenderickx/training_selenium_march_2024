import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseFive {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app-tst-training.azurewebsites.net");
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		
		PageFactory.initElements(driver, menu);
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, welcome);
		
		menu.logout();
		login.loginWith("admin","superduper");
		
		if (welcome.getWelcomeMessage().contains("Welcome")) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		

	}

}
