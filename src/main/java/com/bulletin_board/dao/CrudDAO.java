package com.bulletin_board.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static com.bulletin_board.util.ConstantsUtil.*;

public abstract class CrudDAO<T> {

    public void save(T t) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(t);
        transaction.commit();
        em.close();
    }

    public void update(T t) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T mergedT = em.merge(t);
        em.persist(mergedT);
        transaction.commit();
        em.close();
    }

    public void deleteItemById(int id, Class<T> aClass) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery(DELETE_FROM + aClass.getSimpleName() + WHERE_BY_ID);
        query.setParameter(PARAMETER_ID, id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public T getById(int id, Class<T> aClass) {
        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<T> query = em.createQuery(FROM + aClass.getSimpleName() + WHERE_BY_ID, aClass);
        query.setParameter(PARAMETER_ID, id);
        T result = query.getSingleResult();
        transaction.commit();
        em.close();
        return result;
    }
}
