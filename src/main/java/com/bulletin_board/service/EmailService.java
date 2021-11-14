package com.bulletin_board.service;

import com.bulletin_board.domain.Advert;

public interface EmailService {

    void sendEmails(Advert advert);
}
