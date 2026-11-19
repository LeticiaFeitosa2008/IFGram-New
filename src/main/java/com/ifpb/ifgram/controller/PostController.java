package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.service.PostService;
import com.ifpb.ifgram.dto.PostRequest;
import com.ifpb.ifgram.dto.PostResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<PostResponse> listarFeed() {
        return postService.listarFeed();
    }


    @GetMapping("/{id}")
    public PostResponse buscarPorId(@PathVariable Long id) {
        return postService.buscarPorId(id);
    }


    @GetMapping("/autor/{autorId}")
    public List<PostResponse> listarPorAutor(
            @PathVariable Long autorId) {

        return postService.listarPorAutor(autorId);
    }


    @PostMapping
    public PostResponse criar(
            @Valid @RequestBody PostRequest request) {

        return postService.criar(request);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postService.deletar(id);
    }
}