package com.isst.context;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Listeners;

import com.isst.Application;
import com.isst.listeners.BootListener;
import com.isst.listeners.TestListener;
import com.isst.listeners.WebDriverListener;

@Listeners({TestListener.class, BootListener.class, WebDriverListener.class})
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
	protected String docpath; //测试数据库存储位置
	
	@Value("${docsource}")
	protected String docsource; //原数据库数据存储位置

	@Value("${dbback}")
	protected boolean dbback; //是否备份
	
	@Value("${dbresume}")
	protected boolean dbresume; //是否还原
	
	@Value("${dballtablename}")
	protected String dballtablename; //
	
	@Value("${dbus}")
	protected String dbus; //驱动器路径

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
	
	public String getDocsource() {
		return docsource;
	}

	public Boolean getDbback() {
		return dbback;
	}
	
	public Boolean getDbresume() {
		return dbresume;
	}
	
	public String getdbAlltablename() {
		return dballtablename;
	}
	
	public String getDbus() {
		return dbus;
	}
}
