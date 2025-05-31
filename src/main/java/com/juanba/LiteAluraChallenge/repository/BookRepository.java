package com.juanba.LiteAluraChallenge.repository;

import com.juanba.LiteAluraChallenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
