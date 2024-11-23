package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseclass.baseclass;
import com.listeners.ExtentReport_test;
import com.listeners.ITestListenerClass;
import com.pageobjectmanager.openmrspageobjectmanager;
@Listeners(ITestListenerClass.class)
public class openmrsrunner extends baseclass {
	openmrspageobjectmanager pageobjectmanager= new openmrspageobjectmanager();
	@BeforeTest
	public void setup() throws IOException {
		launchBrowser(pageobjectmanager.getfilereader().getDataProperty("browser"));
		
	}
	@Test
	private void validlogintest() {
		
		 
			  ExtentReport_test.extenttest=extentreports.createTest("Login Test"+ " "+Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("validlogin");
			  Assert.assertTrue(pageobjectmanager.getloginpage().validlogin(ExtentReport_test.extenttest));
			  
		  
	}
	//@Test
	//private void invalidpasstest() {
		//Assert.assertTrue(pageobjectmanager.getloginpage().invalidpasstest());
	//}
	//@Test
	//private void empty() {
	//	Assert.assertTrue(pageobjectmanager.getloginpage().empty());
	//}
//@Test
//private void nolocation() {
	//Assert.assertTrue(pageobjectmanager.getloginpage().nolocation());
//}
	
	@AfterTest
	private void termination() {
		terminateBrowser();
	}
	@BeforeSuite
	private void extentreportstartup() {
		extentreportstart("C:\\Users\\Yuvan_New\\eclipse-workspace\\Maven_Project\\Reports");
		
	}
	@AfterSuite
	private void extentreportend() {
		extentreportteardown("C:\\Users\\Yuvan_New\\eclipse-workspace\\Maven_Project\\Reports\\index.html");
	}

}
