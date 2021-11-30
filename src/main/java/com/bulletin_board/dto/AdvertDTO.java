package com.bulletin_board.dto;

import com.bulletin_board.domain.Advert;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdvertDTO implements DtoClass{

    int id;

    boolean isActive;

    String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate publicationDate;

    String title;

    BigDecimal price;

    int authorId;

    int categoryId;

    public AdvertDTO(Advert advert) {
        id = advert.getId();
        isActive = advert.getIsActive();
        name = advert.getName();
        publicationDate = advert.getPublicationDate();
        title = advert.getTitle();
        price = advert.getPrice();
        authorId = advert.getAuthor().getId();
        categoryId = advert.getCategory().getId();
    }


}
