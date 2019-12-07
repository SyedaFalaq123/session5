package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class deleteNewAcc extends BasePage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public deleteNewAcc(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	
	@FindBy(how = How.ID, using = "//*[@id=\"did621\"]")
	WebElement deletebutton;

	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'OK')]")
	WebElement OKbutton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement pageTitle;
//	public void AddAcc(String account2, String description2, String balance2) {
//		account.sendKeys(account2);
//		description.sendKeys(description2);
//		balance.sendKeys(balance2);
//		 SubmitButton.click();
	
	// Methods to interact with the elements
	public void waitpage() {
		waitForElement(pageTitle, driver);
	}
	public void deleteoption() {
		deletebutton.click();
	}
	public void OKoption() {
		OKbutton.click();
	}

	public String getPageAppr() {
		return driver.getTitle();
	}
	
	public boolean accDeletedSucc() {
		try {
			waitpage();
			return true;
		} catch (Exception e) {

		}
		return false;
	}
}

