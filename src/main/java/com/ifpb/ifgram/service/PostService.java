package com.ifpb.ifgram.service;

import com.ifpb.ifgram.dto.PostRequest;
import com.ifpb.ifgram.dto.PostResponse;
import com.ifpb.ifgram.model.Post;
import com.ifpb.ifgram.model.User;
import com.ifpb.ifgram.repository.PostRepository;
import com.ifpb.ifgram.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;

    }

    @Transactional
    public PostResponse criar(PostRequest request) throws Exception {

        Optional<User> autor = userRepository.findById(request.autorId());
        if (autor.isEmpty()){

            throw new Exception("Autor com ID " + request.autorId() + " não encontrado.");
        }

        Post post = new Post();

        post.setImagemURL(request.imagemUrl());

        post.setLegenda(request.legenda());

        post.setAutor(autor.get());

        Post salvo = postRepository.save(post);

        return PostResponse.from(salvo);
    }

    public List<PostResponse> listarFeed(){

        List<Post> listaPosts = postRepository.Buscarfeedmaisnovos();
        List<PostResponse> listaPostsResponse = new ArrayList<>();

        for (Post post : listaPosts){

            PostResponse postResponse = PostResponse.from(post);

            listaPostsResponse.add(postResponse);
        }

        return listaPostsResponse;
    }

    public List<PostResponse> listarPorAutor(Long autorId){

        List<Post> listaPosts = postRepository.findByAutorId(autorId);

        List<PostResponse> listaPostsResponse = new ArrayList<>();

        for (Post post : listaPosts){

            PostResponse postResponse = PostResponse.from(post);

            listaPostsResponse.add(postResponse);
        }

        return listaPostsResponse;
    }

    public PostResponse buscarPorId(Long id) throws Exception {

        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()){

            throw new Exception("Post não encontrado");
        }

        return PostResponse.from(post.get());
    }

    @Transactional
    public void deletar(Long id) throws Exception {

        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {

            throw new Exception("Post não existe no banco de dados, por isso não pode ser deletado.");
        }

        Post postDelete = post.get();
        postRepository.delete(postDelete);
    }
}