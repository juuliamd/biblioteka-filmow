package com.example.bibliotekafilmow.data;

import com.example.bibliotekafilmow.model.Filmy;
import com.example.bibliotekafilmow.model.ListyOgladania;
import com.example.bibliotekafilmow.repository.FilmRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import  org.slf4j.Logger;

@Component
public class SampleDataLoader implements CommandLineRunner{

    private Logger logger= LoggerFactory.getLogger(SampleDataLoader.class);
    //@Autowired
    private final FilmRepository filmRepository;
    public SampleDataLoader(FilmRepository filmRepository){
        this.filmRepository=filmRepository;
    }

    //@Override
    public void run(String...args) throws Exception {

        logger.info("Loading sample data...");

        Filmy film1 = new Filmy();
        film1.setTitle("The Shawshank Redemption");
        film1.setReleaseYear(1994);
        film1.setGenre("Drama");
        film1.setWatched(true);
        film1.setRating(9);
        film1.setReview("A masterpiece of storytelling");

        ListyOgladania listaOgladania1 = new ListyOgladania();
        listaOgladania1.setTitle("Moja lista 1");
        listaOgladania1.setDescribtion("Lista filmów, które chcę obejrzeć");

        film1.setListyOgladania(listaOgladania1);

        Filmy film2 = new Filmy();
        film2.setTitle("The Godfather");
        film2.setReleaseYear(1972);
        film2.setGenre("Crime");
        film2.setWatched(false);
        film2.setRating(9);
        film2.setReview("An iconic film with brilliant performances");

        ListyOgladania listaOgladania2 = new ListyOgladania();
        listaOgladania2.setTitle("Moja lista 2");
        listaOgladania2.setDescribtion("Lista filmów do obejrzenia później");

        film2.setListyOgladania(listaOgladania2);

        Filmy film3 = new Filmy();
        film3.setTitle("The Dark Knight");
        film3.setReleaseYear(2008);
        film3.setGenre("Action");
        film3.setWatched(true);
        film3.setRating(8);
        film3.setReview("A thrilling and dark superhero movie");

        ListyOgladania listaOgladania3 = new ListyOgladania();
        listaOgladania3.setTitle("Moja lista 3");
        listaOgladania3.setDescribtion("Lista filmów do obejrzenia ponownie");

        film3.setListyOgladania(listaOgladania3);


        filmRepository.save(film1);
        filmRepository.save(film2);
        filmRepository.save(film3);


        logger.info("Sample data loaded successfully!");
    }


}
