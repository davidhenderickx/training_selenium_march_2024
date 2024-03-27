import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseThree {
	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://app-tst-training.azurewebsites.net");
		
		driver.findElement(By.id("logout")).click();
		
		WebElement languageDropdown = driver.findElement(By.name("language"));
		Select selLanguage = new Select(languageDropdown);
		selLanguage.selectByVisibleText("French");
		
		WebElement fldUsername = driver.findElement(By.id("username"));
		fldUsername.clear();
		fldUsername.sendKeys("admin");
		
		WebElement fldPassword = driver.findElement(By.id("password"));
		fldPassword.clear();
		fldPassword.sendKeys("superduper");
		
		driver.findElement(By.tagName("label")).click();
		
		driver.quit();
		
		
		
}

}
