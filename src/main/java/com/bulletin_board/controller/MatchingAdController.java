package com.bulletin_board.controller;

import com.bulletin_board.domain.Author;
import com.bulletin_board.domain.MatchingAd;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/matching_ad")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MatchingAdController {

    CRUDService<MatchingAd> service;

    @PostMapping("/save")
    public void save(@RequestBody @Valid MatchingAd matchingAd) {

        service.save(matchingAd);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid MatchingAd matchingAd) {
        service.update(matchingAd);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/find/{id}")
    @ResponseBody
    public MatchingAd find(@PathVariable(name = "id") int id) {
        MatchingAd matchingAd = service.getById(id);
        return matchingAd;
    }

}
