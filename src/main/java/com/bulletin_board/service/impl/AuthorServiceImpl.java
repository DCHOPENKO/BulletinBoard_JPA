package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Author;
import com.bulletin_board.dto.AuthorDTO;
import com.bulletin_board.repository.AdvertRepository;
import com.bulletin_board.repository.CustomRepository;
import com.bulletin_board.repository.MatchingAdRepository;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorServiceImpl implements CRUDService<Author, AuthorDTO>{

    CustomRepository<Author> authorRepo;
    AdvertRepository advertRepo;
    MatchingAdRepository matchingRepo;

    public void save(Author author) {
        authorRepo.save(author);
    }

    public void deleteById(int id) {
        advertRepo.deleteAllByAuthor_Id(id);
        matchingRepo.deleteByAuthor_Id(id);
        authorRepo.deleteById(id);
    }

    public AuthorDTO getDtoById(int id) {
        return new AuthorDTO(authorRepo.findById(id).get());
    }

    public void update(Author author) {
        authorRepo.save(author);
    }

}
