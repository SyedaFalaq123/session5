package test;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import page.AddAccPage;
import page.DashboardPage;
import page.LoginPage;
import page.deleteNewAcc;
import util.BrowserFactory;

public class addNewAccount {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		// Starts the browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
//		String Account = "abc"; 
//		String Description="billing";
//		String Balance= "101010.01";
	}

	@Test
	public void validUserShouldBeAbleToAddNewAccount() throws InterruptedException {

		// Take you to the site
		driver.get("http://techfios.com/test/billing/?ng=admin/");

		// Calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(2000);
		// Validate page show up using the title
		String expectedTitle = "Login - TechFios Test Application - Billing"; // To store the actual title
		String actualTitle = loginPage.getPageTitle(); // To get and store the title
		System.out.println(actualTitle); // To print
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");

		// Call the login method from the LoginPage Class
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		Thread.sleep(2000);
		
		// Validate page show up using the Explicit Wait
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class); // Object Reference
		dashboardPage.waitForPage();
		Thread.sleep(2000);
		// Validate AddAccPage page show up using the title
				
		AddAccPage AddAccPage = PageFactory.initElements(driver, AddAccPage.class); // Object Reference
		AddAccPage.waitPage();
		
		
		
		// Call the login method from the AddAccoPage Class
		
		AddAccPage.AddAcc("abc", "billing", "101010.01");
		
		//Validate the presence of "Account Created Successfully" message
		String True="Account Created Successfully";
		Assert.assertTrue(false, "Account Not Created");
		
		//method to Scroll Up/Down
		scrollDown(driver);
		Thread.sleep(2000);
		//scrollUp(driver);
		

		
	    //call delete page
		
		deleteNewAcc deleteNewAcc = PageFactory.initElements(driver, deleteNewAcc.class);
		//Thread.sleep(2000);
		
		//String False="Account Not Deleted Successfully";
		//Assert.assertfalse(true, "Account Deleted Successfull");
		String expecteDTitle = "Account Deleted Successfully "; // To store the actual title
		String actuaLTitle = deleteNewAcc.getPageAppr(); // To get and store the title
		System.out.println(actualTitle); // To print
		Assert.assertEquals(actualTitle, expectedTitle, "Not Deleted!");
	}	
		private void scrollDown(WebDriver a) {
			((JavascriptExecutor)a).executeScript("scroll(0,2000)");
			}
					

//	@AfterMethod
//	public void close() {
//		// close and quit
//		driver.close();
//		driver.quit();
//	}
}