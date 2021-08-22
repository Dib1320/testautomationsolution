package com.dibyendusengupta.pages;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dibyendusengupta.utils.ServiceFactory;

public class AddCartPagePO extends ServiceFactory {

	@FindBy(css = "a[title='Cart']")
	WebElement cart;

	public AddCartPagePO() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateCart(HashMap<String, String> selectedItem) {

		eventHandler.waitforPageToLoad();

		boolean isValid = false;

		eventHandler.click(cart);

		capture.takescreenShot("Cart Page");

		eventHandler.waitforPageToLoad();

		List<WebElement> cartItems = driver.findElement(By.tagName("table")).findElement(By.tagName("tbody"))
				.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td"));

		System.out.println(eventHandler.getText(cartItems.get(2)) + selectedItem.get("ProductName").toString()
				+ eventHandler.getText(cartItems.get(3)) + selectedItem.get("UnitPrice").toString()+"df");
		if (eventHandler.getText(cartItems.get(2)) != selectedItem.get("ProductName").toString().trim()
				|| eventHandler.getText(cartItems.get(3)) != selectedItem.get("UnitPrice").toString().trim()) {
			isValid = true;
		} 

		capture.takescreenShot("Cart Page Validation");

		return isValid;
	}

}
