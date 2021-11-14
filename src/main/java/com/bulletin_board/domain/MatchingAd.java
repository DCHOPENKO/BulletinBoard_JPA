package com.bulletin_board.domain;

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
@Setter
public class MatchingAd {

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_MatchingAd_Author")
    @NotNull
    @Valid
    Author author;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_MatchingAd_Category")
    @NotNull
    @Valid
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
}
