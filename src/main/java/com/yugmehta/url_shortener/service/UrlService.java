package com.yugmehta.url_shortener.service;

import com.yugmehta.url_shortener.model.UrlMapping;
import com.yugmehta.url_shortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    @Autowired
    UrlMappingRepository repo;

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;

    private String generateShortCode(){
        Random random = new Random();                   // Creates a random number generator
        StringBuilder sb = new StringBuilder();         // Like a String but more efficient for building character by character

        for(int i = 0; i<SHORT_CODE_LENGTH; i++){           //loop 6 times
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();                              //Convert StringBuilder to String and return e.g. "aB3xYz"
    }

    private String generateUniqueShortCode(){               //this method is all about whether the short code generated is unique or not by calling the repo method
        String shortCode;

        do{
            shortCode = generateShortCode();
        }
        while(repo.existsByShortCode(shortCode));
            return shortCode;
    }

    public UrlMapping getByShortCode(String shortCode){           //this method is used to get original url from shortened url /shortcode
        UrlMapping urlMapping = repo.findByShortCode(shortCode).orElseThrow(()->new RuntimeException("Short code not found: " + shortCode));
        urlMapping.setClickCount(urlMapping.getClickCount() + 1);
        return repo.save(urlMapping);
    }

    public UrlMapping shortenUrl(String originalUrl){
        String shortCode = generateUniqueShortCode();
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortCode(shortCode);
        return repo.save(urlMapping);
    }

}
