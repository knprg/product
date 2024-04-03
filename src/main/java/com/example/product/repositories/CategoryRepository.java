package com.example.product.repositories;

import com.example.product.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);
    Optional<Category> findByName(String name);
}
