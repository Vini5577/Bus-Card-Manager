package com.api.busCardManager.controller;

import com.api.busCardManager.dtos.UserDto;
import com.api.busCardManager.model.User;
import com.api.busCardManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ResponseEntity<Object> getUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nenhum usuario encontrado");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        try {
            if(userService.verifyEmail(userDto.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USUARIO JÁ CADASTRADO");
            }

            return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userDto));
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR NO SERVIDOR!!!");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
        try {
            User updateUser = userService.updateUser(userDto);
            if (updateUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(updateUser);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR NO SERVIDOR!!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            return userService.deleteUser(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR NO SERVIDOR");
        }
    }
}
