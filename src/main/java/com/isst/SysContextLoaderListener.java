package com.isst;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.isst.context.DaoCon;


/**
 * 系统启动完成之后，备份一次数据库
 *
 * @author ygg
 */
@Component
public class SysContextLoaderListener implements ApplicationListener<ApplicationStartedEvent> {
	
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		ApplicationContext ac = event.getApplicationContext();
		try {
			DaoCon mp = ac.getBean(DaoCon.class);
			mp.back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
