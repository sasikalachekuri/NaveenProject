package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.BaseClass;

public class ContactsPage extends BaseClass{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsDispaly;
//(xpath="//a[contains(text(),'Abhiman saraswa']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
}
