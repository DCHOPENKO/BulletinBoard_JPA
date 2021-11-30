package com.bulletin_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T> extends JpaRepository<T, Integer> {

    boolean existsById (int id);



}
