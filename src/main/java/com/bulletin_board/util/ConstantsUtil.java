package com.bulletin_board.util;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class ConstantsUtil {
    public static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
    public static EntityManagerFactory ENTITY_FACTORY =
            Persistence.createEntityManagerFactory("bulletinBoardDB");
    public static String FROM = "FROM ";
    public static String WHERE_BY_ID = " cl WHERE cl.id = :id";
    public static String QUERY_BATCH_DELETE_FROM_ADVERT_BY_AUTHOR_ID =
            "DELETE FROM Advert WHERE FK_Advert_Author = :author_id";
    public static String QUERY_BATCH_DELETE_FROM_ADVERT_BY_CATEGORY_ID =
            "DELETE FROM Advert a WHERE FK_Advert_Category = :category_id";
    public static String QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_AUTHOR_ID =
            "DELETE FROM MatchingAd m WHERE FK_MatchingAd_Author = :author_id";
    public static String QUERY_BATCH_DELETE_FROM_MATCHING_AD_BY_CATEGORY_ID =
            "DELETE FROM MatchingAd m WHERE FK_MatchingAd_Category = :category_id";
    public static String QUERY_FIND_BY_AUTHOR_ID = "FROM Advert a WHERE FK_Advert_Author = :author_id";
    public static String QUERY_FIND_BY_CATEGORY_IDS = "FROM Advert a WHERE FK_Advert_Category IN (:a_categoryIds)";
    public static String QUERY_FIND_BY_DATE = "FROM Advert a WHERE a.publicationDate = :a_date";
    public static String QUERY_FIND_BY_KEYWORD = "FROM Advert a WHERE a.title LIKE CONCAT('%', :a_word ,'%')";
    public static String QUERY_CHECK_MATCHING_AD_BY_ADVERT = " SELECT e.name FROM Author a " +
                                                             "JOIN a.matchingAds m " +
                                                             "JOIN a.email e " +
                                                             "WHERE m.category = :a_category AND " +
                                                             ":a_title LIKE CONCAT('%', m.keyWords ,'%') AND " +
                                                             ":a_price BETWEEN m.priceFrom AND m.priceTo";
    public static String PARAMETER_ID = "id";
    public static String PARAMETER_AUTHOR_ID = "author_id";
    public static String PARAMETER_CATEGORY_ID = "category_id";
    public static String PARAMETER_CATEGORY_IDS = "a_categoryIds";
    public static String PARAMETER_ADVERT_DATE = "a_date";
    public static String PARAMETER_KEYWORD = "a_word";
    public static String PARAMETER_ADVERT_TITLE = "a_title";
    public static String PARAMETER_ADVERT_PRICE = "a_price";
    public static String PARAMETER_CATEGORY = "a_category";
}
