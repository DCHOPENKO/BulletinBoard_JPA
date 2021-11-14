package com.bulletin_board.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import static com.bulletin_board.util.ConstantsUtil.*;

@Transactional
public abstract class CrudDAO<T> {

    @PersistenceContext
    EntityManager em;

    public void save(T t) {
        em.persist(t);
    }

    public void update(T t) {
        T mergedT = em.merge(t);
        em.persist(mergedT);
    }

    public void deleteItemById(int id, Class<T> aClass) {
        Query query = em.createQuery(DELETE_FROM + aClass.getSimpleName() + WHERE_BY_ID);
        query.setParameter(PARAMETER_ID, id);
        query.executeUpdate();
    }

    public T getById(int id, Class<T> aClass) {
        TypedQuery<T> query = em.createQuery(FROM + aClass.getSimpleName() + WHERE_BY_ID, aClass);
        query.setParameter(PARAMETER_ID, id);
        return query.getSingleResult();
    }
}
