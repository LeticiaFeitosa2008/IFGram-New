package com.ifpb.ifgram.dto;

public record PostResponse(

        import java.time.LocalDateTime;

        public record PostResponse(Long id, Long autorId, String imagemURL, String legenda, LocalDateTime criadoEm,
                           String autorNome) {

    public static PostResponse from (Post post){

        return new PostResponse(post.getId(), post.getAutor().getId(), post.getImagemURL(), post.getLegenda(), post.getCriadoEm(), post.getAutor().getNome());
    }
}) {
}
