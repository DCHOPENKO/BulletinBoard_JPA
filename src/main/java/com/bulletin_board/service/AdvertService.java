package com.bulletin_board.service;

import com.bulletin_board.domain.Advert;

import java.time.LocalDate;
import java.util.List;

public interface AdvertService extends CRUDService<Advert> {

    void deleteAdvertsByAuthorId(int id);

    void deleteAdvertsByCategoryId(int id);

    List<Advert> findAdvertsByAuthorId(int id);

    List<Advert> findAdvertsByCategoriesID(List<Integer> categoryIds);

    List<Advert> findAdvertsByDate(LocalDate date);

    List<Advert> findAdvertsByKeyWord(String keyWord);
}
