package com.dibyendusengupta.utils;

import org.openqa.selenium.WebElement;

public interface EventListener {

	public void click(WebElement actionElement);

	public String getText(WebElement actionElement);

	public void sendText(WebElement actionElement, String texttoSend);

	public void waitforPageToLoad();

	public void waitforVisibilityOfElement(WebElement actionElement);

	public void waitforInVisibilityOfElement(WebElement actionElement);

}
