package com.bulletin_board.controller;

import com.bulletin_board.domain.Category;
import com.bulletin_board.dto.CategoryDTO;
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

    CRUDService<Category, CategoryDTO> service;

    @PostMapping()
    public void save(@RequestBody @Valid Category category) {
        service.save(category);
    }

    @PutMapping()
    public void update(@RequestBody @Valid Category category) {
        service.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping(value = "/{id}")
    public CategoryDTO find(@PathVariable(name = "id") int id) {
        return service.getDtoById(id);
    }

}
