package com.semicolon.quizapplication.repository;

import com.semicolon.quizapplication.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
}
