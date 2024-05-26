package com.example.bibliotekafilmow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ListyOgladania {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String describtion;

    public ListyOgladania(){

    }
    public ListyOgladania(String title, String describtion){
        this.describtion=describtion;
        this.title=title;
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
}
