package com.dibyendusengupta.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dibyendusengupta.utils.ServiceFactory;

public class ShopPagePO extends ServiceFactory {

	@FindBy(css = "a[title='Shop']")
	WebElement shop;

	public ShopPagePO() {
		PageFactory.initElements(driver, this);
	}

	public ArrayList<HashMap<String, String>> selectProducts() {

		eventHandler.click(shop);
		
		eventHandler.waitforPageToLoad();
		
		capture.takescreenShot("Shop Page");

		List<WebElement> products = driver.findElement(By.className("products")).findElements(By.tagName("li"));

		ArrayList<HashMap<String, String>> wishList = new ArrayList<HashMap<String, String>>();

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).findElements(By.tagName("a")).get(1).getText().equalsIgnoreCase("Add to cart")
					|| products.get(i).findElements(By.tagName("a")).get(1).getText().equalsIgnoreCase("Buy now!")) {

				HashMap<String, String> productDetails = new HashMap<String, String>();
				products.get(i).findElements(By.tagName("div")).get(0).findElements(By.tagName("div")).get(1)
						.findElement(By.tagName("div")).findElement(By.tagName("div")).findElement(By.tagName("a"))
						.click();

				String[] unitPrice = products.get(i).findElement(By.tagName("a")).findElement(By.className("price"))
						.getText().trim().split(" ");

				String unitValue = unitPrice[0];

				if (unitPrice.length > 1) {
					unitValue = unitPrice[1];
				}

				productDetails.put("ProductName",
						products.get(i).findElement(By.tagName("a")).findElement(By.tagName("h2")).getText().trim());

				productDetails.put("UnitPrice", unitValue);

				wishList.add(productDetails);

			}
		}
		
		capture.takescreenShot("Shop Page - Products Added");

		return wishList;
	}

}
