package com.yugmehta.url_shortener.controller;

import com.yugmehta.url_shortener.model.UrlMapping;
import com.yugmehta.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {

    @Autowired
    UrlService service;

    //To shorten the original url
    @PostMapping("/api/shorten")
    public ResponseEntity<UrlMapping> shortenUrl(@RequestBody ShortenRequest request){
        UrlMapping urlMapping = service.shortenUrl(request.getOriginalUrl());
        return new ResponseEntity<>(urlMapping, HttpStatus.OK);
    }

    //to get the original url and redirect the browser to the original url
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode){                 //302 = HTTP redirect status code. Browser reads this header and automatically navigates there

        UrlMapping urlMapping = service.getByShortCode(shortCode);
        return ResponseEntity.status(302)
                .location(URI.create(urlMapping.getOriginalUrl()))
                .build();
    }

    //to get the click counts
    @GetMapping("/api/stats/{shortcode}")
    public ResponseEntity<UrlMapping> getStats(@PathVariable String shortcode){
        UrlMapping urlMapping = service.getByShortCode(shortcode);
        return ResponseEntity.ok(urlMapping);
    }

}
