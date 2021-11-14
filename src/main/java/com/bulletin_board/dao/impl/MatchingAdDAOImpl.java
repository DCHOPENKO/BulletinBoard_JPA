package com.bulletin_board.dao.impl;

import com.bulletin_board.dao.MatchingAdDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static com.bulletin_board.util.ConstantsUtil.*;

@Repository
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchingAdDAOImpl extends MatchingAdDAO {

    @PersistenceContext
    EntityManager em;

    public void deleteAllItemsByAuthorId(int id) {
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_AUTHOR_ID);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        query.executeUpdate();
    }

    public void deleteAllItemsByCategoryId(int id) {
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_CATEGORY_ID);
        query.setParameter(PARAMETER_CATEGORY_ID, id);
        query.executeUpdate();
    }


}
