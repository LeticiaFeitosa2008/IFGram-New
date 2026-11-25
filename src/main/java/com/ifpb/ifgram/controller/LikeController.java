package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.dto.LikeRequest;
import com.ifpb.ifgram.dto.LikeResponse;
import com.ifpb.ifgram.service.LikeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like")
public class LikeController {
    private final LikeService service;
    public LikeController(LikeService service) {
        this.service = service;
    }

    @PostMapping
    public LikeResponse curtir(@Valid @RequestBody LikeRequest request) {
        return service.curtir(request);
    }

    @DeleteMapping("/post/{postId}/usuario/{autorId}")
    public String descurtir(
            @PathVariable Long postId,
            @PathVariable Long autorId
    ) {
        service.descurtir(postId, autorId);
        return "Curtida removida com sucesso!";
    }
    @GetMapping("/post/{postId}")
    public List<LikeResponse> listarPorPost(@PathVariable Long postId) {
        return service.listarPorPost(postId);
    }

    @GetMapping("/post/{postId}/total")
    public long contarPorPost(@PathVariable Long postId) {
        return service.contarPorPost(postId);
    }
}
