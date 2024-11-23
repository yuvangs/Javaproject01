package com.testNG;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.baseclass;

public class dataprovidertest extends baseclass {
	@Test(dataProvider="login")
	public void login(String username,String password) {
		launchBrowser("chrome");
		launchurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitwait(30);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		terminateBrowser();
		
	}
@DataProvider(name="login")
public Object[][] dataset(){
	return new Object[][] {{"Admin","admin123"},{"Abc","123"},{" "," "}};
	
}}
