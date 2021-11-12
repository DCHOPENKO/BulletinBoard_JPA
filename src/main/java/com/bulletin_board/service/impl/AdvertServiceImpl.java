package com.bulletin_board.service.impl;

import com.bulletin_board.Advert;
import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.service.AdvertService;
import com.bulletin_board.service.EmailService;
import com.bulletin_board.util.ValidatorUtil;
import com.bulletin_board.dao.impl.AdvertDAOImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdvertServiceImpl implements AdvertService {

    EmailService eService;
    AdvertDAO dao;

    public AdvertServiceImpl() {
        eService = new EmailServiceImpl();
        dao = new AdvertDAOImpl();
    }

    public void save(Advert advert) {
        if (ValidatorUtil.validate(advert)) {
            dao.save(advert);
            eService.sendEmails(advert);
        }
    }

    public void deleteById(int id) {
        dao.deleteItemById(id, Advert.class);
    }

    public Advert getById(int id) {
        return dao.getById(id, Advert.class);
    }

    public void update(Advert advert) {
        if (ValidatorUtil.validate(advert)) {
            dao.update(advert);
        }
    }

    public void deleteAdvertsByAuthorId(int id) {
        dao.deleteAllItemsByAuthorId(id);
    }

    public void deleteAdvertsByCategoryId(int id) {
        dao.deleteAllItemsByCategoryId(id);
    }

    public List<Advert> findAdvertsByAuthorId(int id) {
        return dao.findAllAdvertsByAuthorId(id);
    }

    public List<Advert> findAdvertsByCategoriesID(List<Integer> categoryIds) {
        return dao.findAllAdvertsByCategoriesID(categoryIds);
    }

    public List<Advert> findAdvertsByDate(LocalDate date) {
        return dao.findAllAdvertsByDate(date);
    }

    public List<Advert> findAdvertsByKeyWord(String keyWord) {
        return dao.findAllAdvertsByKeyWord(keyWord);
    }


}
