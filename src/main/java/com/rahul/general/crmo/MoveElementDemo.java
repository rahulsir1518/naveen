package com.rahul.general.crmo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveElementDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("rahulkr1999");
	    driver.findElement(By.name("password")).sendKeys("Rahul@123");
	   
	    WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", loginBtn);
	    
	    Thread.sleep(2000);
	    driver.switchTo().frame("mainpanel");
	    Thread.sleep(2000);
	    Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(By.linkText("Contacts"))).perform();
	    
//	    WebElement contactElement = driver.findElement(By.linkText("Contacts"));
//	    action.doubleClick().build().perform();

	}

}
