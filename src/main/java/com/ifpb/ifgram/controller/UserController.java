
package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.DTO.UserRequest;
import com.ifpb.ifgram.DTO.UserResponse;
import com.ifpb.ifgram.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("User")
public class userController {
    private final UserService service;

    public userController(UserService service) {
        this.service = service;

    }

    @PostMapping
    public UserResponse criar(@Valid @RequestBody UserRequest request) {
        return service.criar(request);
    }
}

    @GetMapping
    public String getUser(){
        return "get user was called";
    }

    @PostMapping
    public String postUser(){
        return "Chamei o endpoint como um post";
    }

    @PutMapping
    public String putUser(){
        return "Chamei o endpoint como um put";
    }

    @PatchMapping
    public String patchUser(){
        return "Chamei o endpoint como um patch";
    }

    @DeleteMapping
    public String deletar(){
        return null;
    }
}