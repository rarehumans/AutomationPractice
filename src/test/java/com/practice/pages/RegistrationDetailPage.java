package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.DSL;

public class RegistrationDetailPage extends DSL {

	public RegistrationDetailPage(WebDriver driver) {
		super(driver);

	}

	// Register page locators**
	By male_Opt = By.id("id_gender1");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By day_Select_Opt = By.id("days");
	By month_Select_Opt = By.id("months");
	By year_Select_Opt = By.id("years");
	By address_FirstName = By.id("firstname");
	By address_LastName = By.id("lastname");
	By address_input = By.id("address1");
	By city_input = By.id("city");
	By state_select = By.id("id_state");
	By zipCode_input = By.id("postcode");
	By phone_Number = By.id("phone_mobile");
	By address_alias = By.id("alias");
	By register_Btn = By.id("submitAccount");

	// *****Actions

	public void enterPersonalInfo() {
		click(male_Opt);
		enterText(firstName, "Sumit");
		enterText(lastName, "Jha");
		enterText(password, "123456");
		selectDropdownValues(day_Select_Opt, "10");
		selectDropdownValues(month_Select_Opt, "7");
		selectDropdownValues(year_Select_Opt, "1995");
		enterText(address_FirstName, randomString());
		enterText(address_LastName, randomString());
		enterText(address_input, randomString() + " " + randomNumber());
		enterText(city_input, "Kansas");
		selectDropdownValues(state_select, "10");
		enterText(zipCode_input, "99501");
		enterText(phone_Number, "9988778877");
		click(register_Btn);

	}


}
