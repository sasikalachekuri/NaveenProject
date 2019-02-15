package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;

public class BaseClass {

public	static WebDriver driver;
public	static Properties prop;

	public BaseClass() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\amrit\\Documents\\workSpace_RS\\NaveenPOMFreeCrm\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String Browser = prop.getProperty("browser");
		try {
			if (Browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (Browser.equalsIgnoreCase("gecko")) {
				driver = new FirefoxDriver();
			}else if(Browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_Timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
