package com.ifpb.ifgram.service;

import com.ifpb.ifgram.dto.LikeRequest;
import com.ifpb.ifgram.dto.LikeResponse;
import com.ifpb.ifgram.model.Like;
import com.ifpb.ifgram.model.Post;
import com.ifpb.ifgram.model.User;
import com.ifpb.ifgram.repository.LikeRepository;
import com.ifpb.ifgram.repository.PostRepository;
import com.ifpb.ifgram.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public LikeService(
            LikeRepository likeRepository,
            PostRepository postRepository,
            UserRepository userRepository
    ) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public LikeResponse curtir(LikeRequest request) {
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Publicação não encontrada."
                ));
        User autor = userRepository.findById(request.autorId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado."
                ));
        if (likeRepository.existsByPostIdAndAutorId(
                request.postId(), request.autorId()
        )) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Este usuário já curtiu esta publicação."
            );
        }
        Like like = new Like(post, autor);
        Like likeSalvo = likeRepository.save(like);
        return LikeResponse.from(likeSalvo);
    }
    @Transactional
    public void descurtir(Long postId, Long autorId) {
        Like like = likeRepository.findByPostIdAndAutorId(postId, autorId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Curtida não encontrada para esta publicação e usuário."
                ));
        likeRepository.delete(like);
    }
    public long contarPorPost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Publicação não encontrada."
            );
        }
        return likeRepository.countByPostId(postId);
    }
    public List<LikeResponse> listarPorPost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Publicação não encontrada."
            );
        }
        return likeRepository.findByPostId(postId)
                .stream()
                .map(LikeResponse::from)
                .collect(Collectors.toList());
    }
}
