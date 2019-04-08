package com.isst.tests.setting;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.isst.driver.Driver;
import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T5LampTree;
import com.isst.tests.MySuite;


public class LampPost_Edit extends MySuite {
	
	LoginPage lg;
	T5LampTree ig;

	@BeforeClass
	public void beforeMethod() throws Exception{
		String lamp[]={"sm_lamppost"};
		dc.recoverdatatable(lamp);
		dc.insertdatatable(lamp);
	}
	
	@Test(description = "测试灯杆_修改")
	public void testEditCity() throws Exception {
		// login page
		lg = new LoginPage(Driver.getDriver());
		// iotdm page
		ig = new T5LampTree(Driver.getDriver());

		lg.login("admin", "bmeB4000");
		// 进入主页
		lg.goHomePage();
		lg.goSystemPage();

		ig.inPage();
		ig.clickEdit("testEditLampPost","testEditLampPost","roadTestModify");
		ig.fillNode("testEditLampPt1", "testEdiLampPost", "100.012345", "30.065432",null);
		ig.selectStreet("testEditArchCenter", "roadTestModify");
		ig.confirm();

		lg.assertEquals("操作结果 : ",lg.getRespMessage(), "操作成功");

		Map<String,Object> m = jdbcTemplate.queryForMap("select * from sm_lamppost t where t.lamppost_num_='testEdiLampPost';");
		lg.assertEquals("arch_id_ :", m.get("arch_id_").toString(),"10005");
		lg.assertEquals("arch_name_ :", m.get("arch_name_").toString(),"roadTestModify");
		lg.assertNull("description_ :", m.get("description_"));
		lg.assertNull("device_type_id_ :", m.get("device_type_id_"));
		lg.assertNull("excel_row_ :", m.get("excel_row_"));
		lg.assertEquals("lamppost_num_ :", m.get("lamppost_num_").toString(),"testEdiLampPost");
		lg.assertEquals("longitude_ :", m.get("longitude_").toString(),"100.012345");
		lg.assertEquals("latitude_ :", m.get("latitude_").toString(),"30.065432");
		lg.assertEquals("name_ :", m.get("name_").toString(),"testEditLampPt1");
		lg.assertNull("online_status_ :", m.get("online_status_"));
		lg.assertNull("sensor_id :", m.get("sensor_id"));
		lg.assertNull("create_use_ :", m.get("create_use_"));
	}
}
