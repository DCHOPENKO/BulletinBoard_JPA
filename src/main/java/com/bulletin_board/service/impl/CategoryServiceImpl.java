package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Category;
import com.bulletin_board.dto.CategoryDTO;
import com.bulletin_board.exception.EntityNotFoundException;
import com.bulletin_board.repository.AdvertRepository;
import com.bulletin_board.repository.CustomRepository;
import com.bulletin_board.repository.MatchingAdRepository;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class CategoryServiceImpl implements CRUDService<Category, CategoryDTO> {

    CustomRepository<Category> categoryRepo;
    AdvertRepository advertRepo;
    MatchingAdRepository matchingRepo;

    public void save(Category category) {
        categoryRepo.save(category);
    }

    public CategoryDTO getDtoById(int id) {
        return new CategoryDTO(categoryRepo.findById(id).get());
    }

    public void update(Category category) {
        categoryRepo.save(category);
    }

    public void deleteById(int id) {
        advertRepo.deleteAllByCategory_Id(id);
        matchingRepo.deleteByCategory_Id(id);
        categoryRepo.deleteById(id);
    }
}
