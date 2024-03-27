package helper;

public class URLManager {
	
	public static void OpenApplication() {
		DriverManager.getDriver().get("https://app-tst-training.azurewebsites.net");
	}

}
