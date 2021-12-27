package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.utils.DSL;

public class SearchResultPage extends DSL {

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	// Search Page Locators**
	By add_To_Cart_Btn = By.xpath("//span[text()='Add to cart']");
	By cross_Icon = By.xpath("//span[@class='cross']");
	By hover_Product = By.cssSelector("div.product-container");
	By add_Cart_Btn = By.xpath("//span[text()='Add to cart']");
	By cross_Icon1 = By.xpath("//span[@class='cross']");
	By cart1 = By.xpath("//div[@class='shopping_cart']");
	By cart_hover = By.cssSelector("div.shopping_cart>a");
	By product_count = By.xpath("//div[@class='shopping_cart']/a/span[@class='ajax_cart_quantity']");
	By checkOut_Btn = By.id("button_order_cart");
	By search_Box_Opt = By.xpath("//input[@id='search_query_top']");
	By submit_Btn1 = By.xpath("//button[@name='submit_search']");
	By search_Item = By.xpath("//span[@class='lighter']");
	By blouse_Result = By.xpath("//span[@class='lighter']//following-sibling::span");

	// Actions**
	public void addIteminCart() {
		mouseOver_Element(hover_Product);
		click(add_Cart_Btn);
		click(cross_Icon);

		navigateTo("http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-orange");
		click(add_Cart_Btn);
		click(cross_Icon1);

	}

	public void verifyIteminCart() {
		verify_Text("2", product_count);
	}

	public void goToCheckout() {
		mouseOver_Element(cart_hover);
		click(checkOut_Btn);
	}

	public void searchBlouse() {
		enterText(search_Box_Opt, "blouse");
		click(submit_Btn1);
		verify_Text("1 result has been found.", blouse_Result);
	}

}