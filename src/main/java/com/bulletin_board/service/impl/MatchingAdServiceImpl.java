package com.bulletin_board.service.impl;

import com.bulletin_board.domain.MatchingAd;
import com.bulletin_board.dao.MatchingAdDAO;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MatchingAdServiceImpl implements CRUDService<MatchingAd> {

    MatchingAdDAO dao;

    public void save(MatchingAd matchingAd) {
        dao.save(matchingAd);
    }

    public void deleteById(int id) {
        dao.deleteItemById(id, MatchingAd.class);
    }

    public MatchingAd getById(int id) {
        return dao.getById(id, MatchingAd.class);
    }

    public void update(MatchingAd matchingAd) {
            dao.update(matchingAd);

    }
}

