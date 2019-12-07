package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {

	WebDriver driver; // Global

	// Every Page must have a constructor to invite the driver
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Dashboard')]")
	WebElement PageTItle;

	@FindBy(how = How.LINK_TEXT, using = "Bank & Cash")
	WebElement BankCashButton;
//	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Bank & Cash')]")
//	WebElement BankCashButton;
	
	@FindBy(how = How.LINK_TEXT, using = "New Account")
	WebElement NewAccButton;
//	@FindBy(how = How.XPATH, using = "//*[contains(text(),'New Account')]")
//	WebElement NewAccountButton;
	
	
	// Methods to interact with the elements
	public void waitForPage() {
		waitForElement(PageTItle, driver);
	}

	public void BankCashButton() {
		BankCashButton.click();
		
	}
	public void clickOnNewAccButton() {
		NewAccButton.click();
		
	}
	
	
	public boolean isDashboardDisplayed() {
		try {
			waitForPage();
			return true;
		} catch (Exception e) {

		}
		return false;
	}
}
