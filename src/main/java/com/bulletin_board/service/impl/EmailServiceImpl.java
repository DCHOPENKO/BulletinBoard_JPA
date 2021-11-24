package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.service.EmailService;
import com.bulletin_board.dao.EmailDAO;
import com.bulletin_board.dao.impl.EmailDAOImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    EmailDAO dao;
    JavaMailSenderImpl jvc;

    @Override
    public void sendEmails(Advert advert) {

        List<String> emails = getEmailsByMatchingAdRequests(advert);
        String[] ems = new String[emails.size()];
        String[] strings = emails.toArray(ems);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(strings);
        message.setSubject("find advert by your subscribe");
        message.setText("Hello Dear \n" +
                "By your subscribe we have new advert \n" +
                "Advert details \n" +
                " name : " + advert.getName() +
                "\n title : " + advert.getTitle() +
                "\n price : " + advert.getPrice() +
                "\n \n \n have a nice day");

        jvc.send(message);
    }

    private List<String> getEmailsByMatchingAdRequests(Advert advert) {
        return dao.getEmailsByMatchingAdRequests(advert);
    }

}
