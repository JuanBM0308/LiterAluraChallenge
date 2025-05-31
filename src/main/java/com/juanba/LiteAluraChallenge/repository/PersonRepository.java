package com.juanba.LiteAluraChallenge.repository;

import com.juanba.LiteAluraChallenge.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);

    @Query("SELECT p FROM Person p " +
            "WHERE (:searchStartYear <= p.deathYear AND :searchEndYear >= p.birthYear)")
    List<Person> findAuthorsLivedWithinYearRange(
            @Param("searchStartYear") Long searchStartYear,
            @Param("searchEndYear") Long searchEndYear);
}
