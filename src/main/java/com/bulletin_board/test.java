package com.bulletin_board;

import com.bulletin_board.enums.*;
import com.bulletin_board.service.CRUDService;
import com.bulletin_board.service.impl.AdvertServiceImpl;
import com.bulletin_board.service.impl.AuthorServiceImpl;
import com.bulletin_board.service.impl.CategoryServiceImpl;
import com.bulletin_board.service.impl.MatchingAdServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

public class test {
    private static final CRUDService<Category> CATEGORY_SERVICE = new CategoryServiceImpl();
    private static final CRUDService<Author> AUTHOR_SERVICE = new AuthorServiceImpl();
    private static final CRUDService<MatchingAd> MATCHING_AD_SERVICE = new MatchingAdServiceImpl();
    private static final AdvertServiceImpl ADVERT_SERVICE = new AdvertServiceImpl();

    public static void main(String[] args) {


//          generateAuthors();
//          generateCategories();
//          generateMatchingAd();
//          generateAdverts();
//
//       AUTHOR_SERVICE.deleteById(10);
//
//       CATEGORY_SERVICE.deleteById(14);
//        MATCHING_AD_SERVICE.deleteById(17);
//        ADVERT_SERVICE.deleteById(28);

    }

    public static void generateCategories() {

        Category computers = Category.builder()
                .categoryType(CategoryType.COMPUTERS)
                .build();

        Category phones = Category.builder()
                .categoryType(CategoryType.PHONES)
                .build();

        CATEGORY_SERVICE.save(computers);
        CATEGORY_SERVICE.save(phones);


    }

    public static void generateMatchingAd() {
        MatchingAd match01 = MatchingAd.builder()
                .author(AUTHOR_SERVICE.getById(1))
                .category(CATEGORY_SERVICE.getById(14))
                .keyWords("new")
                .priceFrom(BigDecimal.valueOf(5000))
                .priceTo(BigDecimal.valueOf(6000))
                .build();

        MatchingAd match02 = MatchingAd.builder()
                .author(AUTHOR_SERVICE.getById(6))
                .category(CATEGORY_SERVICE.getById(15))
                .keyWords("as")
                .priceFrom(BigDecimal.valueOf(500))
                .priceTo(BigDecimal.valueOf(2000))
                .build();

        MatchingAd match03 = MatchingAd.builder()
                .author(AUTHOR_SERVICE.getById(10))
                .category(CATEGORY_SERVICE.getById(15))
                .keyWords("new")
                .priceFrom(BigDecimal.valueOf(1000))
                .priceTo(BigDecimal.valueOf(6000))
                .build();

        MatchingAd match04 = MatchingAd.builder()
                .author(AUTHOR_SERVICE.getById(10))
                .category(CATEGORY_SERVICE.getById(15))
                .keyWords("as")
                .priceFrom(BigDecimal.valueOf(500))
                .priceTo(BigDecimal.valueOf(2000))
                .build();

        MATCHING_AD_SERVICE.save(match01);
        MATCHING_AD_SERVICE.save(match02);
        MATCHING_AD_SERVICE.save(match03);
        MATCHING_AD_SERVICE.save(match04);
    }

