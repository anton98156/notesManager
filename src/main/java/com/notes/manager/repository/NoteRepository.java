package com.notes.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notes.manager.model.Note;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
