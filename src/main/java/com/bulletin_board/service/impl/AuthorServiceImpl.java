package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Author;
import com.bulletin_board.dao.CrudDAO;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorServiceImpl implements CRUDService<Author> {

    @Qualifier("authorDAOImpl")
    CrudDAO<Author> dao;

    public void save(Author author) {
        dao.save(author);
    }

    public void deleteById(int id) {
        dao.deleteItemById(id, Author.class);
    }

    public Author getById(int id) {
        return dao.getById(id, Author.class);
    }

    public void update(Author author) {
            dao.update(author);
    }
}
