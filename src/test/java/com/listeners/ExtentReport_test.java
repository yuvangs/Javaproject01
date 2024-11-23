package com.listeners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.baseclass;

public class ExtentReport_test {
public static ExtentTest extenttest;
@BeforeSuite
public void extenttestreportstartup() {
	baseclass base=new baseclass() {
		
	};
	base.extentreportstart(null);
}
@AfterSuite
public void extentreportend() {
	baseclass base=new baseclass() {
		
	};
	base.extentreportteardown(null);
}
}
