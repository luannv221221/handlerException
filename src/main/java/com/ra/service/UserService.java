package com.ra.service;

import com.ra.model.dto.request.UserRequestDTO;
import com.ra.model.dto.respone.UserDTO;
import com.ra.model.entity.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO save(UserRequestDTO requestDTO);
    UserDTO getById(Long id);
}
