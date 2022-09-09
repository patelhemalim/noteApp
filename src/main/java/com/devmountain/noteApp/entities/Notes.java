package com.devmountain.noteApp.entities;


import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Notes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(columnDefinition = "text")
    private String body;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public Notes() {
//    }
//
//    public Notes(Long id, String body) {
//        this.id = id;
//        this.body = body;
//    }

    @JsonBackReference
    @ManyToOne
    private User user;

    public Notes (NoteDto noteDto){
        if (noteDto.getBody() != null){
            this.body = noteDto.getBody();
        }
    }
}
