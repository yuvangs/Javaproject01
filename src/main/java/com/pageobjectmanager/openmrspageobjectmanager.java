package com.pageobjectmanager;

import com.baseclass.baseclass;
import com.pageobjectmodel.openmrsloginpage;

import srcmainresources.openmrsfilereadermanager;

public class openmrspageobjectmanager extends baseclass {
	private openmrsloginpage loginpage;
	private openmrsfilereadermanager filereader;
	
	public openmrsloginpage getloginpage() {
		if(loginpage==null) {
			loginpage=new openmrsloginpage(driver);
		}
		return loginpage;
	}
	public openmrsfilereadermanager getfilereader() {
		if (filereader==null) {
			filereader=new openmrsfilereadermanager();
		}
	return filereader;	
	}

}
