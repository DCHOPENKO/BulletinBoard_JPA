package com.bulletin_board.domain;

import com.bulletin_board.enums.CountryCode;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Phone {

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "phone_id")
    int id;

    @Column(name = "country_code")
    @Enumerated(EnumType.STRING)
    @NotNull
    CountryCode countryCode;

    @Column(name = "phone_number")
    @Pattern(regexp = "[\\d]{10}")
    @NotBlank
    String phoneNumber;

    @Override
    public String toString() {
        return countryCode + phoneNumber;
    }
}
