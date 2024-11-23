package com.runner;


import java.io.IOException;

import com.baseclass.baseclass;
import com.pageobjectmanager.pageobjectmanager;

public class runner extends baseclass{
	public static void main(String[] args) throws IOException, InterruptedException {
		pageobjectmanager pageobjectmanager =new pageobjectmanager();
		launchBrowser(pageobjectmanager.getfilereader().getDataProperty("browser"));
		launchurl(pageobjectmanager.getfilereader().getDataProperty("url"));
		pageobjectmanager.getloginpage().validusernameandvalidpassword();
	     pageobjectmanager.getsearchpage().searchhotel();
	     pageobjectmanager.getbookpage().bookhotel();
		   
	}
	
	

}
