package com.runner;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.readexceldata;

public class runnerexcelpoi {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String username=readexceldata.readparticulardata("Sheet1",1,1);
		String password=readexceldata.readparticulardata("Sheet1", 1, 2);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
	}

}
