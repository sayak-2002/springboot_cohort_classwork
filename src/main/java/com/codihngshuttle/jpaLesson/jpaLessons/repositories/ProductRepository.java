package com.codihngshuttle.jpaLesson.jpaLessons.repositories;

import com.codihngshuttle.jpaLesson.jpaLessons.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);
}