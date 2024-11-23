package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class simpleannotation {
	@BeforeSuite
	private void propertySetting() {
		System.out.println("PropertySetting");
	}
	@BeforeTest
	private void Browserlaunch() {
		System.out.println("browser launch");
	}
	@BeforeClass
	private void launchurl() {
		System.out.println("url launch");
	}
	@BeforeMethod
	private void login() {
		System.out.println("login");
	}
	@Test(priority=-5)
	private void women() {
		System.out.println("women");
	}
	@Test(priority=2)
	private void men() {
		System.out.println("men");
	}
	@Test(priority=5)
	private void kids() {
		System.out.println("kids");
	}@AfterMethod
	private void logout() {
		System.out.println("logout");
	}
	@AfterClass
	private void screenshot() {
		System.out.println("screenshot");
	}
	@AfterTest
	private void closerBrowser() {
		System.out.println("close browser");
	}
	@AfterSuite
	private void terminateBrowser() {
		System.out.println("terminate browser");
	}

}
