package com.internship.second.repository;

import com.internship.second.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByAgeBetween(int age1, int age2);
    List<Person> findAllByNameContaining(String search);
}
