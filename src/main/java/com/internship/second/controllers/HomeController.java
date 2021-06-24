package com.internship.second.controllers;

import com.internship.second.model.Document;
import com.internship.second.model.Participant;
import com.internship.second.repository.DocumentRepository;
import com.internship.second.repository.ParticipantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
@Slf4j
public class HomeController {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private DocumentRepository documentRepository;


    @PostMapping()
    public Participant save(@RequestBody Participant participant) {
        log.info("create {}", participant);
        participant = participantRepository.save(participant);
        return participant;
    }


//    @GetMapping(value = "/by-ages")
//    public List<Participant> getBetweenAges(@RequestParam int age1, @RequestParam int age2) {
//        log.info("get persons between ages {} and {}", age1, age2);
//        return participantRepository.findAllByAgeBetween(age1, age2);
//    }

    @GetMapping(value = "/by-name/{name}")
    public List<Participant> getByName(@PathVariable String name) {
        log.info("get persons by name containing {}", name);
        return participantRepository.findAllByNameContaining(name);
    }

    @GetMapping()
    public List<Participant> get() {
        log.info("get all participants");
        return participantRepository.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id ){
        Participant participant = participantRepository.getById(id);
        log.info("delete {}", participant.getName());
        participantRepository.delete(participant);
    }

    @GetMapping(value = "/documents/{id}")
    public List<Document> getDocuments(@PathVariable Integer id ) {
        Participant participant = participantRepository.getById(id);
        log.info("get all phones of {}", participant.getName());
        return documentRepository.findAllByParticipant(participant);
    }

    @PostMapping(value = "/documents")
    public Document saveDoc(@RequestBody Document document) {
        log.info("create {}", document);
        document = documentRepository.save(document);
        return document;
    }

}
