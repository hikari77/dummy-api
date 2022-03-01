package com.bosco.dummyrest.dao;

import com.bosco.dummyrest.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
