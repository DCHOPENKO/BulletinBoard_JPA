package com.bulletin_board.dao.impl;

import com.bulletin_board.Advert;
import com.bulletin_board.dao.EmailDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.bulletin_board.util.ConstantsUtil.*;

public class EmailDAOImpl implements EmailDAO {

    @Override
    public List<String> getEmailsByMatchingAdRequests(Advert advert) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<String> query = em.createQuery(QUERY_CHECK_MATCHING_AD_BY_ADVERT, String.class);
        query.setParameter(PARAMETER_CATEGORY, advert.getCategory());
        query.setParameter(PARAMETER_ADVERT_TITLE, advert.getTitle());
        query.setParameter(PARAMETER_ADVERT_PRICE, advert.getPrice());

        List<String> emails = query.getResultList();

        transaction.commit();
        em.close();
        return emails;
    }
}
