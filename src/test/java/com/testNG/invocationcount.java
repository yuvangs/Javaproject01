package com.testNG;

import org.testng.annotations.Test;

import com.baseclass.baseclass;

public class invocationcount extends baseclass {
	@Test(priority=5)
	   private void edgeBrowser() {
		   launchBrowser("edge");
		   launchurl("https://www.google.com/");
		   System.out.println("Browser ID: "+ Thread.currentThread().getId());
		   terminateBrowser();
		   
	   }
		@Test(invocationCount=6)
	   private void chromeBrowser() {
		   launchBrowser("chrome");
		   launchurl("https://www.google.com/");
		   System.out.println("Browser ID: " + Thread.currentThread().getId());
		   terminateBrowser();
	   }
		@Test(priority=-5)
	   private void firefoxBrowser() {
		   launchBrowser("firefox");
		   launchurl("https://www.google.com/");
		   System.out.println("Browser ID:"+ Thread.currentThread().getId());
		   terminateBrowser();
	   }

}
