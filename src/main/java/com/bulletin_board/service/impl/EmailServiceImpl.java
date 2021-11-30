package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.repository.EmailAddressRepository;
import com.bulletin_board.service.EmailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    EmailAddressRepository repo;
    JavaMailSenderImpl jms;

    @Override
    public void sendEmails(Advert advert) {

        List<String> emails = getEmailsByMatchingAdRequests(advert);
        if (emails.isEmpty()) {
            return;
        }
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

        jms.send(message);
    }

    private List<String> getEmailsByMatchingAdRequests(Advert advert) {
        return repo.getEmailsByMatchingAdRequests(advert.getCategory().getId(), advert.getTitle(), advert.getPrice());
    }

}
