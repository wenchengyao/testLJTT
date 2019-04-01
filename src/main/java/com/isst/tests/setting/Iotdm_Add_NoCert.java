package com.isst.tests.setting;

import java.util.Map;

import org.testng.annotations.Test;

import com.isst.driver.Driver;
import com.isst.pageobject.LoginPage;
import com.isst.pageobject.system.T1IotdmPage;
import com.isst.tests.MySuite;

public class Iotdm_Add_NoCert extends MySuite {
	
	LoginPage lg;
	T1IotdmPage ig;

	@Test(description = "测试Iotdm_修改_noCert")
	public void testlogin() throws Exception {
		// login page
		lg = new LoginPage(Driver.getDriver());
		// iotdm page
		ig = new T1IotdmPage(Driver.getDriver());

		lg.login("admin", "bmeB4000");
		// 进入主页
		lg.goHomePage();
		lg.goSystemPage();

		ig.inPage();
		ig.authIotdmNoCert("127.0.0.1", "28080");

		lg.assertEquals("操作结果 : ",lg.getRespMessage(), "操作成功");

		Map<String,Object> m = jdbcTemplate.queryForMap("select * from sm_iotdm limit 1;");
		lg.assertEquals("ip_addr_ :", m.get("ip_addr_").toString(),"127.0.0.1");
		lg.assertEquals("is_https_ :", m.get("is_https_").toString(),"0");
		lg.assertEquals("port_ :", m.get("port_").toString(),"28080");
		lg.assertEquals("status_ :", m.get("status_").toString(),"1");
		lg.assertEquals("del_flag_ :", m.get("del_flag_").toString(),"0");
	}

}
