package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.baseclass;
import com.interfaceelements.adactinapplicationelements;

import srcmainresources.filereadermanager;

public class adactinsearchpage extends baseclass implements adactinapplicationelements{
	@FindBy(id=location_id)
	private WebElement location;
	@FindBy(id=hotels_id)
	private WebElement hotel;
	@FindBy(id=roomType_id)
	private WebElement roomType;
	@FindBy(id=numberOfRooms_id)
	private WebElement noOfRooms;
	@FindBy(id=checkIn_id)
	private WebElement checkIn;
	@FindBy(id=checkOut_id)
	private WebElement checkOut;
	@FindBy(id=adultRoom_id)
	private WebElement adultRoom;
	@FindBy(id=childRoom_id)
	private WebElement childRoom;
	@FindBy(id=searchBtn)
	private WebElement searchElement;
	@FindBy(id=selectBtn_id)
	private WebElement select;
	@FindBy(id=continue_id)
	private WebElement continueBtn;
	public adactinsearchpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	public void searchhotel() throws IOException{
		filereadermanager search=new filereadermanager();
		selectByVisibletext(location,search.getDataProperty("location"));
		selectByVisibletext(hotel,search.getDataProperty("hotels"));
		selectByVisibletext(roomType,search.getDataProperty("roomType"));
		selectByVisibletext(noOfRooms,search.getDataProperty("numberOfRooms"));
		clear(checkIn);
		pass(checkIn,search.getDataProperty("checkInDate"));
		clear(checkOut);
		pass(checkOut,search.getDataProperty("checkOutDate"));
		selectByVisibletext(adultRoom,search.getDataProperty("adultRoom"));
		selectByVisibletext(childRoom,search.getDataProperty("childRoom"));
		click(searchElement);
		click(select);
		click(continueBtn);
		
	}

}
