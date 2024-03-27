package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.DriverManager;



public class AdminPage {
	
	@FindBy (how = How.XPATH, using ="//td[@onclick='resetUsers(true)']/label")
	private WebElement btnResetUsers;
	
	@FindBy (how = How.ID, using ="new_username")
	private WebElement fldUsername;
	
	@FindBy (how = How.ID, using ="new_password")
	private WebElement fldPassword;
	
	@FindBy (how = How.XPATH, using ="//td[@onclick='createUser()']/span")
	private WebElement btnCreate;
	
	
	public void clickResetUsers() {
		btnResetUsers.click();		
	}
	
	public String getResetUsersAlertText() {
		return DriverManager.getDriver().switchTo().alert().getText();
	}
	
	public void closeResetUsersAlert() {
		DriverManager.getDriver().switchTo().alert().accept();
	}
	
	
	public void createUser(String username, String password) {
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		btnCreate.click();
	}

}
