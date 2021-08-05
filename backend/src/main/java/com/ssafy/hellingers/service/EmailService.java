package com.ssafy.hellingers.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String toEmail, String subject, String message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        System.out.println("받는 사람: "+toEmail);

        helper.setFrom("Helngers"); // 보내는 사람
        helper.setSubject("[Helngers] 메일을 인증해주세요."); // 메일 제목
        helper.setText(message, true); // 내용을 html 형식으로 보내기 위함. 이때 html은 controlloer에 작성.
        helper.setTo(toEmail);
        javaMailSender.send(mimeMessage);
    }
}