    public static void generateAdverts() {
        Advert hpEliteBook = Advert.builder()
                .name("HP EliteBook")
                .title("good condition")
                .price(BigDecimal.valueOf(3000))
                .publicationDate(LocalDate.now())
                .build();

        Advert lenovoG60 = Advert.builder()
                .name("Lenovo G60")
                .title("good condition, best price")
                .price(BigDecimal.valueOf(1599))
                .publicationDate(LocalDate.now())
                .build();

        Advert asusBP9 = Advert.builder()
                .name("Asus BP9")
                .title("as new")
                .price(BigDecimal.valueOf(5400))
                .publicationDate(LocalDate.now())
                .build();

        Advert hpPavilion = Advert.builder()
                .name("HP Pavilion")
                .title("new")
                .price(BigDecimal.valueOf(3500))
                .publicationDate(LocalDate.of(2020, 12, 1))
                .build();

        Advert iphoneXS = Advert.builder()
                .name("Iphone XS")
                .title("as new")
                .price(BigDecimal.valueOf(800))
                .publicationDate(LocalDate.of(2020, 12, 1))
                .build();

        hpEliteBook.setCategory(CATEGORY_SERVICE.getById(14));
        hpEliteBook.setAuthor(AUTHOR_SERVICE.getById(1));

        lenovoG60.setCategory(CATEGORY_SERVICE.getById(14));
        lenovoG60.setAuthor(AUTHOR_SERVICE.getById(6));

        asusBP9.setCategory(CATEGORY_SERVICE.getById(14));
        asusBP9.setAuthor(AUTHOR_SERVICE.getById(10));

        hpPavilion.setCategory(CATEGORY_SERVICE.getById(14));
        hpPavilion.setAuthor(AUTHOR_SERVICE.getById(10));

        iphoneXS.setCategory(CATEGORY_SERVICE.getById(15));
        iphoneXS.setAuthor(AUTHOR_SERVICE.getById(1));

        ADVERT_SERVICE.save(hpEliteBook);
        ADVERT_SERVICE.save(lenovoG60);
        ADVERT_SERVICE.save(asusBP9);
        ADVERT_SERVICE.save (hpPavilion);
        ADVERT_SERVICE.save(iphoneXS);


    }

    public static void generateAuthors() {

        PhoneNumber author1phoneRU = PhoneNumber.builder()
                .countryCode(CountryCode.RU)
                .phoneNumber("9253771089")
                .build();

        PhoneNumber author1phoneUA = PhoneNumber.builder()
                .countryCode(CountryCode.UA)
                .phoneNumber("0632920452")
                .build();

        PhoneNumber author2phoneUA = PhoneNumber.builder()
                .countryCode(CountryCode.RU)
                .phoneNumber("9250081472")
                .build();

        PhoneNumber author3phoneBY = PhoneNumber.builder()
                .countryCode(CountryCode.BY)
                .phoneNumber("9999999999")
                .build();

        EmailAddress author1email = EmailAddress.builder()
                .name("filontrop@yandex.ru")
                .build();

        EmailAddress author2email = EmailAddress.builder()
                .name("pupsik123@gmail.com")
                .build();

        EmailAddress author3email = EmailAddress.builder()
                .name("test01@yahoo.com")
                .build();

        Address author1address = Address.builder()
                .country(Country.RUSSIA)
                .city(City.MOSCOW)
                .street("Andropova")
                .streetNumber(46)
                .apartment(92)
                .build();

        Address author2address = Address.builder()
                .country(Country.UKRAINE)
                .city(City.KIEV)
                .street("Obolonska")
                .streetNumber(193)
                .apartment(34)
                .build();

        Address author3address = Address.builder()
                .country(Country.BELARUS)
                .city(City.MINSK)
                .street("Svobodu")
                .streetNumber(125)
                .buildingNumber(2)
                .apartment(92)
                .build();

        Author author01 = Author.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .address(author1address)
                .email(author1email)
                .phoneNumbers(Arrays.asList(author1phoneRU, author1phoneUA))
                .build();

        Author author02 = Author.builder()
                .firstName("Petro")
                .lastName("Simonenko")
                .address(author2address)
                .email(author2email)
                .phoneNumbers(Arrays.asList(author2phoneUA))
                .build();

        Author author03 = Author.builder()
                .firstName("Vitaly")
                .lastName("Karaga")
                .address(author3address)
                .email(author3email)
                .phoneNumbers(Arrays.asList(author3phoneBY))
                .build();

        AUTHOR_SERVICE.save(author01);
        AUTHOR_SERVICE.save(author02);
        AUTHOR_SERVICE.save(author03);

    }
}
