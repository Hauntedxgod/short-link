package ru.maxima.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxima.model.Url;
import ru.maxima.repositori.UrlRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {


    private final static String AVIABLE_SYMBOLS =("");

    private final UrlRepository repository;

    @Autowired
    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public Url save(String urlString) {
        Url url = new Url();
        url.setUrl(urlString);
        url.setClickUrl(0);
        url.setShortsUrl(getShortUrl());
        return repository.save(url);
    }

    public String getShortUrl(){
        StringBuilder url = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 7 ; i++) {
            url.append(AVIABLE_SYMBOLS.charAt(random.nextInt(AVIABLE_SYMBOLS.length())));
        }
        return url.toString() ;
    }

    public Url findBy(String shortName){
        return repository.findByShortsUrl(shortName).orElse(null);
    }
}
