package com.juanba.LiteAluraChallenge.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Table(name = "tb_book")
@JsonIgnoreProperties(ignoreUnknown = true)
public record Book (

        @Id
        @JsonAlias("id")
        Long id,

        @JsonAlias("title")
        String title,

        @JsonAlias("authors")
        Person authors,

        @JsonAlias("languages")
        String languages,

        @JsonAlias("download_count")
        Long downloadCount
) {

}
