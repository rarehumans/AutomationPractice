package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.DSL;

public class CheckoutPage extends DSL {

	public CheckoutPage(WebDriver driver) {
		super(driver);

	}

	// Search Page Locators**
	By checkout_Btn = By.xpath("//p/a[@title='Proceed to checkout']");
	By product_Count = By.id("summary_products_quantity");
	By address_Checkout = By.xpath("//button[@name='processAddress']");
	By checkbox_Hover = By.id("uniform-cgv");
	By agree_Terms = By.xpath("//label[contains(text(),'I agree to the')]");
	By carrier_Checkout = By.xpath("//button[@name='processCarrier']");

	By bank_Wire = By.className("bankwire");
	By confirm_order = By.xpath("//span[text()='I confirm my order']");

	By order_confirmation = By.xpath("//p[@class='cheque-indent']/strong");
	By back_to_order = By.xpath("//a[@title=\"Back to orders\"]");
	// Actions**

	public void checkoutProcess() {
		verify_Element_Displayed(product_Count);
		click(checkout_Btn);
		click(address_Checkout);
		mouseOver_Element(checkbox_Hover);
		click(agree_Terms);
		click(carrier_Checkout);
	}

	public void paymentProcess() {
		click(bank_Wire);
		click(confirm_order);
		verify_Element_Displayed(order_confirmation);
		verify_Text("Your order on My Store is complete.", order_confirmation);
		click(back_to_order);
	}

}