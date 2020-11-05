package com.note.Notepad.controllers;

import com.note.Notepad.models.Notepad;
import com.note.Notepad.services.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "https://localhost:8080")
@RequestMapping("/api")
public class NotepadController {

    @Autowired
    private NotepadService notepadService;

    @GetMapping("/notes")
    public ResponseEntity<List<Notepad>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Notepad> notepads = new ArrayList<Notepad>();

            if (title == null)
                notepadService.findAllNotes().forEach(notepads::add);
            else
                notepadService.findByTitle(title).forEach(notepads::add);

            if (notepads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(notepads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Notepad> getTutorialById(@PathVariable("id") String id) {

        try {
            Notepad notepadDetail = notepadService.findNoteById(id);
            return new ResponseEntity<Notepad>(notepadDetail, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/newnote")
    public ResponseEntity<Notepad> createTutorial(@RequestBody Notepad notepad) {
        try {
            Notepad result = notepadService.saveNote(new Notepad(notepad.getTitle(), notepad.getBody(),
                    notepad.getDate()));
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<HttpStatus> deleteNotepad(@PathVariable("id") String id) {
        try {
            notepadService.deleteNote(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delnotes")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            notepadService.deleteAllNotes();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/notes/{id}")
    public ResponseEntity<Notepad> updateTutorial(@PathVariable("id") String id, @RequestBody Notepad notepad) {
        Notepad notepadData = notepadService.findNoteById(id);

        try {
            Notepad aNote = new Notepad();
            aNote.setTitle(notepad.getTitle());
            aNote.setBody(notepad.getBody());
            aNote.setDate(notepad.getDate());

            return new ResponseEntity<>(notepadService.saveNote(aNote), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }


}
