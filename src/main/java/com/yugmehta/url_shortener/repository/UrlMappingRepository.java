package com.yugmehta.url_shortener.repository;

import com.yugmehta.url_shortener.model.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping,Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);     //When a user visits with the shortened url, you extract the short code and use this method to find the original URL in the database
    boolean existsByShortCode(String shortCode);                //When generating a new short code, you need to make sure it doesn't already exist in the database. It returns true or false based on that
}
