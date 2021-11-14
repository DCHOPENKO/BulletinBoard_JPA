package com.bulletin_board.domain;

import com.bulletin_board.enums.CountryCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
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
public class PhoneNumber {

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
