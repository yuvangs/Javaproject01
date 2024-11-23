package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseclass.baseclass;
import com.interfaceelements.openmrsinterfaceelement;

import srcmainresources.filereadermanager;
import srcmainresources.openmrsfilereadermanager;

public class openmrsloginpage extends baseclass implements openmrsinterfaceelement  {
	@FindBy(id=username_id)
	private WebElement username;
	@FindBy(name=password_id)
	private WebElement password;
	@FindBy(id=location_id)
	private WebElement location;
	@FindBy(id=login_id)
	private WebElement login;
	@FindBy(id= errormessage_id)
	private WebElement errormessage;
	@FindBy(id= locationerror_id)
	private WebElement locationerror;
	public openmrsloginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean validlogin(ExtentTest extenttest) {
		try{
			openmrsfilereadermanager data=new openmrsfilereadermanager();
		    launchurl(data.getDataProperty("url"));
		pass(username,data.getDataProperty("username"));
		pass(password,data.getDataProperty("password"));
        click(location);
		click(login);
		validation(driver.getTitle(),data.getDataProperty("title"));
		extenttest.log(Status.PASS,"Login Sucessful");
		}catch(Exception e) {
			extenttest.log(Status.FAIL,"Loginfailed"+e.getMessage());
			return false;}
		return true;
		}
	public boolean invalidpasstest() {
		try {
		openmrsfilereadermanager data1=new openmrsfilereadermanager();
	    launchurl(data1.getDataProperty("url"));
	pass(username,data1.getDataProperty("username"));
	pass(password,data1.getDataProperty("invalidpassword"));
    click(location);
	click(login);
	validation(errormessage.getText(),data1.getDataProperty("errormessage"));
	
	}catch(Exception e) {
		Assert.fail("ERROR:OCCUR DURING VALIDATION");}
	return true;
	}
	public boolean empty() {
		try {
		openmrsfilereadermanager data1=new openmrsfilereadermanager();
	    launchurl(data1.getDataProperty("url"));
	pass(username,data1.getDataProperty("empty"));
	pass(password,data1.getDataProperty("empty"));
    click(location);
	click(login);
	validation(errormessage.getText(),data1.getDataProperty("errormessage"));
	
	}catch(Exception e) {
		Assert.fail("ERROR:OCCUR DURING VALIDATION");}
	return true;
	}
	public boolean nolocation() {
		try {
		openmrsfilereadermanager data1=new openmrsfilereadermanager();
	    launchurl(data1.getDataProperty("url"));
	pass(username,data1.getDataProperty("username"));
	pass(password,data1.getDataProperty("password"));
    //click(location);
	click(login);
	validation(locationerror.getText(),data1.getDataProperty("locationerror"));
	
	}catch(Exception e) {
		Assert.fail("ERROR:OCCUR DURING VALIDATION");}
	return true;
	}
	
	
	}



