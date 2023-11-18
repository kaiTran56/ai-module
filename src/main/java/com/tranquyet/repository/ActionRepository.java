package com.tranquyet.repository;

import com.tranquyet.entity.ActionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
}
