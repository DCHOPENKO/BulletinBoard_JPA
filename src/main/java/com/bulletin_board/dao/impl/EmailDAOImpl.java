package com.bulletin_board.dao.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.dao.EmailDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static com.bulletin_board.util.ConstantsUtil.*;

@Repository
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailDAOImpl implements EmailDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<String> getEmailsByMatchingAdRequests(Advert advert) {
        TypedQuery<String> query = em.createQuery(QUERY_CHECK_MATCHING_AD_BY_ADVERT, String.class);
        query.setParameter(PARAMETER_CATEGORY, advert.getCategory().getId());
        query.setParameter(PARAMETER_ADVERT_TITLE, advert.getTitle());
        query.setParameter(PARAMETER_ADVERT_PRICE, advert.getPrice());
        return query.getResultList();
    }
}
