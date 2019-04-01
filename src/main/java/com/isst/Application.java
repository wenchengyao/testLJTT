package com.isst;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.isst.context.DaoCon;

@SpringBootApplication
public class Application {
	//global
	public static boolean started = false;
	
	private static ApplicationContext ac;
	
	public static ApplicationContext get(){
		return ac;
	}
	

    public static void main(final String[] args) throws Exception {
        ac = SpringApplication.run(Application.class, args);
        started = true;

        ApplicationHome ah = new ApplicationHome(Application.class);
        File jarFile = ah.getSource();
        String url = jarFile.getParent().toString();
        InputStream testngStream = Application.class.getClassLoader().getResourceAsStream("testng.xml");
        File testngFile = new File(url + "/testng.xml");
        try{
        	FileUtils.copyInputStreamToFile(testngStream, testngFile);
        }catch(IOException e){
        	e.printStackTrace();
        }
        
        org.testng.TestNG.main(new String[]{url + "/testng.xml"});
    }
    
    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource){
    	return new JdbcTemplate(dataSource);
    }
    
    @Bean
    DaoCon daoCon() {
    	return new DaoCon();
    }
}