package com.internship.second.repository;


import com.internship.second.model.Person;
import com.internship.second.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findAllByPerson(Person person);
}
