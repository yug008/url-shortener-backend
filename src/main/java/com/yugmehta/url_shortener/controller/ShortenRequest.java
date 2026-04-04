package com.yugmehta.url_shortener.controller;

import lombok.Data;

@Data
public class ShortenRequest {

    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
