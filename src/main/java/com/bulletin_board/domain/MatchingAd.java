package com.bulletin_board.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class MatchingAd implements EntityClass{

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NonNull
    boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "FK_MatchingAd_Author")
    @NotNull
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_MatchingAd_Category")
    @NotNull
    Category category;

    @Column(name = "key_words")
    @NotBlank
    String keyWords;

    @Column(name = "price_from")
    @NotNull
    @Positive
    BigDecimal priceFrom;

    @Column(name = "price_to")
    @NotNull
    @Positive
    BigDecimal priceTo;

    public boolean getIsActive() {
        return isActive;
    }
}
