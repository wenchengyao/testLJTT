package com.isst.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.isst.Application;
import com.isst.context.Base;
import com.isst.context.DaoCon;
import com.isst.listeners.TestListener;

@Listeners(TestListener.class)
public class MySuite extends Base {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	ApplicationContext ac;
	
	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("before suit TODO");
		if(!Application.started){
			ac = SpringApplication.run(Application.class);
			Application.started = true;
		}else{
			ac = Application.get();
		}

//		String mss[] = {"sm_user"};
		String mss[] = {};
		try {
			DaoCon dc = ac.getBean(DaoCon.class);
			dc.recoverdatatable(mss);
			dc.insertdatatable(mss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void AfterSuit() {
		System.out.println("after suit TODO");
	}
}
