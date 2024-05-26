package com.example.bibliotekafilmow.repository;

import com.example.bibliotekafilmow.model.Filmy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Filmy, Integer> {
    Page<Filmy> findAll(Pageable pageable);
    List<Filmy> findByGenre(String genre);
    List<Filmy> findAllByOrderByRatingAsc();
    List<Filmy> findAllByOrderByRatingDesc();

    List<Filmy> findByTitleContainingIgnoreCase(String title);

    List<Filmy> findByWatched(boolean watched);
}
