package com.rk.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rk.config.AppConfig;
import com.rk.service.RaviMailService;

public class Test {

	public static void main(String[] args) {
      ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
     RaviMailService mail =ac.getBean("raviMailService",RaviMailService.class);
     boolean flag=mail.send("ravikumargupta1812@gmail.com", "welcome", "hy ravi", null,null, null);
     if(flag) {
    	 System.out.print("message send successflly");
    	 
     }
     else {
    	 System.out.println("message not send");
     }
	}

}
