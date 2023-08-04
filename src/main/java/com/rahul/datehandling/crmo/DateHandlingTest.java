package com.rahul.datehandling.crmo;

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

import com.rahul.crmo.Data;

public class DateHandlingTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");
	}
	
	@Test
	public void loginSteps()
	{
		driver.findElement(By.name("username")).sendKeys("rahulkr1999");
	    driver.findElement(By.name("password")).sendKeys("Rahul@123");
	   
	    WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", loginBtn);
	    
	    
	    
	 // Explicitly wait for the mainpanel frame to be available
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mainpanel"));

	     // Explicitly wait for the element with name "slctMonth" to be visible and accessible
	     WebElement slctMonthElement = wait.until(ExpectedConditions
	    		 .visibilityOfElementLocated(By.name("slctMonth")));

	     // Use the Select class to interact with the dropdown and select the month
	     Select select = new Select(slctMonthElement);
	     select.selectByVisibleText(DateHandling.monthMap().get(12));

	}
	
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
	

}
