package com.api.busCardManager.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.api.busCardManager.dtos.UserDto;
import com.api.busCardManager.model.User;
import com.api.busCardManager.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {
        var hashedPassword = hashPassword(userDto.getPassword());
        userDto.setPassword(hashedPassword);

        User user = new User();
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setCards(userDto.getCards());
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User updateUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findById(userDto.getId());

        if(existingUser.isPresent()) {
            if(!isBlank(userDto.getName())) {
                existingUser.get().setName(userDto.getName());
            }

            if(!isBlank(userDto.getEmail())) {
                existingUser.get().setEmail(userDto.getEmail());
            }

            if(!isBlank(userDto.getPassword())) {
                var hashedPassword = hashPassword(userDto.getPassword());
                existingUser.get().setPassword(hashedPassword);
            }

            return userRepository.save(existingUser.get());
        } else {
            return null;
        }
    }

    public ResponseEntity<String> deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if(!existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!!");
        }

        userRepository.delete(existingUser.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!!");
    }

    public String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public Boolean verifyEmail(String email) {
        return  userRepository.findByEmail(email).isPresent();
    }

    private Boolean isBlank(String data) {
        return data == null;
    }
}
