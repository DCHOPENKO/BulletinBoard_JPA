package com.bulletin_board.service.impl;

import com.bulletin_board.domain.Advert;
import com.bulletin_board.dto.AdvertDTO;
import com.bulletin_board.repository.AdvertRepository;
import com.bulletin_board.service.AdvertService;
import com.bulletin_board.service.EmailService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    EmailService eService;
    AdvertRepository repo;

    public void save(Advert advert) {
        repo.save(advert);
        eService.sendEmails(advert);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public AdvertDTO getDtoById(int id) {
        return new AdvertDTO(repo.findById(id).get());
    }

    public void update(Advert advert) {
        repo.save(advert);
    }

    public void deleteAdvertsByAuthorId(int id) {
        repo.deleteAllByAuthor_Id(id);
    }

    public void deleteAdvertsByCategoryId(int id) {
        repo.deleteAllByCategory_Id(id);
    }

    public List<AdvertDTO> findAdvertsByAuthorId(int id) {
        List<Advert> adverts = repo.findAllByAuthor_Id(id);
        return mapEntityToDto(adverts);
    }


    public List<AdvertDTO> findAdvertsByCategoriesID(List<Integer> categoryIds) {
        List<Advert> adverts = repo.findAllByCategoriesId(categoryIds);
        return mapEntityToDto(adverts);
    }

    public List<AdvertDTO> findAdvertsByDate(LocalDate date) {
        List<Advert> adverts = repo.findAllByPublicationDate(date);
        return mapEntityToDto(adverts);
    }

    public List<AdvertDTO> findAdvertsByKeyWord(String keyWord) {
        List<Advert> adverts = repo.findAllByTitleContaining(keyWord);
        return mapEntityToDto(adverts);
    }

    private List<AdvertDTO> mapEntityToDto(List<Advert> adverts) {
        return adverts.stream()
                .map(AdvertDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteNotActive () {
        repo.deleteAllByIsActiveIsFalse();
    }

    @Scheduled (cron = "0/20 * * * * *")
    public void deleteIfNotActive () {
        repo.deleteAllByIsActiveIsFalse();
    }

}
