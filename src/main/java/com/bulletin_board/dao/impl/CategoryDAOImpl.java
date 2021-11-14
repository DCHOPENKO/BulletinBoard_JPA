package com.bulletin_board.dao.impl;

import com.bulletin_board.domain.Category;
import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.MatchingAdDAO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryDAOImpl extends CrudDAO<Category> {

    AdvertDAO advertDao;
    MatchingAdDAO matchingAdDAO;

    @Override
    public void deleteItemById(int id, Class<Category> aClass) {
        advertDao.deleteAllItemsByCategoryId(id);
        matchingAdDAO.deleteAllItemsByCategoryId(id);
        super.deleteItemById(id, aClass);
    }
}
