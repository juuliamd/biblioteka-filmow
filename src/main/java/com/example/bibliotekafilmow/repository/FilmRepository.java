package com.example.bibliotekafilmow.repository;

import com.example.bibliotekafilmow.model.Filmy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Filmy, Integer> {
    List<Filmy> findByGenre(String genre);
    List<Filmy> findAllByOrderByRatingAsc();
    List<Filmy> findAllByOrderByRatingDesc();

    List<Filmy> findByTitleContainingIngnoreCase(String title);
    List<Filmy> findByWatched(boolean watched);
}
