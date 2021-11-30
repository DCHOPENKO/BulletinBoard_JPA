package com.bulletin_board.service.impl;

import com.bulletin_board.domain.MatchingAd;
import com.bulletin_board.dto.MatchingAdDTO;
import com.bulletin_board.repository.MatchingAdRepository;
import com.bulletin_board.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class MatchingAdServiceImpl implements CRUDService<MatchingAd, MatchingAdDTO> {

    MatchingAdRepository repo;

    public void save(MatchingAd matchingAd) {
        repo.save(matchingAd);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public MatchingAdDTO getDtoById(int id) {
        return new MatchingAdDTO(repo.findById(id).get());
    }

    public void update(MatchingAd matchingAd) {
        repo.save(matchingAd);
    }

    @Scheduled(cron = "0/10 * * * * *")
    public void deleteIfNotActive () {
        repo.deleteAllByIsActiveIsFalse();
    }
}

