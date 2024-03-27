package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class MenuPage {
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout; 
	
	@FindBy(how = How.LINK_TEXT, using = "Admin")
	private WebElement btnAdmin;
	
	@FindBy(how = How.ID, using = "incorrect")
	private WebElement btnElementThatCannotBeFound; 
	
	
	public void logout(){
		btnLogout.click();
	}
	
	public void admin() {
		btnAdmin.click();
	}
	
	public void clickOnElementThatCannotBeFound() {
		btnElementThatCannotBeFound.click();
	}


}
