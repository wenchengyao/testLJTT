package com.isst.tests.setting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T7CityPage;
import com.isst.tests.MySuite;


public class Demo extends MySuite {
	
	LoginPage lg;
	T7CityPage ig;

	@BeforeClass
	public void beforeMethod() throws Exception{
		String owner[]={"sm_architecture"};
		dc.recoverdatatable(owner);
	}
	
	@Test(description = "测试建筑_新增_区域")
	public void testAddCity() throws Exception {
	}
}
