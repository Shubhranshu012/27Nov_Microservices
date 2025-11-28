package com.quiz_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz_service.model.QuestionWrapper;
import com.quiz_service.model.Response;

import java.util.List;

@FeignClient("question-service") 
public interface QuizInterface {

    @GetMapping("/question/generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam("categoryName") String categoryName,@RequestParam("numQuestions") Integer numQuestions);

    @PostMapping("/question/getQuestions")
    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("/question/getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}