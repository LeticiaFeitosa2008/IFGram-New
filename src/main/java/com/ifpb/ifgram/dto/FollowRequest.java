package com.ifpb.ifgram.dto;

import jakarta.validation.constraints.NotNull;

public record FollowRequest(
        @NotNull
        Long seguidorId,

        @NotNull
        Long seguidoId
) {
}