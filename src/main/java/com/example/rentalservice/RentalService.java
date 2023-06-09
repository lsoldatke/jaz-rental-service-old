package com.example.rentalservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        String url = "http://localhost:8080/movieservice/movies/" + id;
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
        return response.getBody();
    }

    public Movie returnMovie(Long id) {
        String url = "http://localhost:8080/movieservice/movies/return/" + id;
        ResponseEntity<Movie> response = restTemplate.getForEntity(url, Movie.class);
        return response.getBody();
    }
}
