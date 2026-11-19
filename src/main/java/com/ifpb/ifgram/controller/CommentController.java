package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.dto.CommentRequest;
import com.ifpb.ifgram.dto.CommentResponse;
import com.ifpb.ifgram.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("comment")

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> criarComentario(@RequestBody CommentRequest request) {

        CommentResponse response = commentService.criar(request);

        if (response == null) {

            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> listarPorPost(@PathVariable Long postId) {

        List<CommentResponse> comentarios = commentService.listarPorPost(postId);

        return ResponseEntity.ok(comentarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id) {

        boolean deletado = commentService.deletar(id);

        if (deletado) {

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}