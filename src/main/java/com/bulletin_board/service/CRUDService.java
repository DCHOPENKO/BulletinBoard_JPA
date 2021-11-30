package com.bulletin_board.service;

import com.bulletin_board.domain.EntityClass;
import com.bulletin_board.dto.DtoClass;

public interface CRUDService<T extends EntityClass, DTO extends DtoClass> {

    void save(T t);

    void update(T t);

    void deleteById(int id);

    DTO getDtoById(int id);

}
