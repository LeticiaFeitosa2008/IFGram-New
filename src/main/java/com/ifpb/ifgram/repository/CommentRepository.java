package com.ifpb.ifgram.repository;

import com.ifpb.ifgram.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByPostIdOrderByCriadoEmAsc(Long postId);

    Long countByPostId(Long postId);

    List<Comment> findByAutorId(Long autorId);

}
