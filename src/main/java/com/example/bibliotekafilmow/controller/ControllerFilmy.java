package com.example.bibliotekafilmow.controller;

import com.example.bibliotekafilmow.model.Filmy;
import com.example.bibliotekafilmow.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class ControllerFilmy {
    //@Autowired

    private final FilmRepository filmRepository;
    public ControllerFilmy(FilmRepository filmRepository){
        this.filmRepository=filmRepository;
    }

    @GetMapping
    public Page<Filmy> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        PageRequest pr=PageRequest.of(page, size);
        return filmRepository.findAll(pr);
    }

    @PostMapping

    //@GetMapping
    public Filmy addFilm(@RequestBody Filmy filmy){
        return filmRepository.save(filmy);
    }

    //edycja filmu
    @PutMapping("/{id}")
    public Filmy updateFilm(@PathVariable Integer id, @RequestBody Filmy updatedFilm){
        Optional<Filmy> optionalFilm = filmRepository.findById(id);
        if(optionalFilm.isPresent()) {
            Filmy film = optionalFilm.get();
            film.setTitle(updatedFilm.getTitle());
            film.setReleaseYear(updatedFilm.getReleaseYear());
            film.setGenre(updatedFilm.getGenre());
            film.setWatched(updatedFilm.isWatched());
            film.setRating(updatedFilm.getRating());
            film.setReview(updatedFilm.getReview());
            return filmRepository.save(film);
        }
        else{
            throw new RuntimeException("No film with such ID: "+id);
        }

    }
    //usuwanie
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Integer id){
        filmRepository.deleteById(id);
    }

    //wyszukiwanie po tytule

    @GetMapping("/search")
    public List<Filmy> searchFilmsByTitle(@RequestParam String title){
       return filmRepository.findByTitleContainingIgnoreCase(title);
    }

    //po gatunkach
    @GetMapping("/filter")
    public List<Filmy> filterFilmsByGenre(@RequestParam String genre) {
        return filmRepository.findByGenre(genre);
    }

    //sortowanie po ocenie
    @GetMapping("/sort")
    public List<Filmy> sortFilmsByRating(@RequestParam String direction){
        if(direction.equalsIgnoreCase("asc")){
            return filmRepository.findAllByOrderByRatingAsc();
        }
        else{
            return filmRepository.findAllByOrderByRatingDesc();
        }
    }
    //obejrzane/nieobejrzane
    @GetMapping("/watched")
    public List<Filmy> filterByWatched(@RequestParam boolean watched){
        return filmRepository.findByWatched(watched);
    }

}
