package com.bulletin_board.dao;

import com.bulletin_board.domain.Advert;

import java.time.LocalDate;
import java.util.List;

public abstract class AdvertDAO extends CrudDAO<Advert> {

    public abstract List<Advert> findAllAdvertsByAuthorId(int id);

    public abstract List<Advert> findAllAdvertsByCategoriesID(List<Integer> categoryIds);

    public abstract List<Advert> findAllAdvertsByDate(LocalDate date);

    public abstract List<Advert> findAllAdvertsByKeyWord(String keyWord);

    public abstract void deleteAllItemsByAuthorId(int id);

    public abstract void deleteAllItemsByCategoryId(int id);

}
