import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseFour {
	
	public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\drivers\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://app-tst-training.azurewebsites.net");
			
			driver.findElement(By.xpath("//a[@id='logout']")).click();
		
			
			WebElement fldUsername = driver.findElement(By.cssSelector("#username"));
			fldUsername.clear();
			fldUsername.sendKeys("admin");
			
			WebElement fldPassword = driver.findElement(By.cssSelector("input[id='password']"));
			fldPassword.clear();
			fldPassword.sendKeys("superduper");
			
			driver.findElement(By.className("content")).click();
			
			driver.quit();
	
	}

}
