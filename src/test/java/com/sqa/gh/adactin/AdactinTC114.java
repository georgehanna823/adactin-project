package com.sqa.gh.adactin;

import static org.testng.Assert.*;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class AdactinTC114 {

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
	public void testAdactinTC114() throws Exception {
		this.driver.get(this.baseUrl + "/HotelAppBuild2/");
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("username")).sendKeys("geohanna");
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("password")).sendKeys("buckeyes");
		this.driver.findElement(By.id("login")).click();
		new Select(this.driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
		new Select(this.driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
		new Select(this.driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
		this.driver.findElement(By.id("Submit")).click();
		this.driver.findElement(By.id("radiobutton_0")).click();
		this.driver.findElement(By.id("continue")).click();
		this.driver.findElement(By.id("first_name")).clear();
		this.driver.findElement(By.id("first_name")).sendKeys("George");
		this.driver.findElement(By.id("last_name")).clear();
		this.driver.findElement(By.id("last_name")).sendKeys("Hanna");
		this.driver.findElement(By.id("address")).clear();
		this.driver.findElement(By.id("address")).sendKeys("111 Main St.");
		this.driver.findElement(By.id("cc_num")).clear();
		this.driver.findElement(By.id("cc_num")).sendKeys("1111222233334444");
		new Select(this.driver.findElement(By.id("cc_type"))).selectByVisibleText("VISA");
		new Select(this.driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("January");
		new Select(this.driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2019");
		this.driver.findElement(By.id("cc_cvv")).clear();
		this.driver.findElement(By.id("cc_cvv")).sendKeys("123");
		this.driver.findElement(By.id("book_now")).click();
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
