package com.ifpb.ifgram.repository;

import com.ifpb.ifgram.model.Follow;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository<Follow> extends JpaRepository<Follow, Long> {

    boolean existsBySeguidorIdAndSeguidoId(Long seguidorId, Long seguidoId);

    Optional<Follow> findBySeguidorIdAndSeguidoId(Long seguidorId, Long seguidoId);

    long countBySeguidoId(Long seguidoId);

    long countBySeguidorId(Long seguidorId);

    List<Follow> findBySeguidoId(Long seguidoId);

    List<Follow> findBySeguidorId(Long seguidorId);
}