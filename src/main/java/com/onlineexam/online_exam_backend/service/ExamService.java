package com.onlineexam.online_exam_backend.service;

import com.onlineexam.online_exam_backend.model.Exam;
import com.onlineexam.online_exam_backend.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam updateExam(Long id, Exam examDetails) {
        Optional<Exam> optionalExam = examRepository.findById(id);
        if (!optionalExam.isPresent()) {
            throw new RuntimeException("Exam not found with id " + id);
        }
        Exam exam = optionalExam.get();
        exam.setTitle(examDetails.getTitle());
        exam.setDuration(examDetails.getDuration());
        exam.setPassMarks(examDetails.getPassMarks());
        exam.setDescription(examDetails.getDescription());
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}
