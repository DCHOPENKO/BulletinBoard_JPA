package com.bulletin_board.dao.impl;

import com.bulletin_board.dao.MatchingAdDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static com.bulletin_board.util.ConstantsUtil.*;

public class MatchingAdDAOImpl extends MatchingAdDAO {

    public void deleteAllItemsByAuthorId(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_AUTHOR_ID);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public void deleteAllItemsByCategoryId(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_CATEGORY_ID);
        query.setParameter(PARAMETER_CATEGORY_ID, id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }


}
