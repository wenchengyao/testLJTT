package com.isst.tests.setting;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.isst.driver.Driver;
import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T7CityPage;
import com.isst.tests.MySuite;


public class City_Delete_city extends MySuite {
	
	LoginPage lg;
	T7CityPage ig;

	@BeforeClass
	public void beforeMethod() throws Exception{
		String owner[]={"sm_architecture"};
		dc.recoverdatatable(owner);
		dc.insertdatatable(owner);
	}
	
	@Test(description = "测试建筑_删除_城市")
	public void testDeleteCountry() throws Exception {
		// login page
		lg = new LoginPage(Driver.getDriver());
		// iotdm page
		ig = new T7CityPage(Driver.getDriver());

		lg.login("admin", "bmeB4000");
		// 进入主页
		lg.goHomePage();
		lg.goSystemPage();

		ig.inPage();
		ig.clickDel("城市", "cityTestDelete");

		lg.assertEquals("操作结果 : ",lg.getRespMessage(), "操作成功");

		Map<String,Object> m = jdbcTemplate.queryForMap("select count(1) as num from sm_architecture t where t.number_='ADcityTestDelete';");
		lg.assertEquals("num :", m.get("num").toString(),"0");
	}
}
