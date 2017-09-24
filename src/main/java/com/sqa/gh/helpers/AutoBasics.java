package com.sqa.gh.helpers;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.log4testng.*;

public class AutoBasics {

	// Helper methods that locate elements and returns back a List Collection
	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		return null;
	}

	public static List<WebElement> getCSSPropBasedElements(WebDriver driver, By locator, String prop, String value) {
		return null;
	}

	public static List<WebElement> getLinks(WebDriver driver) {
		return null;
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		List<WebElement> elements = driver.findElements(By.tagName("img"));
		return elements;
	}

	public static String getProp(String propName, String fileLocation, String fileName, Logger logger) {
		Properties props = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(fileLocation + fileName);
			props.load(input);
		} catch (FileNotFoundException e) {
			logger.warn("Can not load config properties file because it was not found: " + fileName);
		} catch (IOException e) {
			logger.warn("Can not load config properties file can not be read: " + fileName);
		}
		return props.getProperty(propName);
	}

	public static List<String> getTextContents(WebDriver driver, By locator) {
		return null;
	}

	public static boolean isElementPresent(WebDriver driver, By by, Logger logger) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.warn("Element was not found: " + by);
			return false;
		}
	}

	public static boolean takeScreenshot(String fileLocation, String fileName, WebDriver driver, Logger logger) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(fileLocation + "/" + fileName + ".png"));
			return true;
		} catch (IOException e) {
			logger.warn("Screenshot " + fileName + " was not captured to disk correctly.");
			return false;
		}
	}
}
