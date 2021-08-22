package com.dibyendusengupta.utils;

import static com.dibyendusengupta.utils.Constants.CHROME;
import static com.dibyendusengupta.utils.Constants.CHROMEEXE;
import static com.dibyendusengupta.utils.Constants.EDGE;
import static com.dibyendusengupta.utils.Constants.EDGEEXE;
import static com.dibyendusengupta.utils.Constants.INTERNETEXPLORER;
import static com.dibyendusengupta.utils.Constants.INTERNETEXPLOREREXE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.dibyendusengupta.pages.AddCartPagePO;
import com.dibyendusengupta.pages.ShopPagePO;
import com.dibyendusengupta.pages.WishListPagePO;

public class ServiceFactory {

	protected static WebDriver driver = null;

	protected static EventHandler eventHandler = null;

	protected static String testcaseName = "";

	protected static String screenshotfolderLocation = "";

	protected static CaptureScreenShots capture = null;

	protected static AddCartPagePO addcartpagePO = null;

	protected static WishListPagePO wishlistpagePO = null;

	protected static ShopPagePO shoppagePO = null;

	protected static WebDriver getDriver(String browserName) {

		if (driver == null) {

			switch (browserName) {

			case CHROME:

				System.setProperty("webdriver.chrome.driver", CHROMEEXE);

				driver = new ChromeDriver();

				break;

			case INTERNETEXPLORER:

				System.setProperty("webdriver.ie.driver", INTERNETEXPLOREREXE);

				driver = new InternetExplorerDriver();

				break;

			case EDGE:

				System.setProperty("webdriver.edge.driver", EDGEEXE);

				driver = new InternetExplorerDriver();

				break;

			default:

				driver = new FirefoxDriver();

				break;

			}

			eventHandler = new EventHandler();

			capture = new CaptureScreenShots();

			addcartpagePO = new AddCartPagePO();

			wishlistpagePO = new WishListPagePO();

			shoppagePO = new ShopPagePO();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		}

		return driver;

	}

	protected void tearDown() {

		if (driver != null) {

			driver.quit();

			driver = null;

		}

	}

}
