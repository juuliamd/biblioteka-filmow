package com.example.bibliotekafilmow.controller;

import com.example.bibliotekafilmow.model.Filmy;
import com.example.bibliotekafilmow.model.ListyOgladania;
import com.example.bibliotekafilmow.repository.FilmRepository;
import com.example.bibliotekafilmow.repository.ListyOgladaniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class ControllerFilmy {
    //@Autowired

    private final FilmRepository filmRepository;
    private final ListyOgladaniaRepository listyOgladaniaRepository;
    public ControllerFilmy(FilmRepository filmRepository, ListyOgladaniaRepository listyOgladaniaRepository){
        this.filmRepository=filmRepository;
        this.listyOgladaniaRepository=listyOgladaniaRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Filmy>> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        PageRequest pr=PageRequest.of(page, size);
        Page<Filmy> filmsPage = filmRepository.findAll(pr);
        return ResponseEntity.ok(filmsPage);
    }

    @PostMapping
    public ResponseEntity<Filmy> addFilm(@RequestBody Filmy filmy){
        Filmy savedFilm=filmRepository.save(filmy);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilm);
    }

    //edycja filmu
    @PutMapping("/{id}")
    public ResponseEntity<Filmy> updateFilm(@PathVariable Integer id, @RequestBody Filmy updatedFilm){
        Optional<Filmy> optionalFilm = filmRepository.findById(id);
        if(optionalFilm.isPresent()) {
            Filmy film = optionalFilm.get();
                film.setTitle(updatedFilm.getTitle());
                film.setReleaseYear(updatedFilm.getReleaseYear());
                film.setGenre(updatedFilm.getGenre());
                film.setWatched(updatedFilm.isWatched());
                film.setRating(updatedFilm.getRating());
                film.setReview(updatedFilm.getReview());
                Filmy savedFilm= filmRepository.save(film);
            return ResponseEntity.ok(savedFilm);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no film with such id: "+id);
        }

    }
    //usuwanie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Integer id){
        filmRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //wyszukiwanie po tytule

    @GetMapping("/search")
    public ResponseEntity<List<Filmy>> searchFilmsByTitle(@RequestParam String title){
        List<Filmy> foundFilms = filmRepository.findByTitleContainingIgnoreCase(title);
        return ResponseEntity.ok(foundFilms);
    }

    //po gatunkach
    @GetMapping("/filter")
    public ResponseEntity<List<Filmy>> filterFilmsByGenre(@RequestParam String genre) {
        List<Filmy> filteredFilms = filmRepository.findByGenre(genre);
        return ResponseEntity.ok(filteredFilms);
    }

    //sortowanie po ocenie
    @GetMapping("/sort")
    public ResponseEntity<List<Filmy>> sortFilmsByRating(@RequestParam String direction) {
        List<Filmy> sortedFilms;
        if (direction.equalsIgnoreCase("asc")) {
            sortedFilms = filmRepository.findAllByOrderByRatingAsc();
        } else {
            sortedFilms = filmRepository.findAllByOrderByRatingDesc();
        }
        return ResponseEntity.ok(sortedFilms);
    }
    //obejrzane/nieobejrzane
    @GetMapping("/watched")
    public ResponseEntity<List<Filmy>> filterByWatched(@RequestParam boolean watched) {
        List<Filmy> filteredFilms = filmRepository.findByWatched(watched);
        return ResponseEntity.ok(filteredFilms);
    }
    @PostMapping("/{filmId}/listy-ogladania")
    public ResponseEntity<ListyOgladania> addToListaOgladania(@PathVariable Integer filmId, @RequestBody ListyOgladania listaOgladania) {
        Optional<Filmy> optionalFilm = filmRepository.findById(filmId);
        if (optionalFilm.isPresent()) {
            Filmy film = optionalFilm.get();
            listaOgladania.setFilmy(film);
            ListyOgladania savedLista = listyOgladaniaRepository.save(listaOgladania);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLista);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No film with such id: " + filmId);
        }
    }

    @PutMapping("/{filmId}/listy-ogladania/{listaId}")
    public ResponseEntity<ListyOgladania> updateListaOgladania(@PathVariable Integer filmId, @PathVariable Integer listaId, @RequestBody ListyOgladania updatedListaOgladania) {
        Optional<ListyOgladania> optionalLista = listyOgladaniaRepository.findById(listaId);
        if (optionalLista.isPresent()) {
            ListyOgladania listaOgladania = optionalLista.get();
            listaOgladania.setTitle(updatedListaOgladania.getTitle());
            listaOgladania.setDescribtion(updatedListaOgladania.getDescribtion());
            ListyOgladania savedLista = listyOgladaniaRepository.save(listaOgladania);
            return ResponseEntity.ok(savedLista);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No list with such id: " + listaId);
        }
    }

    @DeleteMapping("/{filmId}/listy-ogladania/{listaId}")
    public ResponseEntity<Void> removeFromListaOgladania(@PathVariable Integer filmId, @PathVariable Integer listaId) {
        listyOgladaniaRepository.deleteById(listaId);
        return ResponseEntity.noContent().build();
    }

}
