package com.note.Notepad.services;

import com.note.Notepad.models.Notepad;
import com.note.Notepad.repositories.NotepadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NotepadServiceImpl implements NotepadService{

    @Autowired
    private NotepadRepository notepadRepository;

    public Notepad saveNote(Notepad note) {
        return notepadRepository.save(note);
    }


    public Notepad updateNote(Notepad note) {
        return notepadRepository.save(note);
    }


    public List<Notepad> findAllNotes() {
        return notepadRepository.findAll();
    }

    public void deleteNote(String noteId) {
        notepadRepository.deleteById(noteId);
    }

    public void deleteAllNotes(){
        notepadRepository.deleteAll();
    }

    public Notepad findNoteById(String noteId) {
        return notepadRepository.findById(noteId).orElse(null);
    }

    public List<Notepad> findByTitle(String title) {
        return notepadRepository.findByTitle(title);
    }

    public List<Notepad> findByDate(Date date) {
        return notepadRepository.findByDate(date);
    }
}
