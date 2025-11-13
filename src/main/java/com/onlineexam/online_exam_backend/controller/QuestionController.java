package com.onlineexam.online_exam_backend.controller;

import com.onlineexam.online_exam_backend.model.Exam;
import com.onlineexam.online_exam_backend.model.Question;
import com.onlineexam.online_exam_backend.service.ExamService;
import com.onlineexam.online_exam_backend.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    private final QuestionService questionService;
    private final ExamService examService;

    public QuestionController(QuestionService questionService, ExamService examService) {
        this.questionService = questionService;
        this.examService = examService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        // Ensure the exam exists
        Exam exam = examService.getAllExams()
                .stream()
                .filter(e -> e.getId().equals(question.getExam().getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        question.setExam(exam);
        return questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getQuestionsByExam(@RequestParam Long examId) {
        Exam exam = examService.getAllExams()
                .stream()
                .filter(e -> e.getId().equals(examId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Exam not found"));
        return questionService.getQuestionsByExam(exam);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
        return questionService.updateQuestion(id, questionDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "Question deleted successfully!";
    }
}
