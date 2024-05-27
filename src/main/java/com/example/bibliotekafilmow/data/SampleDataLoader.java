package com.example.bibliotekafilmow.data;

import com.example.bibliotekafilmow.model.Filmy;
import com.example.bibliotekafilmow.model.ListyOgladania;
import com.example.bibliotekafilmow.repository.FilmRepository;
import com.example.bibliotekafilmow.repository.ListyOgladaniaRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import  org.slf4j.Logger;

@Component
public class SampleDataLoader implements CommandLineRunner{

    private Logger logger= LoggerFactory.getLogger(SampleDataLoader.class);
    //@Autowired
    private final FilmRepository filmRepository;
    private final ListyOgladaniaRepository listyOgladaniaRepository;
    public SampleDataLoader(FilmRepository filmRepository,ListyOgladaniaRepository listyOgladaniaRepository){
        this.filmRepository=filmRepository;
        this.listyOgladaniaRepository=listyOgladaniaRepository;

    }

    //@Override
    public void run(String...args) throws Exception {

        logger.info("Loading sample data...");

        // Tworzenie filmów
        /*
        Filmy film1 = new Filmy("The Shawshank Redemption", 1994, "Drama", true, 9, "A masterpiece of storytelling");
        Filmy film2 = new Filmy("The Godfather", 1972, "Crime", false, 9, "An iconic film with brilliant performances");
        Filmy film3 = new Filmy("The Dark Knight", 2008, "Action", true, 8, "A thrilling and dark superhero movie");
        Filmy film4 = new Filmy("Pulp Fiction", 1994, "Crime", true, 8, "Quentin Tarantino's cult classic");
        Filmy film5 = new Filmy("Schindler's List", 1993, "Biography", true, 8, "A powerful and moving portrayal of the Holocaust");
        Filmy film6 = new Filmy("Forrest Gump", 1994, "Drama", true, 8, "Life is like a box of chocolates");
        Filmy film7 = new Filmy("The Lord of the Rings: The Return of the King", 2003, "Adventure", true, 9, "Epic conclusion to the Lord of the Rings trilogy");
        Filmy film8 = new Filmy("Fight Club", 1999, "Drama", true, 8, "The first rule of Fight Club is: You do not talk about Fight Club");
        Filmy film9 = new Filmy("Inception", 2010, "Action", true, 9, "Mind-bending heist thriller");
        Filmy film10 = new Filmy("The Matrix", 1999, "Action", true, 8, "Welcome to the real world");
        Filmy film11 = new Filmy("Goodfellas", 1990, "Crime", true, 8, "Martin Scorsese's mob masterpiece");
        Filmy film12 = new Filmy("Se7en", 1995, "Crime", true, 8, "What's in the box?");
        Filmy film13 = new Filmy("The Silence of the Lambs", 1991, "Thriller", true, 8, "Hannibal Lecter's chilling charm");
        Filmy film14 = new Filmy("The Usual Suspects", 1995, "Crime", true, 8, "Who is Keyser Söze?");
        Filmy film15 = new Filmy("Saving Private Ryan", 1998, "War", true, 8, "Epic WWII drama");
        Filmy film16 = new Filmy("The Departed", 2006, "Crime", true, 8, "Scorsese's gripping crime saga");
        Filmy film17 = new Filmy("Gladiator", 2000, "Action", true, 8, "Are you not entertained?");
        Filmy film18 = new Filmy("The Prestige", 2006, "Drama", true, 9, "The rivalry between two magicians");
        Filmy film19 = new Filmy("The Green Mile", 1999, "Drama", true, 8, "Miracles can happen");
        Filmy film20 = new Filmy("Braveheart", 1995, "Biography", true, 8, "Freedom!");

// Zapisanie filmów w bazie danych
        film1 = filmRepository.save(film1);
        film2 = filmRepository.save(film2);
        film3 = filmRepository.save(film3);
        film4 = filmRepository.save(film4);
        film5 = filmRepository.save(film5);
        film6 = filmRepository.save(film6);
        film7 = filmRepository.save(film7);
        film8 = filmRepository.save(film8);
        film9 = filmRepository.save(film9);
        film10 = filmRepository.save(film10);
        film11 = filmRepository.save(film11);
        film12 = filmRepository.save(film12);
        film13 = filmRepository.save(film13);
        film14 = filmRepository.save(film14);
        film15 = filmRepository.save(film15);
        film16 = filmRepository.save(film16);
        film17 = filmRepository.save(film17);
        film18 = filmRepository.save(film18);
        film19 = filmRepository.save(film19);
        film20 = filmRepository.save(film20);

// Tworzenie list oglądania
        ListyOgladania lista1 = new ListyOgladania("Moja lista 1", "Lista filmów, które chcę obejrzeć ze znajomymi");
        ListyOgladania lista2 = new ListyOgladania("Moja lista 2", "Lista filmów do obejrzenia później");
        ListyOgladania lista3 = new ListyOgladania("Moja lista 3", "Lista filmów do obejrzenia ponownie");
        ListyOgladania lista4 = new ListyOgladania("Moja lista 4", "Lista filmów, które zapadły mi w pamięć ");
        ListyOgladania lista5 = new ListyOgladania("Pozostałe", "Pozostałe");

// Dodanie filmów do list oglądania
        lista1.setFilmy(film1);
        lista2.setFilmy(film2);
        lista3.setFilmy(film3);
        lista4.setFilmy(film4);
        lista5.setFilmy(film5);
        lista5.setFilmy(film6);
        lista1.setFilmy(film7);
        lista5.setFilmy(film8);
        lista5.setFilmy(film9);
        lista2.setFilmy(film10);
        lista5.setFilmy(film11);
        lista5.setFilmy(film12);
        lista5.setFilmy(film13);
        lista5.setFilmy(film14);
        lista4.setFilmy(film15);
        lista5.setFilmy(film16);
        lista5.setFilmy(film17);
        lista3.setFilmy(film18);
        lista5.setFilmy(film19);
        lista5.setFilmy(film20);

// Zapisanie list oglądania w bazie danych
        lista1 = listyOgladaniaRepository.save(lista1);
        lista2 = listyOgladaniaRepository.save(lista2);
        lista3 = listyOgladaniaRepository.save(lista3);
        lista4 = listyOgladaniaRepository.save(lista4);
        lista5 = listyOgladaniaRepository.save(lista5);



        logger.info("Sample data loaded successfully!");

         */
    }


}
