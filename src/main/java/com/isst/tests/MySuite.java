package com.isst.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.isst.context.Base;
import com.isst.context.DaoCon;
import com.isst.listeners.BootListener;
import com.isst.listeners.TestListener;

@Listeners({TestListener.class, BootListener.class})
public class MySuite extends Base {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected static DaoCon dc;
	
	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("before suit TODO");

		String mss[] = {};
		try {
			dc = BootListener.ac.getBean(DaoCon.class);
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
