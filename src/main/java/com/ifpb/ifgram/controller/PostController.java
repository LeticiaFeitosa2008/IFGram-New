package br.edu.ifpb.ifgram.controller;

import br.edu.ifpb.ifgram.service.PostService;
import br.edu.ifpb.ifgram.dto.PostRequest;
import br.edu.ifpb.ifgram.dto.PostResponse;

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

    // GET /post
    @GetMapping
    public List<PostResponse> listarFeed() {
        return postService.listarFeed();
    }

    // GET /post/{id}
    @GetMapping("/{id}")
    public PostResponse buscarPorId(@PathVariable Long id) {
        return postService.buscarPorId(id);
    }

    // GET /post/autor/{autorId}
    @GetMapping("/autor/{autorId}")
    public List<PostResponse> listarPorAutor(
            @PathVariable Long autorId) {

        return postService.listarPorAutor(autorId);
    }

    // POST /post
    @PostMapping
    public PostResponse criar(
            @Valid @RequestBody PostRequest request) {

        return postService.criar(request);
    }

    // DELETE /post/{id}
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postService.deletar(id);
    }
}