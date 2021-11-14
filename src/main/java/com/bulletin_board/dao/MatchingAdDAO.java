package com.bulletin_board.dao;

import com.bulletin_board.domain.MatchingAd;

public abstract class MatchingAdDAO extends CrudDAO<MatchingAd> {

    public abstract void deleteAllItemsByAuthorId(int id);

    public abstract void deleteAllItemsByCategoryId(int id);
}
