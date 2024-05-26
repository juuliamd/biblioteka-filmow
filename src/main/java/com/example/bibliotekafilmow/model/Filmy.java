package com.example.bibliotekafilmow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Filmy {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private int releaseYear;
    private String genre;
    private boolean watched;
    private int rating;
    private String review;

    public Filmy(){}
    public Filmy(String title, int releaseYear, String genre, boolean watched, int rating, String review){
        this.title=title;
        this.releaseYear = releaseYear;
        this.genre=genre;
        this.watched=watched;
        this.rating=rating;
        this.review=review;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString(){
        return "Film{"+
                "id="+id+'\''+
                "tytuł="+title+'\''+
                "rok="+ releaseYear +'\''+
                "gatunek="+genre+'\''+
                "obejrzane="+watched+'\''+
                "ocena="+rating+'\''+
                "review="+review+'\''+
                '}';


    }

}
