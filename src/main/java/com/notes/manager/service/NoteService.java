package com.notes.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.notes.manager.model.Note;
import com.notes.manager.model.NoteRequestBody;
import com.notes.manager.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(NoteRequestBody request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setCreationDateTime(LocalDateTime.now());
        return noteRepository.save(note);
    }
    

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, String title, String content) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(title);
            note.setContent(content);
            return noteRepository.save(note);
        }
        return null;
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
