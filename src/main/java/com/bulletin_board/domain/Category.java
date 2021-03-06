package com.bulletin_board.domain;

import com.bulletin_board.enums.CategoryType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Category implements EntityClass{

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    int id;

    @Column(name = "category_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    CategoryType categoryType;

}
