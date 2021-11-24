package com.bulletin_board.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CountryCode {

    RU ("+7"),
    UA ("+38"),
    BY ("+37");

    private String countryCode;

    CountryCode (String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return countryCode;
    }
}
