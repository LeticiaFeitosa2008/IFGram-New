package com.ifpb.ifgram.dto;

import jakarta.validation.constraints.NotNull;

public record LikeRequest(
        @NotNull
        Long postId,

        @NotNull
        Long autorId
) {
}
