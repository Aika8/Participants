package com.internship.second.repository;

import com.internship.second.model.Participant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {

    List<Participant> findAllByNameContaining(String search);
}
