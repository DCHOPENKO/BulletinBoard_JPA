package com.bulletin_board.dto;

import com.bulletin_board.domain.MatchingAd;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchingAdDTO implements DtoClass {

    int id;

    boolean isActive;

    int authorId;

    int categoryId;

    String keyWords;

    BigDecimal priceFrom;

    BigDecimal priceTo;

    public MatchingAdDTO(MatchingAd matchingAd) {
        id = matchingAd.getId();
        isActive = matchingAd.getIsActive();
        keyWords = matchingAd.getKeyWords();
        priceFrom = matchingAd.getPriceFrom();
        priceTo = matchingAd.getPriceTo();
        authorId = matchingAd.getAuthor().getId();
        categoryId = matchingAd.getCategory().getId();
    }

}
