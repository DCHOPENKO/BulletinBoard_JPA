package com.bulletin_board.service.impl;

import com.bulletin_board.Author;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.util.ValidatorUtil;
import com.bulletin_board.dao.impl.AuthorDAOImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements CRUDService<Author> {

    CrudDAO<Author> dao;

    public AuthorServiceImpl() {
        dao = new AuthorDAOImpl();
    }

    public void save(Author author) {
        if (ValidatorUtil.validate(author)) {
            dao.save(author);
        }
    }

    public void deleteById(int id) {
        dao.deleteItemById(id, Author.class);
    }

    public Author getById(int id) {
        return dao.getById(id, Author.class);
    }

    public void update(Author author) {
        if (ValidatorUtil.validate(author)) {
            dao.update(author);
        }
    }
}
