package com.bulletin_board.dao;

import com.bulletin_board.domain.Advert;

import java.util.List;

public interface EmailDAO {

    List<String> getEmailsByMatchingAdRequests(Advert advert);

}
