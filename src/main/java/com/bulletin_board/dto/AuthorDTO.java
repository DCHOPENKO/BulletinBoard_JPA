package com.bulletin_board.dto;

import com.bulletin_board.domain.Author;
import com.bulletin_board.domain.Phone;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDTO implements DtoClass {

    int id;

    String firstName;

    String lastName;

    String address;

    String email;

    List<String> phones;

/*    int address;

    int email;

    List<Integer> phones;*/

    public AuthorDTO(Author author) {
        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();
        address = author.getAddress().toString();
        email = author.getEmail().getName();
        phones = author.getPhones()
                .stream()
                .map(Phone::toString)
                .collect(Collectors.toList());
    }

/*    public AuthorDTO(Author author) {
        id = author.getId();
        firstName = author.getFirstName();
        lastName = author.getLastName();
        address = author.getAddress().getId();
        email = author.getEmail().getId();
        phones = author.getPhones()
                .stream()
                .map(Phone::getId)
                .collect(Collectors.toList());
    }*/


}
