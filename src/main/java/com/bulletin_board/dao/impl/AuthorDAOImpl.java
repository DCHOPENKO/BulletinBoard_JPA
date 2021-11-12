package com.bulletin_board.dao.impl;

import com.bulletin_board.Author;
import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.MatchingAdDAO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static com.bulletin_board.util.ConstantsUtil.ENTITY_FACTORY;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorDAOImpl extends CrudDAO<Author> {

    AdvertDAO advertDao;
    MatchingAdDAO matchingAdDAO;

    public AuthorDAOImpl() {
        advertDao = new AdvertDAOImpl();
        matchingAdDAO = new MatchingAdDAOImpl();
    }


    @Override
    public void deleteItemById(int id) {
        advertDao.deleteAllItemsByAuthorId(id);
        matchingAdDAO.deleteAllItemsByAuthorId(id);

        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author object = em.getReference(Author.class, id);
        em.remove(object);
        transaction.commit();
        em.close();

    }
}
