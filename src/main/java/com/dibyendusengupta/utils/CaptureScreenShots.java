package com.dibyendusengupta.utils;

import static com.dibyendusengupta.utils.Constants.FILESEPARATOR;
import static com.dibyendusengupta.utils.Constants.SCREENSHOTSDIRECTORY;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class CaptureScreenShots extends ServiceFactory {

	public void createFolder() {
		File file = new File(SCREENSHOTSDIRECTORY + testcaseName);
		if (!file.exists()) {
			file.mkdir();
		}
		screenshotfolderLocation = file.getAbsolutePath();
	}

	public void takescreenShot(String screenshotName) {
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(screenshotfolderLocation + FILESEPARATOR + testcaseName + "_" + screenshotName + "_"
							+ new Random().nextInt(100)));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
	}

}
