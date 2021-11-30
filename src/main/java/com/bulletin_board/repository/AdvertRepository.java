package com.bulletin_board.repository;

import com.bulletin_board.domain.Advert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
public interface AdvertRepository extends CustomRepository<Advert> {

    void deleteAllByAuthor_Id(int id);

    void deleteAllByCategory_Id(int id);

    List<Advert> findAllByAuthor_Id(int id);

    @Query("FROM Advert a WHERE a.category.id IN (:categoryIds)")
    List<Advert> findAllByCategoriesId(@Param("categoryIds") List<Integer> categoryIds);

    List<Advert> findAllByPublicationDate(LocalDate date);

    List<Advert> findAllByTitleContaining(@Param("word") String word);

    void deleteAllByIsActiveIsFalse();

}
