import java.util.Set;

import org.openqa.selenium.support.PageFactory;

import helper.DriverManager;
import helper.URLManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class ExerciseSeven {
	
public static void main(String[] args) {
		
		DriverManager.getDriver().get("https://app-tst-training.azurewebsites.net");
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		AdminPage admin = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		PageFactory.initElements(DriverManager.getDriver(), admin);
		
		//Loging in with the admin account
		menu.logout();
		login.loginWith("admin","superduper");
		
		//Opening admin page and switching to it
		String originalWindow = DriverManager.getDriver().getWindowHandle();
		menu.admin();
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for(String window: allWindows) {
			if(!originalWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
		DriverManager.getDriver().switchTo().window(newWindow);
		
		//Resetting users 
		admin.clickResetUsers();
		if(admin.getResetUsersAlertText().equals("Users reset.")){
			System.out.println("Alert box has the correct text");
		} else {
			System.out.println("Alert box doesn't have the correct text");
		}
		admin.closeResetUsersAlert();
		
		//Create user
		admin.createUser("David", "Test");
		
		//Closing the admin page and switching back to the original page
		DriverManager.getDriver().close();
		DriverManager.getDriver().switchTo().window(originalWindow);
		
		//Logging in with the newly created user
		menu.logout();
		login.loginWith("David", "Test");
	

	}

}
