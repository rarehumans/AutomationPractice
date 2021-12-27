package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.DSL;

public class LandingPage extends DSL {

	public LandingPage(WebDriver driver) {
		super(driver);

	}

	By sign_In_Btn = By.cssSelector("div.header_user_info");
	By email_input_Box = By.id("email_create");
	By create_Btn = By.id("SubmitCreate");

	// *****Actions

	public void clickOnSignin() {
		click(sign_In_Btn);
	}

	public void enterEmailForRegistration() {
		enterText(email_input_Box, randomString() + "@gmail.com");
		click(create_Btn);
	}

}
