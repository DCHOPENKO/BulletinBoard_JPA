package com.bulletin_board.service.impl;

import com.bulletin_board.Category;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.impl.CategoryDAOImpl;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.util.ValidatorUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CRUDService<Category> {

    CrudDAO<Category> dao;

    public CategoryServiceImpl() {
        dao = new CategoryDAOImpl();
    }

    public void save(Category category) {
        if (ValidatorUtil.validate(category)) {
            dao.save(category);
        }
    }

    public Category getById(int id) {
        return dao.getById(id, Category.class);
    }

    public void update(Category category) {
        if (ValidatorUtil.validate(category)) {
            dao.update(category);
        }
    }

    public void deleteById(int id) {
        dao.deleteItemById(id);
    }
}
