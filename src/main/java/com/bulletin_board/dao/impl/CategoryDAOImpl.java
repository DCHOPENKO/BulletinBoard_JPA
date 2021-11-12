package com.bulletin_board.dao.impl;

import com.bulletin_board.Category;
import com.bulletin_board.Category_;
import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.MatchingAdDAO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import static com.bulletin_board.util.ConstantsUtil.ENTITY_FACTORY;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryDAOImpl extends CrudDAO<Category> {

    AdvertDAO advertDao;
    MatchingAdDAO matchingAdDAO;

    public CategoryDAOImpl() {
        advertDao = new AdvertDAOImpl();
        matchingAdDAO = new MatchingAdDAOImpl();
    }

    @Override
    public void deleteItemById(int id) {
        advertDao.deleteAllItemsByCategoryId(id);
        matchingAdDAO.deleteAllItemsByCategoryId(id);

        EntityManager em = ENTITY_FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<Category> criteriaDelete = builder.createCriteriaDelete(Category.class);
        Root<Category> root = criteriaDelete.from(Category.class);
        Path<Integer> pathId = root.get(Category_.id);
        criteriaDelete.where(builder.equal(pathId, id));
        em.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();
        em.close();
    }


}
