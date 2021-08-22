package com.dibyendusengupta.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventHandler extends ServiceFactory implements EventListener {

	private WebDriverWait wait = new WebDriverWait(driver, 60);

	private JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);

	public void click(WebElement actionElement) {
		waitforPageToLoad();
		for (int i = 0; i < 2; i++) {
			jsExecutor.executeScript("arguments[0].style.border='3px solid red'", actionElement);
		}
		jsExecutor.executeScript("arguments[0].click()", actionElement);
	}

	public String getText(WebElement actionElement) {
		waitforPageToLoad();
		for (int i = 0; i < 2; i++) {
			jsExecutor.executeScript("arguments[0].style.border='3px solid red'", actionElement);
		}
		return actionElement.getText().trim();
	}

	public void sendText(WebElement actionElement, String texttoSend) {
		waitforPageToLoad();
		actionElement.clear();
		for (int i = 0; i < 2; i++) {
			jsExecutor.executeScript("arguments[0].style.border='3px solid red'", actionElement);
		}
		actionElement.sendKeys(texttoSend);
	}

	
	public void waitforPageToLoad() {

		wait.until(new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});

	}

	
	public void waitforVisibilityOfElement(WebElement actionElement) {

		wait.until(ExpectedConditions.visibilityOf(actionElement));

	}

	
	public void waitforInVisibilityOfElement(WebElement actionElement) {

		wait.until(ExpectedConditions.invisibilityOf(actionElement));

	}

}
