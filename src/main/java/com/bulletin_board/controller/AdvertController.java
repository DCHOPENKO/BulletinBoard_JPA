package com.bulletin_board.controller;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.domain.Author;
import com.bulletin_board.service.AdvertService;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/advert")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertController {

    AdvertService service;

    @PostMapping("/save")
    public void save(@RequestBody @Valid Advert advert) {
        service.save(advert);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid Advert advert) {
        service.update(advert);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Advert find(@PathVariable(name = "id") int id) {
        return service.getById(id);
    }

}
