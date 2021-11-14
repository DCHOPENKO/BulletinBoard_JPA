package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.service.EmailService;
import com.bulletin_board.dao.EmailDAO;
import com.bulletin_board.dao.impl.EmailDAOImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    EmailDAO dao;

    @Override
    public void sendEmails(Advert advert) {
        //logic for sending emails
        getEmailsByMatchingAdRequests(advert).forEach(System.out::println);
    }

    private List<String> getEmailsByMatchingAdRequests(Advert advert) {
        return dao.getEmailsByMatchingAdRequests(advert);
    }

}
