package com.isst.tests.setting;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.isst.driver.Driver;
import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T5LampTree;
import com.isst.tests.MySuite;


public class LampPost_Delte extends MySuite {
	
	LoginPage lg;
	T5LampTree ig;

	@BeforeClass
	public void beforeMethod() throws Exception{
		String lamp[]={"sm_lamppost"};
		dc.recoverdatatable(lamp);
		dc.insertdatatable(lamp);
	}
	
	@Test(description = "测试灯杆_删除")
	public void testDelCity() throws Exception {
		// login page
		lg = new LoginPage(Driver.getDriver());
		// iotdm page
		ig = new T5LampTree(Driver.getDriver());

		lg.login("admin", "bmeB4000");
		// 进入主页
		lg.goHomePage();
		lg.goSystemPage();

		ig.inPage();
		ig.clickDel("testEditLampPost","testEditLampPost","roadTestModify");

		lg.assertEquals("操作结果 : ",lg.getRespMessage(), "操作成功");

		Map<String,Object> m = jdbcTemplate.queryForMap("select count(*) as num from sm_lamppost t where t.lamppost_num_='testEdiLampPost';");
		lg.assertEquals("num :", m.get("num").toString(),"0");
	}
}
