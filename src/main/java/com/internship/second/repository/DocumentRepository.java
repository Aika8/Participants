package com.internship.second.repository;


import com.internship.second.model.Document;
import com.internship.second.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findAllByParticipant(Participant participant);
}
