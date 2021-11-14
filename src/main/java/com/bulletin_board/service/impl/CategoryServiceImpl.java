package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Category;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.dao.impl.CategoryDAOImpl;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.util.ValidatorUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryServiceImpl implements CRUDService<Category> {

    @Qualifier("categoryDAOImpl")
    CrudDAO<Category> dao;

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
        dao.deleteItemById(id, Category.class);
    }
}
