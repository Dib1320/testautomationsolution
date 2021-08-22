package com.dibyendusengupta.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dibyendusengupta.utils.ServiceFactory;

public class WishListPagePO extends ServiceFactory {

	@FindBy(css = "a[title='Wishlist']")
	WebElement wishlist;

	HashMap<String, String> selectedItem = new HashMap<String, String>();

	WebElement addcartLink = null;

	public WishListPagePO() {
		PageFactory.initElements(driver, this);
	}

	public HashMap<String, String> getSelectedItem() {
		return selectedItem;
	}

	public boolean validatewishList(ArrayList<HashMap<String, String>> wishList) {

		boolean isValid = true;

		eventHandler.click(wishlist);

		eventHandler.waitforPageToLoad();

		capture.takescreenShot("Wish List Page");

		ArrayList<HashMap<String, String>> verifywishList = new ArrayList<HashMap<String, String>>();

		List<WebElement> wishlistItems = driver.findElement(By.className("wishlist-items-wrapper"))
				.findElements(By.tagName("tr"));

		float minValue = (float) 9999999.00;

		for (int i = wishlistItems.size() - 1; i >= 0; i--) {

			HashMap<String, String> productDetails = new HashMap<String, String>();

			productDetails.put("ProductName",
					wishlistItems.get(i).findElements(By.tagName("td")).get(2).getText().trim());

			String[] unitPrice = wishlistItems.get(i).findElements(By.tagName("td")).get(3).getText().trim().split(" ");

			String unitValue = unitPrice[0];

			if (unitPrice.length > 1) {
				unitValue = unitPrice[1];
			}

			float value = Float.parseFloat(unitValue.substring(1));

			if (minValue > value) {
				minValue = value;
				addcartLink = wishlistItems.get(i).findElements(By.tagName("td")).get(5).findElement(By.tagName("a"));
				selectedItem.put("ProductName",
						wishlistItems.get(i).findElements(By.tagName("td")).get(2).getText().trim());
				selectedItem.put("UnitPrice", unitValue);
			}

			productDetails.put("UnitPrice", unitValue);

			verifywishList.add(productDetails);

		}

		if (wishList.size() == verifywishList.size()) {
			for (int i = 0; i < wishList.size(); i++) {
				if (!wishList.get(i).equals(verifywishList.get(i))) {
					isValid = false;
				}
			}
		}

		eventHandler.waitforPageToLoad();

		capture.takescreenShot("Wish List Validation");

		return isValid;
	}

	public void addlowestpriceProduct() {
		addcartLink.click();

		eventHandler.waitforPageToLoad();

		capture.takescreenShot("Added Lowest Price Product");
	}

}
