package com.example.bibliotekafilmow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ListyOgladania {
    @Id
    @GeneratedValue
    private Integer id;
}
