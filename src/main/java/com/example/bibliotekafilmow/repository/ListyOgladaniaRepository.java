package com.example.bibliotekafilmow.repository;

import com.example.bibliotekafilmow.model.ListyOgladania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListyOgladaniaRepository extends JpaRepository <ListyOgladania, Integer> {
}
