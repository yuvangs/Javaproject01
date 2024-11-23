package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.baseclass;
import com.interfaceelements.adactinapplicationelements;

import srcmainresources.filereadermanager;

public class adactinbookpage extends baseclass implements adactinapplicationelements {
	@FindBy(id=firstName_id)
	private WebElement firstName;
	@FindBy(id=lastName_id)
	private WebElement lastName;
	@FindBy(id=address_id)
	private WebElement address;
	@FindBy(id=creditNo_id)
	private WebElement creditNo;
	@FindBy(id=creditType_id)
	private WebElement creditType;
	@FindBy(id=selectMonth_id)
	private WebElement selectMonth;
	@FindBy(id=selectYear_id)
	private WebElement selectYear;
	@FindBy(id=cvvNumber_id)
	private WebElement cvv;
	@FindBy(id=bookNow_id)
	private WebElement bookNow;
	@FindBy(id=logout_id)
	private WebElement logout;
	public adactinbookpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void bookhotel() throws IOException,InterruptedException{
		filereadermanager book =new filereadermanager();
		pass(firstName,book.getDataProperty("firstName"));
		pass(lastName,book.getDataProperty("lastName"));
		pass(address,book.getDataProperty("address"));
		pass(creditNo,book.getDataProperty("creditNo"));
		selectByVisibletext(creditType,book.getDataProperty("creditType"));
		selectByVisibletext(selectMonth,book.getDataProperty("expiryDate"));
		selectByVisibletext(selectYear,book.getDataProperty("year"));
		pass(cvv,book.getDataProperty("cvv"));
		click(bookNow);
		explicitwait(bookNow,40);
		takesscreenshot(book.getDataProperty("path"));
		click(logout);
		explicitwait(logout,30);
	
	}
	
	
	
	
}
