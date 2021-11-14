package com.bulletin_board.dao.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.dao.AdvertDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static com.bulletin_board.util.ConstantsUtil.*;

@Repository
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvertDAOImpl extends AdvertDAO {

    @PersistenceContext
    EntityManager em;

    public void deleteAllItemsByAuthorId(int id) {
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_ADVERT_BY_AUTHOR_ID);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        query.executeUpdate();

    }

    public void deleteAllItemsByCategoryId(int id) {
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_ADVERT_BY_CATEGORY_ID);
        query.setParameter(PARAMETER_CATEGORY_ID, id);
        query.executeUpdate();
    }

    public List<Advert> findAllAdvertsByAuthorId(int id) {
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_AUTHOR_ID, Advert.class);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        return query.getResultList();
    }

    public List<Advert> findAllAdvertsByCategoriesID(List<Integer> categoryIds) {
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_CATEGORY_IDS, Advert.class);
        query.setParameter(PARAMETER_CATEGORY_IDS, categoryIds);
        return query.getResultList();
    }

    public List<Advert> findAllAdvertsByDate(LocalDate date) {
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_DATE, Advert.class);
        query.setParameter(PARAMETER_ADVERT_DATE, date);
        return query.getResultList();
    }

    public List<Advert> findAllAdvertsByKeyWord(String keyWord) {
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_KEYWORD, Advert.class);
        query.setParameter(PARAMETER_KEYWORD, keyWord);
        return query.getResultList();
    }
}
