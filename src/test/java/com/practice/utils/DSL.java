package com.practice.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class DSL {

	protected static WebDriver driver;
	private final int TIMEOUT = 30;

	protected DSL(WebDriver driver) {
		this.driver = driver;
	}

	public void click(By by) {
		wait_explicit_till_element_Clickable(by);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(by).click();
	}

	public void click(WebElement objelement) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objelement.click();
	}

	public void verify_Element_Displayed(By by) {

		wait_explicit_till_element_Displayed(by);

		Assert.assertEquals("Element not displayed", true, driver.findElement(by).isDisplayed());
	}

	public void enterText(By by, String text) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement objInput = driver.findElement(by);
		objInput.sendKeys(text);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	public void enterText(By by, Keys key) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement objInput = driver.findElement(by);
		objInput.sendKeys(key);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void wait_explicit_till_element_Displayed(By by) {

		WebDriverWait waitnew = new WebDriverWait(driver, 40);
		waitnew.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void wait_explicit_till_elements_Displayed(WebElement ele) {

		WebDriverWait waitnew = new WebDriverWait(driver, 40);
		waitnew.until(ExpectedConditions.visibilityOfElementLocated((By) ele));
	}

	public void wait_explicit_till_element_Clickable(By by) {

		WebDriverWait waitnew = new WebDriverWait(driver, 25);
		waitnew.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void wait_Specific_Seconds(long sec) {

		try {
			Thread.sleep(sec);
		} catch (Exception e) {

		}
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}

	public List get_Element_List(By by) {

		List<WebElement> lisElement = driver.findElements(by);

		return lisElement;
	}

	public void mouseOver_Element(By by) {

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(by);

		wait_explicit_till_element_Clickable(by);

		action.moveToElement(element).build().perform();
	}

	public void verify_Text(String expectedtext, By by) {
		String actualText = driver.findElement(by).getText();
		System.out.println("actualMessage=" + actualText);
		Assert.assertEquals(expectedtext + " is not displayed", expectedtext, actualText);
	}

	public List<WebElement> getWebElements(By by) {
		return driver.findElements(by);
	}

	public void switchTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs2.size());
		driver.switchTo().window(tabs2.get(1));
	}

	public void selectDropdownValues(By by, String value) {
		Select select = new Select(driver.findElement(by));
		select.selectByValue(value);
	}

	public void right_click(By by) {
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
	}

	public void closeBrowser() {
		driver.quit();
	}

	public String randomString() {
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * CHARS.length());
			salt.append(CHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public String randomNumber() {
		String CHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * CHARS.length());
			salt.append(CHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	/**
	 * 
	 * @param text
	 * @param locator
	 */
	// To create dynamic xpath and click on the same element
	public void dynamicClick(String text, String locator) {
		By dynamicLocator = null;
		if (locator.contains("$text")) {
			locator = locator.replace("$text", text);
			dynamicLocator = By.xpath(locator);
		}

		wait_explicit_till_element_Clickable(dynamicLocator);
		driver.findElement(dynamicLocator).click();
		;
	}

	/**
	 * 
	 * @param text
	 * @param locator
	 */
	// To create dynamic xpath and verify the same element
	public void dynamicVerify(String text, String locator) {
		By dynamicLocator = null;
		if (locator.contains("$text")) {
			locator = locator.replace("$text", text);
			dynamicLocator = By.xpath(locator);
		}

		wait_explicit_till_element_Displayed(dynamicLocator);
		verify_Element_Displayed(dynamicLocator);
	}

	/**
	 * 
	 * @param text
	 * @return
	 */

	public void clearText(By by) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(by).clear();
	}

	public String get_Text(By by) {
		String actualText = driver.findElement(by).getText();
		System.out.println("actualText=" + actualText);
		return actualText;
	}

	public void scrollToAnElement(By by) throws InterruptedException {

		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);

	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

}
