package com.bulletin_board.domain;

import com.bulletin_board.enums.City;
import com.bulletin_board.enums.Country;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
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
@Getter
@Setter
public class Address implements EntityClass{

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
