package com.pageobjectmanager;


import com.baseclass.baseclass;
import com.pageobjectmodel.adactinbookpage;
import com.pageobjectmodel.adactinloginpage;
import com.pageobjectmodel.adactinsearchpage;

import srcmainresources.filereadermanager;

public class pageobjectmanager extends baseclass {
	private adactinloginpage loginpage;
	private filereadermanager filereader;
	private adactinsearchpage searchpage;
	private adactinbookpage bookpage;
	public adactinloginpage getloginpage() {
		if(loginpage==null) {
			loginpage =new adactinloginpage(driver);
		}
		return loginpage;
	}
	public filereadermanager getfilereader() {
		if(filereader==null) {
			filereader= new filereadermanager();
		}
		return filereader;
	}
	public adactinsearchpage getsearchpage() {
		// TODO Auto-generated method stub
		if(searchpage==null) {
			searchpage=new adactinsearchpage(driver);
			
		}
		return searchpage;
	}
	public adactinbookpage getbookpage() {
		// TODO Auto-generated method stub
		if(bookpage==null) {
			bookpage=new adactinbookpage(driver);
			
		}
		return bookpage;
	}
	
}
