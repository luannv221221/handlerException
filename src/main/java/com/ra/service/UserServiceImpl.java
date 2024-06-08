package com.ra.service;

import com.ra.model.dto.request.UserRequestDTO;
import com.ra.model.dto.respone.UserDTO;
import com.ra.model.entity.User;
import com.ra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> list = userRepository.findAll();
        List<UserDTO> listUserDTO = new ArrayList<>();

        list.forEach(user -> listUserDTO.add(
                UserDTO.builder().id(user.getId()).
                        userName(user.getUserName()).
                        address(user.getAddress())
                        .build()));
        return listUserDTO;
    }

    @Override
    public UserDTO save(UserRequestDTO requestDTO) {
        User userNew = User.builder()
                .id(requestDTO.getId()).
                userName(requestDTO.getUserName()).
                address(requestDTO.getAddress()).
                password(requestDTO.getPassword())
            .build();
        User user = userRepository.save(userNew);
        return UserDTO.builder().
                id(user.getId()).
                userName(user.getUserName()).address(user.getAddress()).
                build();
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("id not exist"));

        return UserDTO.builder().id(user.getId()).userName(user.getUserName()).build();
    }
}
