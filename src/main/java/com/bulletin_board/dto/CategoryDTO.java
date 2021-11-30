package com.bulletin_board.dto;

import com.bulletin_board.domain.Category;
import com.bulletin_board.enums.CategoryType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryDTO implements DtoClass{

    int id;

    CategoryType categoryType;

    public CategoryDTO(Category category) {
        id = category.getId();
        categoryType = category.getCategoryType();
    }
}
