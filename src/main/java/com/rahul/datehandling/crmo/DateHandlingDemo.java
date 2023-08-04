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

public class DateHandlingDemo {

	public WebDriver driver;
	public static WebDriverWait wait;
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");

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
	     select.selectByVisibleText("January");
		
	}
//	public void dob(String mm, String dd, String yy)
// 	{
// 		driver.findElement().sendKeys(mm);
// 		driver.findElement(select_dob).sendKeys(dd);
// 		driver.findElement(select_dob).sendKeys(yy);
// 	}

}
