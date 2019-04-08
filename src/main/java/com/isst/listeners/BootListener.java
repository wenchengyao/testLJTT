package com.isst.listeners;

import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.IExecutionListener;

import com.isst.Application;
import com.isst.context.DaoCon;

public class BootListener implements IExecutionListener {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static ApplicationContext ac;
	
	@Autowired
	private DaoCon dc;
	
	@Override
	public void onExecutionStart(){
		System.out.println("executeStarted");
		//如果是通过插件运行，需要现运行spring boot，这样能够找到注入的bean
		if(!Application.started){
			ac = SpringApplication.run(Application.class);
			Application.started = true;
		}else{
			ac = Application.get();
		}
		
		
		dc= ac.getBean(DaoCon.class);
		try {
			dc.backupDB();
			//刷入测试库
			dc.recoverDB("sourceData");
			//备份数据
			dc.back();
		} catch (DatabaseUnitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onExecutionFinish(){
		//结束后执行恢复数据库动作
		System.out.println("executeFinished");
		try {
			//还原数据库，到最初状态
			dc.recoverDB(null);
		} catch (DatabaseUnitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
