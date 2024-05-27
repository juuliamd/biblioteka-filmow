package com.example.bibliotekafilmow.model;

import jakarta.persistence.*;

@Entity
public class ListyOgladania {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String description;

    @OneToOne
    @JoinColumn(name="film_id")
    private Filmy filmy;
    public ListyOgladania(){

    }
    public ListyOgladania(String title, String describtion, Filmy filmy){
        this.description =describtion;
        this.title=title;
        this.filmy=filmy;
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
    public void setTitle(String title) {this.title=title;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Filmy getFilmy(){
        return filmy;
    }
    public void setFilmy(Filmy filmy){
        this.filmy=filmy;
    }
}
