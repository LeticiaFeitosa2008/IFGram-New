package com.ifpb.ifgram.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentRequest(

        @NotBlank(message = "O texto do comentário é obrigatório")
        @Size(max = 500, message = "O comentário deve ter no máximo 500 caracteres")
        String texto,

        @NotNull(message = "O ID do post é obrigatório")
        Long postId,

        @NotNull(message = "O ID do autor é obrigatório")
        Long autorId
) {}
