package com.note.Notepad.services;

import com.note.Notepad.models.Notepad;

import java.util.Date;
import java.util.List;

public interface NotepadService {

    Notepad saveNote(Notepad note);

    Notepad updateNote(Notepad note);

    List<Notepad> findAllNotes();

    void deleteNote(String NoteId);

    void deleteAllNotes();

    Notepad findNoteById(String noteId);

    List<Notepad> findByTitle(String title);

    List<Notepad> findByDate(Date date);
}
