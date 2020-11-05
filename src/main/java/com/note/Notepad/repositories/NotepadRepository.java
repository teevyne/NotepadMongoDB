package com.note.Notepad.repositories;

import com.note.Notepad.models.Notepad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotepadRepository extends MongoRepository<Notepad, String> {

    List<Notepad> findByTitle(String title);
    List<Notepad> findByDate(Date date);

}
