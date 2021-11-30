package com.bulletin_board.service;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.dto.AdvertDTO;

import java.time.LocalDate;
import java.util.List;

public interface AdvertService extends CRUDService<Advert, AdvertDTO> {

    void deleteAdvertsByAuthorId(int id);

    void deleteAdvertsByCategoryId(int id);

    List<AdvertDTO> findAdvertsByAuthorId(int id);

    List<AdvertDTO> findAdvertsByCategoriesID(List<Integer> categoryIds);

    List<AdvertDTO> findAdvertsByDate(LocalDate date);

    List<AdvertDTO> findAdvertsByKeyWord(String keyWord);

    void deleteNotActive();
}
