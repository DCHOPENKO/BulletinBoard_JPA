package com.bulletin_board.controller;

import com.bulletin_board.domain.Author;
import com.bulletin_board.service.CRUDService;
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

    CRUDService<Author> service;

    @PostMapping("/save")
    public void save(@RequestBody @Valid Author author) {
        service.save(author);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid Author author) {
        service.update(author);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Author find(@PathVariable(name = "id") int id) {
        return service.getById(id);
    }

}
