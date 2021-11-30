package com.bulletin_board.controller;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.dto.AdvertDTO;
import com.bulletin_board.service.AdvertService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/adverts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertController {

    AdvertService service;

    @PostMapping()
    public void save(@RequestBody @Valid Advert advert) {
        service.save(advert);
    }

    @PutMapping()
    public void update(@RequestBody @Valid Advert advert) {
        service.update(advert);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @DeleteMapping()
    public void delete() {
        service.deleteNotActive();
    }

    @GetMapping("/{id}")
    public AdvertDTO find(@PathVariable(name = "id") int id) {
        return service.getDtoById(id);
    }

    @GetMapping("/by-author/{author_id}")
    public List<AdvertDTO> findAdvertsByAuthorId(@PathVariable(name = "author_id") int author_id) {
        return service.findAdvertsByAuthorId(author_id);
    }

    @GetMapping("/by-categories/{category-ids}")
    public List<AdvertDTO> findAdvertsByCategoriesID(@PathVariable(name = "category-ids") List<Integer> ids) {
        return service.findAdvertsByCategoriesID(ids);
    }

    @GetMapping("/by-date/{date}")
    public List<AdvertDTO> findAdvertsByDate(@PathVariable(name = "date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        return service.findAdvertsByDate(localDate);
    }

    @GetMapping("/by-key-word/{key-word}")
    public List<AdvertDTO> findAdvertsByKeyWord(@PathVariable(name = "key-word") String keyWord) {
        return service.findAdvertsByKeyWord(keyWord);
    }

}
