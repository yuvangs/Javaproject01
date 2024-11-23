package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.baseclass;
import com.interfaceelements.adactinapplicationelements;

import srcmainresources.filereadermanager;

public class adactinloginpage extends baseclass implements adactinapplicationelements {
	@FindBy(id=username_id)
	private WebElement username;
	@FindBy(name=password_name)
	private WebElement password;
	@FindBy(xpath=login_xpath)
	private WebElement login;
	public adactinloginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void validusernameandvalidpassword()throws IOException{
		filereadermanager data=new filereadermanager();
		pass(username,data.getDataProperty("loginusername"));
		pass(password,data.getDataProperty("loginpassword"));
		click(login);
		
	}

}
