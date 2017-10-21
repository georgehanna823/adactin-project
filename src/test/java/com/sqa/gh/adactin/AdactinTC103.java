package com.sqa.gh.adactin;

import static org.testng.Assert.*;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class AdactinTC103 {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://adactin.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testAdactinTC103() throws Exception {
		this.driver.get(this.baseUrl + "/HotelAppBuild2/");
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("username")).sendKeys("geohanna");
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("password")).sendKeys("buckeyes");
		this.driver.findElement(By.id("login")).click();
		new Select(this.driver.findElement(By.id("location"))).selectByVisibleText("Melbourne");
		new Select(this.driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
		new Select(this.driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
		this.driver.findElement(By.id("datepick_in")).clear();
		this.driver.findElement(By.id("datepick_in")).sendKeys("09/5/2017");
		this.driver.findElement(By.id("datepick_in")).clear();
		this.driver.findElement(By.id("datepick_in")).sendKeys("04/10/2017");
		this.driver.findElement(By.id("datepick_out")).clear();
		this.driver.findElement(By.id("datepick_out")).sendKeys("07/10/2017");
		this.driver.findElement(By.id("Submit")).click();
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
