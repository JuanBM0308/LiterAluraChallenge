package com.juanba.LiteAluraChallenge.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_person")
public record Person(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @JsonAlias("birth_year")
        Long birthYear,

        @JsonAlias("death_year")
        Long deathYear,

        @JsonAlias("name")
        String name
) {
}
