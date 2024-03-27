package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {
	
	
	@FindBy (how = How.ID, using ="welcome")
	private WebElement txtWelcome;
	
	
	public String getWelcomeMessage() {
		String welcomeText = txtWelcome.getText();
		System.out.println(welcomeText);
		return welcomeText;
	}

	public Boolean isWelcomeMessageShown() {
		return txtWelcome.isDisplayed();
	}

}
