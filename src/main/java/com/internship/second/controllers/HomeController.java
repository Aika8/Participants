package com.internship.second.controllers;

import com.internship.second.model.Person;
import com.internship.second.repository.PersonRepository;
import com.internship.second.repository.PhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
@Slf4j
public class HomeController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PhoneRepository phoneRepository;


    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody Person person) {
        log.info("create {}", person);
        person = personRepository.save(person);
        return ResponseEntity.ok(person);
    }


    @GetMapping(value = "/by-ages")
    public ResponseEntity<?> getBetweenAges(@RequestParam int age1, @RequestParam int age2) {
        log.info("get persons between ages {} and {}", age1, age2);
        return ResponseEntity.ok(personRepository.findAllByAgeBetween(age1, age2));
    }

    @GetMapping(value = "/by-name")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        log.info("get persons by name containing {}", name);
        return ResponseEntity.ok(personRepository.findAllByNameContaining(name));
    }

    @GetMapping()
    public ResponseEntity<?> get() {
        log.info("get all persons");
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping(value = "/phones")
    public ResponseEntity<?> getPhones(@RequestParam int id) {
        Person person = personRepository.getById(id);
        log.info("get all phones of {}", person.getName());
        return ResponseEntity.ok(phoneRepository.findAllByPerson(person));
    }

}
