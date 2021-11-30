package com.bulletin_board.controller;

import com.bulletin_board.domain.Author;
import com.bulletin_board.dto.AuthorDTO;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.service.impl.AuthorServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/author")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AuthorController {

//    CRUDService<Author, AuthorDTO> service;
    AuthorServiceImpl service;

    @PostMapping()
    public void save(@RequestBody @Valid Author author) {
        service.save(author);
    }

    @PutMapping()
    public void update(@RequestBody @Valid Author author) {
        service.update(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    public AuthorDTO find(@PathVariable(name = "id") int id) {
        return service.getDtoById(id);
    }

}
