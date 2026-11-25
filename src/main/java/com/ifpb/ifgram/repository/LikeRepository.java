package com.ifpb.ifgram.repository;

import com.ifpb.ifgram.model.Like;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByPostIdAndAutorId(Long postId, Long autorId);
    long countByPostId(Long postId);

    List<Like> findByPostId(Long postId);
    List<Like> findByAutorId(Long autorId);
    Optional<Like> findByPostIdAndAutorId(Long postId, Long autorId);
}