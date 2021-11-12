package com.bulletin_board.service.impl;

import com.bulletin_board.Advert;
import com.bulletin_board.service.EmailService;
import com.bulletin_board.dao.EmailDAO;
import com.bulletin_board.dao.impl.EmailDAOImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailServiceImpl implements EmailService {

    EmailDAO dao;

    public EmailServiceImpl() {
        dao = new EmailDAOImpl();
    }

    @Override
    public void sendEmails(Advert advert) {
        //logic for sending emails
        getEmailsByMatchingAdRequests(advert).forEach(System.out::println);
    }

    private List<String> getEmailsByMatchingAdRequests(Advert advert) {
        return dao.getEmailsByMatchingAdRequests(advert);
    }

}
