package com.devmountain.noteApp.repositories;


import com.devmountain.noteApp.entities.Notes;
import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {

    List<Notes> findAllByUserEquals(User user);
}
