package com.dibyendusengupta.steps;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;

import com.dibyendusengupta.utils.ServiceFactory;

import cucumber.api.java.en.Then;

public class LowPriceProductAddToCart extends ServiceFactory {

	HashMap<String, String> selectedItem = new HashMap<String, String>();

	ArrayList<HashMap<String, String>> wishList = new ArrayList<HashMap<String, String>>();

	@Then("^User should add products to wishlist$")
	public void user_should_add_products_to_wishlist() throws Throwable {
		wishList = shoppagePO.selectProducts();
	}

	@Then("^User need to validate the wishlist$")
	public void user_need_to_validate_the_wishlist() throws Throwable {
		wishlistpagePO.validatewishList(wishList);
		selectedItem = wishlistpagePO.getSelectedItem();
	}

	@Then("^User need to add the lowest price product to cart$")
	public void user_need_to_add_the_lowest_price_product_to_cart() throws Throwable {
		wishlistpagePO.addlowestpriceProduct();
	}

	@Then("^User need to validate the item in cart$")
	public void user_need_to_validate_the_item_in_cart() throws Throwable {
		Assert.assertEquals(true,addcartpagePO.validateCart(selectedItem));
	}

}
