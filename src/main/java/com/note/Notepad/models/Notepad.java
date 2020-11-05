package com.note.Notepad.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "notes")
public class Notepad {

    @Id
    private String id;

    private String title;

    private String body;

    private Date date;

    public Notepad(String title, String body, Date date) {
        this.title = title;
        this.body = body;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notepad{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
