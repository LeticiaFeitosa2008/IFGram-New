package com.ifpb.ifgram.dto;

import com.ifpb.ifgram.model.Like;
import java.time.LocalDateTime;

public record LikeResponse(
        Long id,
        Long postId,
        Long autorId,
        String autorNome,
        LocalDateTime criadoEm
) {
    public static LikeResponse from(Like like) {
        return new LikeResponse(
                like.getId(),
                like.getPost().getId(),
                like.getAutor().getId(),
                like.getAutor().getNome(),
                like.getCriadoEm()
        );
    }
}
