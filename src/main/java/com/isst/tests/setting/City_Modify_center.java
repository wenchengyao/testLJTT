package com.isst.tests.setting;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.isst.driver.Driver;
import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T7CityPage;
import com.isst.tests.MySuite;


public class City_Modify_center extends MySuite {
	
	LoginPage lg;
	T7CityPage ig;

	@BeforeClass
	public void beforeMethod() throws Exception{
		String owner[]={"sm_architecture"};
		dc.recoverdatatable(owner);
		dc.insertdatatable(owner);
	}
	
	@Test(description = "测试建筑_修改_区域")
	public void testModifyCountry() throws Exception {
		// login page
		lg = new LoginPage(Driver.getDriver());
		// iotdm page
		ig = new T7CityPage(Driver.getDriver());

		lg.login("admin", "bmeB4000");
		// 进入主页
		lg.goHomePage();
		lg.goSystemPage();

		ig.inPage();
		ig.clickEdit("区域", "centerTestModify");
		ig.fillNode("testEditArchCenter", null, "100.012345", "30.065432","1234abcd!@#$%^&*()_+-={}[]:\";'<>?,./'");
		ig.confirm();

		lg.assertEquals("操作结果 : ",lg.getRespMessage(), "操作成功");

		Map<String,Object> m = jdbcTemplate.queryForMap("select * from sm_architecture t where t.number_='ADcenterTestModify';");
		lg.assertEquals("description_ :", m.get("description_").toString(),"1234abcd!@#$%^&*()_+-={}[]:\";'<>?,./'");
		lg.assertEquals("has_child_ :", m.get("has_child_").toString(),"1");
		lg.assertEquals("latitude_ :", m.get("latitude_").toString(),"30.065432");
		lg.assertEquals("longitude_ :", m.get("longitude_").toString(),"100.012345");
		lg.assertEquals("level_ :", m.get("level_").toString(),"3");
		lg.assertEquals("name_ :", m.get("name_").toString(),"testEditArchCenter");
		lg.assertEquals("number_ :", m.get("number_").toString(),"ADcenterTestModify");
		lg.assertEquals("parent_id_ :", m.get("parent_id_").toString(),"10001");
		lg.assertNull("parent_name_ :", m.get("parent_name_"));
//		lg.assertEquals("search_code_ :", m.get("search_code_").toString(),m.get("arch_id_").toString() + "|");
	}
}
