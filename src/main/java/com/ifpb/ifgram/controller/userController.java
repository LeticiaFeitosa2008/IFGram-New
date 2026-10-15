
package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.DTO.UserRequest;
import com.ifpb.ifgram.DTO.UserResponse;
import com.ifpb.ifgram.service.EmailDuplicadoException;
import com.ifpb.ifgram.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
public class userController {
    private final UserService service;

    public userController(UserService service) {
        this.service = service;

    }

    @PostMapping
    public UserResponse criar(@Valid @RequestBody UserRequest request) throws EmailDuplicadoException {
        return service.criar(request);
    }

    @GetMapping
    public List<UserResponse>getUser(){
        List<UserResponse>listaUsuarios=service.buscarTodosUsuarios();
        return listaUsuarios;
    }

    @PutMapping
    public UserResponse UpdateUser(UserRequest request) throws Exception {
        return service.atualizarUsuario(request);
    }

    @PatchMapping
    public String patchUser(){
        return "Chamei o endpoint como um patch";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Chamei o delete";
    }
}