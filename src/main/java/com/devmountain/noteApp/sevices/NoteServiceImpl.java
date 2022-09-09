package com.devmountain.noteApp.sevices;


import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.entities.Notes;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.NoteRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import static com.sun.tools.javac.resources.CompilerProperties.Notes.Note;


@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;


    @Override
    @Transactional
    public void addNote(NoteDto noteDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Notes note = new Notes(noteDto);
        userOptional.ifPresent(note::setUser);
        noteRepository.saveAndFlush(note);
    }

    @Override
    @Transactional
    public void deleteNoteById(Long noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        noteOptional.ifPresent(note -> noteRepository.delete(note));
    }


    @Override
    @Transactional
    public void updateNoteById(NoteDto noteDto) {
        Optional<Notes> noteOptional = noteRepository.findById(noteDto.getId());
        noteOptional.ifPresent(note -> {
            note.setBody(noteDto.getBody());
            noteRepository.saveAndFlush(note);
        });
    }


    @Override
    @Transactional
    public List<NoteDto> getAllNotesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Notes> noteList = noteRepository.findAllByUserEquals(userOptional.get());
            return noteList.stream().map(note -> new NoteDto(note)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<NoteDto> getNoteById(Long noteId) {
        Optional<Notes> noteOptional = noteRepository.findById(noteId);
        if (noteOptional.isPresent()) {
            return Optional.of(new NoteDto(noteOptional.get()));
        }
        return Optional.empty();
    }

}
