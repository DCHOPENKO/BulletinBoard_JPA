package com.bulletin_board.dao.impl;

import com.bulletin_board.Category;
import com.bulletin_board.dao.AdvertDAO;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.MatchingAdDAO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryDAOImpl extends CrudDAO<Category> {

    AdvertDAO advertDao;
    MatchingAdDAO matchingAdDAO;

    public CategoryDAOImpl() {
        advertDao = new AdvertDAOImpl();
        matchingAdDAO = new MatchingAdDAOImpl();
    }

    @Override
    public void deleteItemById(int id, Class<Category> aClass) {
        advertDao.deleteAllItemsByCategoryId(id);
        matchingAdDAO.deleteAllItemsByCategoryId(id);
        super.deleteItemById(id, aClass);
    }
}
