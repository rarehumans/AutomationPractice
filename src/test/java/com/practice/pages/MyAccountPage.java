package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.DSL;

public class MyAccountPage extends DSL {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	// My Accountpage Locators**
	By verify_signOut_Btn = By.xpath("//a[@title='Log me out']");
	By verify_MyAccount = By.xpath("//p[@class='info-account']");
	By verify_Women_Opt = By.xpath("//a[@title='Women']");
	// Add two items**
	By top_Search_Box = By.id("search_query_top");
	By submit_Btn = By.xpath("//button[@name='submit_search']");

	// Actions**
	public void verifyRegisteredUser() {
		verify_Element_Displayed(verify_signOut_Btn);
		verify_Element_Displayed(verify_MyAccount);
		verify_Element_Displayed(verify_Women_Opt);
	}

	public void searchItem() {
		enterText(top_Search_Box, "top");
		click(submit_Btn);
	}

}