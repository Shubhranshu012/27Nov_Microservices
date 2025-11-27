package com.question_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.question_service.model.Question;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    
    @Query(value = "SELECT q.id FROM question q WHERE q.category = ?1 ORDER BY RAND()", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int num);
}