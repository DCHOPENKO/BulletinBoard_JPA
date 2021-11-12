package com.bulletin_board.dao.impl;

import com.bulletin_board.Advert;
import com.bulletin_board.Advert_;
import com.bulletin_board.dao.AdvertDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

import static com.bulletin_board.util.ConstantsUtil.*;

public class AdvertDAOImpl extends AdvertDAO {



    public void deleteAllItemsByAuthorId(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_ADVERT_BY_AUTHOR_ID);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public void deleteAllItemsByCategoryId(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery(QUERY_BATCH_DELETE_FROM_ADVERT_BY_CATEGORY_ID);
        query.setParameter(PARAMETER_CATEGORY_ID, id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public List<Advert> findAllAdvertsByAuthorId(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_AUTHOR_ID, Advert.class);
        query.setParameter(PARAMETER_AUTHOR_ID, id);
        List<Advert> adverts = query.getResultList();
        transaction.commit();
        em.close();
        return adverts;
    }

    public List<Advert> findAllAdvertsByCategoriesID(List<Integer> categoryIds) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_CATEGORY_IDS, Advert.class);
        query.setParameter(PARAMETER_CATEGORY_IDS, categoryIds);
        List<Advert> adverts = query.getResultList();
        transaction.commit();
        em.close();
        return adverts;
    }

    public List<Advert> findAllAdvertsByDate(LocalDate date) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_DATE, Advert.class);
        query.setParameter(PARAMETER_ADVERT_DATE, date);
        List<Advert> adverts = query.getResultList();
        transaction.commit();
        em.close();
        return adverts;
    }

    public List<Advert> findAllAdvertsByKeyWord(String keyWord) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Advert> query = em.createQuery(QUERY_FIND_BY_KEYWORD, Advert.class);
        query.setParameter(PARAMETER_KEYWORD, keyWord);
        List<Advert> adverts = query.getResultList();
        transaction.commit();
        em.close();
        return adverts;
    }

    @Override
    public void deleteItemById(int id) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<Advert> criteriaDelete = builder.createCriteriaDelete(Advert.class);
        Root<Advert> root = criteriaDelete.from(Advert.class);
        Path<Integer> pathId = root.get(Advert_.id);
        criteriaDelete.where(builder.equal(pathId, id));
        em.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();
        em.close();
    }
}
