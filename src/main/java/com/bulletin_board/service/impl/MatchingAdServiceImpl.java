package com.bulletin_board.service.impl;

import com.bulletin_board.MatchingAd;
import com.bulletin_board.dao.MatchingAdDAO;
import com.bulletin_board.dao.impl.MatchingAdDAOImpl;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.util.ValidatorUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MatchingAdServiceImpl implements CRUDService<MatchingAd> {
    MatchingAdDAO dao;

    public MatchingAdServiceImpl() {
        dao = new MatchingAdDAOImpl();
    }

    public void save(MatchingAd matchingAd) {
        if (ValidatorUtil.validate(matchingAd)) {
            dao.save(matchingAd);
        }
    }

    public void deleteById(int id) {
        dao.deleteItemById(id);
    }

    public MatchingAd getById(int id) {
        return dao.getById(id, MatchingAd.class);
    }

    public void update(MatchingAd matchingAd) {
        if (ValidatorUtil.validate(matchingAd)) {
            dao.update(matchingAd);
        }
    }
}

