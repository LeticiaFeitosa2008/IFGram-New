package com.ifpb.ifgram.controller;

import com.ifpb.ifgram.dto.FollowRequest;
import com.ifpb.ifgram.dto.FollowResponse;
import com.ifpb.ifgram.service.FollowService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("follow")
public class FollowController {

    private final FollowService service;

    public FollowController(FollowService service) {
        this.service = service;
    }
    @PostMapping
    public FollowResponse seguir(@Valid @RequestBody FollowRequest request) {
        return service.seguir(request);
    }
    @DeleteMapping("/seguidor/{seguidorId}/seguido/{seguidoId}")
    public String deixarDeSeguir(@PathVariable Long seguidorId, @PathVariable Long seguidoId) throws Throwable {
        service.deixarDeSeguir(seguidorId, seguidoId);
        return "Você deixou de seguir este usuário!";
    }
    @GetMapping("/usuario/{userId}/seguidores")
    public List<FollowResponse> listarSeguidores(@PathVariable Long userId) {
        return service.listarSeguidores(userId);
    }
    @GetMapping("/usuario/{userId}/seguindo")
    public List<FollowResponse> listarSeguindo(@PathVariable Long userId) {
        return service.listarSeguindo(userId);
    }
}
