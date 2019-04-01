package com.isst.context;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;

import com.isst.Application;
import com.isst.listeners.WebDriverListener;

@Listeners(WebDriverListener.class)
@SpringBootTest(classes = Application.class) //需要测试的类注入
@RunWith(SpringRunner.class)
public abstract class Base extends AbstractTestNGSpringContextTests {
	@Value("${appUrl}")
	protected String appUrl;
	
	@Value("${browser}")
	protected String browser;
	
	@Value("${spring.datasource.driverClassName}")
	protected String dbdrivername;
	
	@Value("${docpath}")
	protected String docpath;

	@Value("${dbback}")
	protected boolean dbback; //是否备份
	
	@Value("${dballtablename}")
	protected String dballtablename; //是否备份

    public String getAppUrl() {
        return appUrl;
    }

    public String getBrowser() {
        return browser;
    }
    
	public String getDbdrivername() {
		return dbdrivername;
	}

	public String getDocpath() {
		return docpath;
	}

	public Boolean getDbback() {
		return dbback;
	}
	
	public String getdbAlltablename() {
		return dballtablename;
	}
}
