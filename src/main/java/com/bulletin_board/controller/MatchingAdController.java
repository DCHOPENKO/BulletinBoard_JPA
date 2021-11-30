package com.bulletin_board.controller;

import com.bulletin_board.domain.MatchingAd;
import com.bulletin_board.dto.MatchingAdDTO;
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

    CRUDService<MatchingAd, MatchingAdDTO> service;

    @PostMapping()
    public void save(@RequestBody @Valid MatchingAd matchingAd) {

        service.save(matchingAd);
    }

    @PutMapping()
    public void update(@RequestBody @Valid MatchingAd matchingAd) {
        service.update(matchingAd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public MatchingAdDTO find(@PathVariable(name = "id") int id) {
        return service.getDtoById(id);
    }

}
