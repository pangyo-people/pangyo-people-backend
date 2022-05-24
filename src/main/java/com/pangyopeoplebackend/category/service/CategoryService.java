package com.pangyopeoplebackend.category.service;

import com.pangyopeoplebackend.category.Category;
import com.pangyopeoplebackend.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    void save() throws Throwable {
        Category category1 = Category.builder()
                .categoryId(0)
                .categoryName("모바일")
                .build();

        Category category2 = Category.builder()
                .categoryId(1)
                .categoryName("프론트")
                .build();

        Category category3 = Category.builder()
                .categoryId(2)
                .categoryName("서버")
                .build();

        Category category4 = Category.builder()
                .categoryId(3)
                .categoryName("클라우드")
                .build();

        Category category5 = Category.builder()
                .categoryId(4)
                .categoryName("빅데이터")
                .build();

        Category category6 = Category.builder()
                .categoryId(5)
                .categoryName("AI")
                .build();

        Category category7 = Category.builder()
                .categoryId(6)
                .categoryName("보안")
                .build();

        Category category8 = Category.builder()
                .categoryId(7)
                .categoryName("교육")
                .build();

        Category category9 = Category.builder()
                .categoryId(8)
                .categoryName("경진대회")
                .build();

        Category category10 = Category.builder()
                .categoryId(9)
                .categoryName("동아리")
                .build();

        Category category11 = Category.builder()
                .categoryId(10)
                .categoryName("컨퍼런스")
                .build();

        Category category12 = Category.builder()
                .categoryId(11)
                .categoryName("해커톤")
                .build();

        category1 = categoryRepository.save(category1);
        category2 = categoryRepository.save(category2);
        category3 = categoryRepository.save(category3);
        category4 = categoryRepository.save(category4);
        category5 = categoryRepository.save(category5);
        category6 = categoryRepository.save(category6);
        category7 = categoryRepository.save(category7);
        category8 = categoryRepository.save(category8);
        category9 = categoryRepository.save(category9);
        category10 = categoryRepository.save(category10);
        category11 = categoryRepository.save(category11);
        category12 = categoryRepository.save(category12);

    }
}