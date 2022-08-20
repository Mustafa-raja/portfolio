package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailsender {
	@Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String sub, String content)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mustafa.r4j4@gmail.com"); //change accordingly
        message.setTo(to);
        message.setSubject(sub);
        message.setText(content);
        mailSender.send(message);

        System.out.println("mail sent successfully");
    }
}
