package com.practice.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practice.pages.CheckoutPage;
import com.practice.pages.LandingPage;
import com.practice.pages.MyAccountPage;
import com.practice.pages.OrderDetailsPage;
import com.practice.pages.RegistrationDetailPage;
import com.practice.pages.SearchResultPage;


public class AutomationTest extends Base {

	WebDriver driver = setup();
	
	LandingPage obj_landingPage = new LandingPage(driver);
	RegistrationDetailPage obj_registrationDetailPage = new RegistrationDetailPage(driver);
	MyAccountPage obj_myAccountPage = new MyAccountPage(driver);
	SearchResultPage obj_searchResultPage = new SearchResultPage(driver);
	CheckoutPage obj_CheckoutPage = new CheckoutPage(driver);
	OrderDetailsPage obj_OrderDetailsPage = new OrderDetailsPage(driver);
	
	@Test
	public void automationTest() throws InterruptedException, IOException {
		obj_landingPage.clickOnSignin();
		obj_landingPage.enterEmailForRegistration();
		obj_registrationDetailPage.enterPersonalInfo();
		obj_myAccountPage.verifyRegisteredUser();
		obj_myAccountPage.searchItem();
		obj_searchResultPage.addIteminCart();
		obj_searchResultPage.verifyIteminCart();
		obj_searchResultPage.searchBlouse();
		obj_searchResultPage.goToCheckout();
		obj_CheckoutPage.checkoutProcess();
		obj_CheckoutPage.paymentProcess();
		obj_OrderDetailsPage.verifyOrder();
		
	}
}
