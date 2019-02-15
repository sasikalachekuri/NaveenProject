package com.crm.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.BaseClass;

public class TestUtil extends BaseClass {
	public static long Page_Load_Timeout = 20;
	public static long Implicit_Wait_Timeout = 20;
	public static Actions action;
	public static WebDriverWait wait;

	public static void SwitchFrames(int index) {
		driver.switchTo().frame(index);
	}
	public static void SwitchFrames(String framename) {
		driver.switchTo().frame(framename);
	}
	public static void SwitchFrames(WebElement  webelement) {
		driver.switchTo().frame(webelement);
	}

	public static void MouseHoverElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void javascriptexecutor(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public static void explicitWait(WebDriver driver,long timeout,WebElement element){
		 wait = new WebDriverWait(driver, timeout);
		 wait.until(ExpectedConditions.visibilityOf(element));
		 element.click();
		
	}
}
