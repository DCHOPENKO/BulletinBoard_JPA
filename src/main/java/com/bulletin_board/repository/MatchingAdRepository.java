package com.bulletin_board.repository;

import com.bulletin_board.domain.MatchingAd;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MatchingAdRepository extends CustomRepository<MatchingAd> {

    void deleteByAuthor_Id(int id);

    void deleteByCategory_Id(int id);

    void deleteAllByIsActiveIsFalse();

}
