package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddAccPage extends BasePage {

	WebDriver driver; // Global

	// Every Page must have a constructor to invite the driver
	public AddAccPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Accounts ')]")
	WebElement ContentTitle;
	
	
	
	@FindBy(how = How.ID, using = "account")
	WebElement account;
	@FindBy(how = How.ID, using = "description")
	WebElement description;
	@FindBy(how = How.NAME, using = "balance")
	WebElement balance;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),' Submit')]")
	
	WebElement SubmitButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement pageTitle;
	
	
	
	
	// Methods to interact with the elements
//	public void AddAcc(String Account, String Description, String Balance) {
//		account.sendKeys(Account);
//		description.sendKeys(Description);
//		balance.sendKeys(Balance);
//		 SubmitButton.click();
//	}
//	public void wait4Page() {
//		waitForElement(ContentTitle, driver);
//		
//	}

	public String getpAgeTitle() {
		return driver.getTitle();
	}
	public void waitPage() {
		waitForElement(ContentTitle, driver);
		
	}

	public void AddAcc(String account2, String description2, String balance2) {
		account.sendKeys(account2);
		description.sendKeys(description2);
		balance.sendKeys(balance2);
		 SubmitButton.click();
		
	}

}
