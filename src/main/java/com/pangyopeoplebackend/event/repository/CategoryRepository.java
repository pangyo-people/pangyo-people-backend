package com.pangyopeoplebackend.event.repository;

import com.pangyopeoplebackend.event.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
