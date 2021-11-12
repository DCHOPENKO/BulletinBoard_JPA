package com.bulletin_board;

import com.bulletin_board.enums.City;
import com.bulletin_board.enums.Country;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    int id;


    @Enumerated(EnumType.STRING)
    @NotNull
    Country country;

    @Enumerated(EnumType.STRING)
    @NotNull
    City city;

    @NotBlank
    @Length(min = 5, max = 30)
    String street;

    @Positive
    @Column(name = "street_number")
    int streetNumber;

    @Column(name = "building_number")
    int buildingNumber;

    @Positive
    int apartment;

    @Override
    public String toString() {
        String korpus = (buildingNumber == 0) ? "" : "/" + buildingNumber;
        return country + ", " + city + ", " + street + " " + streetNumber + korpus + ", aparts " + apartment;
    }
}
