import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseTwo {
	

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumTraining\\drivers\\chromedriver-win64\\chromedriver.exe");
		
		System.out.println("Starting the test");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Navigating to google");
		driver.get("https://www.google.com/");
		String pageOneTitle = driver.getTitle();
		System.out.println("The title of the page is " + pageOneTitle);
		
		System.out.println("Navigating to bing");
		driver.get("https://www.bing.com/");
		String pageTwoTitle = driver.getTitle();
		System.out.println("The title of the page is " + pageTwoTitle);
		
		System.out.println("Navigating back");
		driver.navigate().back();
		if(driver.getTitle().equals(pageOneTitle)) {
			System.out.println("OK, I'm back at the original page");
		} else {
			System.out.println("Not OK, I'm at a different page: " + driver.getTitle());
		}
		
		System.out.println("Refreshing the page");
		driver.navigate().refresh();
		if(driver.getTitle().equals(pageOneTitle)) {
			System.out.println("OK, the page refreshed");
		} else {
			System.out.println("Not OK, I'm at a different page: " + driver.getTitle());
		}
		
		driver.quit();

	}

}
