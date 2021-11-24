package com.bulletin_board.controller;

import com.bulletin_board.domain.Author;
import com.bulletin_board.domain.Category;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/category")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryController {

    CRUDService<Category> service;

    @PostMapping("/save")
    public void save(@RequestBody @Valid Category category) {
        service.save(category);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid Category category) {
        service.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Category find(@PathVariable(name = "id") int id) {
        return service.getById(id);
    }

}
