package br.edu.ifpb.ifgram.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequest(

        @NotBlank(message = "A URL da imagem é obrigatória")
        String imagemUrl,

        @Size(max = 300, message = "A legenda deve ter no máximo 300 caracteres")
        String legenda,

        @NotNull(message = "O ID do autor é obrigatório")
        Long autorId

) {}