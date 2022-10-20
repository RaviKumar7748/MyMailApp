package com.rk.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class RaviMailService {
	@Autowired
	private JavaMailSender sender;

	public boolean send(String to,String Subject,String text,String[] ccc,String[] bcc,Resource file) {
		boolean flag=false;
		MimeMessage message =sender.createMimeMessage();
		// comment here 
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,file!=null?true:false);
			helper.setTo(to);
			helper.setSubject(Subject);
			helper.setText(text);
			if(bcc!=null && bcc.length>0)
			helper.setBcc(bcc);
			if(ccc!=null && ccc.length>0)
			helper.setCc(ccc);
			if(file!=null)
			helper.addAttachment(file.getFilename(), file);
			sender.send(message);
			flag=true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	
		return flag;
	}

}
