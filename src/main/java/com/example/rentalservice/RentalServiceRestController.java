package com.example.rentalservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Return movie by ID", description = "Returns movie with given ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - Movie was not found")
    })
    @PutMapping("/returnmovie/{id}")
    public Movie returnMovie(@PathVariable Long id) {
        return rentalService.returnMovie(id);
    }
}
