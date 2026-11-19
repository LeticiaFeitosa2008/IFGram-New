package com.ifpb.ifgram.repository;

import com.ifpb.ifgram.model.ModelComent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<ModelComent, Long>{

    List<ModelComent> findByPostIdOrderByCriadoEmAsc(Long postId);

    Long countByPostId(Long postId);

    List<ModelComent> findByAutorId(Long autorId);

}
