package homeWork5;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class session5 {

	WebDriver driver;
	// Scenario: Add new account on Techfios Site ​
//	Beginner:
//	1: Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
//	2. Enter username: techfiosdemo@gmail.com
//	3. Enter password: abc123
//	4. Click login button
//	5. Click on Bank & Cash
//	6. Click on New Account
//	7. Fill in the Add New Account Form (Randomize Account Title and Balance)
//	8. Click submit,
//
//	​Intermediate:
//	9. Validate the presence of "Account Created Successfully" message
//
//	Advance: 
//	10. Scroll Down,
//	11. Validate new account showed up in the bottom of the table
//	12. ​Delete that account
//	13. Validate account deleted from the bottom of the table
	@Test
	public void launchPage() throws InterruptedException {
		
	
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver 9.38.25 PM");
		// Create ChromeDriver object and launch chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Element Library
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");

		driver.findElement(By.id("password")).sendKeys("abc123");
		Thread.sleep(2000);
		driver.findElement(By.name("login")).click();

		driver.findElement(By.xpath("//*[contains(text(),'Dashboard')]"));
		driver.findElement(By.className("nav-label")).click();

		driver.findElement(By.linkText("Bank & Cash")).click();
		// *[contains(text(),'Bank & Cash')]
		driver.findElement(By.linkText("New Account")).click();
		// *[contains(text(),'New Account')]

		driver.findElement(By.xpath("//*[contains(text(),'Accounts ')]")).click();
		
		Thread.sleep(2000);
		Random Pizza = new  Random();
		
		String con = String.valueOf(Pizza.nextInt(9999));
		
		System.out.println(con);
		
		WebElement Acc = driver.findElement(By.id("account")); //("//input[@id='account']"));
		Acc.sendKeys(con);

		WebElement Billing = driver.findElement(By.id("description"));//(By.xpath("//input[@id='description']"));
		Billing.sendKeys("billing");

		WebElement Balance = driver.findElement(By.id("balance"));//(By.xpath("//input[@id='balance']"));
		Balance.sendKeys("100");

		driver.findElement(By.xpath("//*[contains(text(),' Submit')]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,15000)");
		
		Thread.sleep(2000);
		
		WebElement delete = driver.findElement(By.xpath("//td[text()='"+con+"']/parent::tr/descendant::i[2]")); 
		delete.click();
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(10); 	
		   
//		//pop out alert
		WebElement OK_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[text()='OK']")); 
		OK_BUTTON_ELEMENT.click();
		
//		
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		
//		driver.close();
//		driver.quit();

	}

	private JavascriptExecutor getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void waitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


}
