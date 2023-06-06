package com.example.rentalservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentalservice")
public class RentalServiceRestController {
    private final RentalService rentalService;

    public RentalServiceRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/getmovie/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return rentalService.getMovie(id);
    }

    @PutMapping("/returnmovie/{id}")
    public Movie returnMovie(@PathVariable Long id) {
        return rentalService.returnMovie(id);
    }
}
