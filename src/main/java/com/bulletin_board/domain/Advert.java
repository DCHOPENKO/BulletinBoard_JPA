package com.bulletin_board.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Advert {

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "advert_id")
    int id;

    @NotBlank
    String name;

    @Column(name = "publication_date")
    @NotNull
    @PastOrPresent
    LocalDate publicationDate;

    @NotBlank
    String title;

    @NotNull
    @Positive
    BigDecimal price;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Advert_Author")
    @NotNull
    @Valid
    Author author;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Advert_Category")
    @NotNull
    @Valid
    Category category;

}
