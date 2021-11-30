package com.bulletin_board.repository;

import com.bulletin_board.domain.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface EmailAddressRepository extends JpaRepository<EmailAddress, Integer> {

    @Query("SELECT e.name FROM MatchingAd m " +
            "JOIN m.author a " +
            "JOIN a.email e " +
            "WHERE m.category.id = :categoryID AND " +
            ":title LIKE CONCAT('%', m.keyWords ,'%') AND " +
            ":price BETWEEN m.priceFrom AND m.priceTo")
    List<String> getEmailsByMatchingAdRequests(@Param("categoryID") int id,
                                               @Param("title") String title,
                                               @Param("price") BigDecimal price);

}
