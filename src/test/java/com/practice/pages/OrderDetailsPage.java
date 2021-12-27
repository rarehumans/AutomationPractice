package com.practice.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.utils.DSL;

public class OrderDetailsPage extends DSL {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);

	}

	// Search Page Locators**
	By order_row = By.cssSelector("tr.first_item ");
	By details_Btn = By.xpath("//span[contains(text(),'Details')]");
	By product_row = By.xpath("//div[@id='order-detail-content']//tbody/tr[@class='item']");
	By list_Element = By.xpath("(//div[@id='order-detail-content']//tbody/tr[@class='item'])[1]");

	List<By> prodcut_List = get_Element_List(product_row);
	// Actions**

	public void verifyOrder() {
		verify_Element_Displayed(order_row);
		click(details_Btn);
		for (int i = 1; i <= prodcut_List.size(); i++) {
			wait_explicit_till_elements_Displayed(driver
					.findElement(By.xpath("(//div[@id='order-detail-content']//tbody/tr[@class='item'])[" + i + "]")));
		}
	}

}