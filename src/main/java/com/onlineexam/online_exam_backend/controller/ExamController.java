package com.onlineexam.online_exam_backend.controller;

import com.onlineexam.online_exam_backend.model.Exam;
import com.onlineexam.online_exam_backend.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin(origins = "http://localhost:5173")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam examDetails) {
        return examService.updateExam(id, examDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return "Exam deleted successfully!";
    }
}
