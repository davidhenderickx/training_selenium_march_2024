import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExerciseOne {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\drivers\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumTraining\\drivers\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		
		System.out.println("Starting the test");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver1 = new FirefoxDriver();
		driver.get("https://be.ctg.com/");
		//driver1.get("https://www.google.be/");
		System.out.println("The title of the page is " + driver.getTitle());
		System.out.println("The test has ended");

	}

}