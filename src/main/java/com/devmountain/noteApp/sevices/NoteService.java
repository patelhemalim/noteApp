package com.devmountain.noteApp.sevices;

import com.devmountain.noteApp.dtos.NoteDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    @Transactional
    void deleteNoteById(Long noteId);

    @Transactional
    void updateNoteById(NoteDto noteDto);

    @Transactional
    List<NoteDto> getAllNotesByUserId(Long userId);

    Optional<NoteDto> getNoteById(Long noteId);
}
