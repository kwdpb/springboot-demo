package com.kw.service.impl;

import com.kw.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;


    @Override
    public void simpleTextMail() {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo("3292974094@qq.com");
        message.setSubject("测试邮件");
        message.setText("测试邮件");
        mailSender.send(message);
    }

    @Override
    public void htmlMail() {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        String content="<html>\n"+"<body>\n"+"<h3>hello world</h3>"+"</body>\n"+"</html>";
        try {
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(from);
            helper.setTo("3292974094@qq.com");
            helper.setSubject("测试html邮件");
            helper.setText(content,true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void attachMail() {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper= null;
        String content="<html>\n"+"<body>\n"+"<h3>hello world</h3>"+"</body>\n"+"</html>";
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo("3292974094@qq.com");
            helper.setSubject("测试html邮件");
            helper.setText(content,true);

            String path="D:\\BugReport.txt";
            File file=new File(path);
            FileSystemResource fileSystemResource=new FileSystemResource(file);
            String fileName=path.substring(path.lastIndexOf(File.separator));
            helper.addAttachment(fileName,fileSystemResource);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }



    }


}
