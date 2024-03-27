package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	@FindBy (how = How.ID, using ="username")
	private WebElement fldUsername;
	
	@FindBy (how = How.ID, using ="password")
	private WebElement fldPassword;
	
	@FindBy (how = How.NAME, using ="language")
	private WebElement cboLanguage;
	
	@FindBy (how = How.TAG_NAME, using ="label")
	private WebElement btnLogin;
	
	@FindBy (how = How.XPATH, using ="//div[@id='errors']/p")
	private WebElement txtError;

	
	public void loginWith(String username, String password) {
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnLogin.click();
	}
	
	
	public void setLanguageTo(String language) {
		Select dropdown = new Select(cboLanguage);
		dropdown.selectByVisibleText(language);
	}
	
	public String getError() {
		return txtError.getText();
	}


}
