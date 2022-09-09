package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto implements Serializable {

    private Long id;
    private String body;
    private UserDto userDto;

    public NoteDto(Notes notes){
        if (notes.getId() != null ){
            this.id = notes.getId();
        }
        if (notes.getBody() != null){
            this.body = notes.getBody();
        }
    }

}
