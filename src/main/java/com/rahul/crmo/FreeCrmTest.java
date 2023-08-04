package com.rahul.crmo;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCrmTest {

	public WebDriver driver;
	public String credentials;
	public String[] credentialsInfo;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("https://classic.freecrm.com/index.html");
		Thread.sleep(3000);
	}

	@Test(priority=1)
	public void loginWithCustomerUserTest() throws InterruptedException 
	{
	     credentials = Data.getUserLoginInfo().get("customer");
	     credentialsInfo = credentials.split("_");

	     driver.findElement(By.name("username")).sendKeys(credentialsInfo[0]);
	     driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);

	     WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click();", loginBtn);

	     // Explicitly wait for the mainpanel frame to be available
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));

	     // Explicitly wait for the element with name "slctMonth" to be visible and accessible
	     WebElement slctMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("slctMonth")));

	     // Use the Select class to interact with the dropdown and select the month
	     Select select = new Select(slctMonthElement);
	     select.selectByVisibleText(Data.monthMap().get(10));
	}
	
	
	@Test(priority=2)
	public void loginWithAdminUserTest() throws InterruptedException {
	     credentials = Data.getUserLoginInfo().get("admin");
	     credentialsInfo = credentials.split("_");

	     driver.findElement(By.name("username")).sendKeys(credentialsInfo[0]);
	     driver.findElement(By.name("password")).sendKeys(credentialsInfo[1]);

	     WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click();", loginBtn);

	     // Explicitly wait for the mainpanel frame to be available
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));

	     // Explicitly wait for the element with name "slctMonth" to be visible and accessible
	     WebElement slctMonthElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("slctMonth")));

	     // Use the Select class to interact with the dropdown and select the month
	     Select select = new Select(slctMonthElement);
	     select.selectByVisibleText(Data.monthMap().get(1));

	}


	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
