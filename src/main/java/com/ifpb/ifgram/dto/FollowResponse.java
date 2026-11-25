package com.ifpb.ifgram.dto;

import com.ifpb.ifgram.model.Follow;
import java.time.LocalDateTime;

public record FollowResponse(
        Long id,
        Long seguidorId,
        String seguidorNome,
        Long seguidoId,
        String seguidoNome,
        LocalDateTime criadoEm
) {
    public static FollowResponse from(Follow follow) {
        return new FollowResponse(
                follow.getId(),
                follow.getSeguidor().getId(),
                follow.getSeguidor().getNome(),
                follow.getSeguido().getId(),
                follow.getSeguido().getNome(),
                follow.getCriadoEm()
        );
    }


}
