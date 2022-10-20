package com.rk.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan("com.rk")
public class AppConfig {
	@Bean
  public JavaMailSenderImpl kmsi() {
	  JavaMailSenderImpl jms=new JavaMailSenderImpl();
	  jms.setHost("smtp.gmail.com");
	  jms.setPort(465);
	  jms.setUsername("ravikumarhariharganj@gmail.com");
	  jms.setPassword("RAVIkumar@1234");
	  jms.setJavaMailProperties(pro());
	return jms;
	  
	  
  }
	@Bean
	public Properties pro() {
		Properties p=new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		return p;
	}
}
