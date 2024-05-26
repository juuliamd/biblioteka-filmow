package com.example.bibliotekafilmow.model;

import jakarta.persistence.*;

@Entity
public class ListyOgladania {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String describtion;

    @OneToOne
    @JoinColumn(name="film_id")
    private Filmy filmy;
    public ListyOgladania(){

    }
    public ListyOgladania(String title, String describtion, Filmy filmy){
        this.describtion=describtion;
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
    public String getDescribtion() {return describtion;}
    public void setDescribtion(String describtion) {this.describtion=describtion;}
    public Filmy getFilmy(){
        return filmy;
    }
    public void setFilmy(Filmy filmy){
        this.filmy=filmy;
    }
}
