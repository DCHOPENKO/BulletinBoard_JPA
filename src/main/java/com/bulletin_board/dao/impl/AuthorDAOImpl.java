package com.bulletin_board.dao.impl;

import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.MatchingAdDAO;
import com.bulletin_board.domain.Author;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDAOImpl extends CrudDAO<Author> {

    @PersistenceContext
    EntityManager em;

    final AdvertDAO advertDao;
    final MatchingAdDAO matchingAdDAO;

    public AuthorDAOImpl(AdvertDAO advertDao, MatchingAdDAO matchingAdDAO) {
        this.advertDao = advertDao;
        this.matchingAdDAO = matchingAdDAO;
    }

    @Override
    public void deleteItemById(int id, Class<Author> aClass) {
        advertDao.deleteAllItemsByAuthorId(id);
        matchingAdDAO.deleteAllItemsByAuthorId(id);
        Author object = em.getReference(aClass, id);
        em.remove(object);
    }
}
