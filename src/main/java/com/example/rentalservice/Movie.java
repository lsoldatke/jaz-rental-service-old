package com.example.rentalservice;

public class Movie {
    private Long id;
    private String name;
    private Category category;
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(Long id, String name, Category category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
