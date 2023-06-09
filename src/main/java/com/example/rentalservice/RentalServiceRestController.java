package com.example.rentalservice;

import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/rentalservice")
public class RentalServiceRestController {
    private final RentalService rentalService;

    public RentalServiceRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/getmovie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        Movie movie = rentalService.getMovie(id);
        if (movie == null) {
            throw new NoSuchElementException("Movie not found");
        }
        return movie;
    }

    @PutMapping("/returnmovie/{id}")
    public Movie returnMovie(@PathVariable Long id) {
        return rentalService.returnMovie(id);
    }
}
