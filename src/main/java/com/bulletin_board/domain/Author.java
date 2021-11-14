package com.bulletin_board.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Author {

    @Version
    int version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    int id;

    @Column(name = "first_name")
    @NotBlank
    @Length(min = 3, max = 16)
    String firstName;

    @Column(name = "last_name")
    @NotBlank
    @Length(min = 3, max = 16)
    String lastName;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "FK_Author_Address")
    @NotNull
    @Valid
    Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "FK_Author_Email")
    @NotNull
    @Valid
    EmailAddress email;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JoinColumn(name = "FK_Author_Phone_number")
    @NotNull
    List<@NotNull @Valid PhoneNumber> phoneNumbers;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY,
            mappedBy = "author", orphanRemoval = true)
    List<@NotNull @Valid MatchingAd> matchingAds;

}
