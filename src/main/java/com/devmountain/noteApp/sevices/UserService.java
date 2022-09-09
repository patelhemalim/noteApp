package com.devmountain.noteApp.sevices;

import com.devmountain.noteApp.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    @Transactional
    List<String> userLogin(UserDto userDto);
}
