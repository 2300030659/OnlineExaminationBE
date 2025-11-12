package com.onlineexam.online_exam_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.onlineexam.online_exam_backend.model.Exam;
import com.onlineexam.online_exam_backend.repository.ExamRepository;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepo;

    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }

    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    public Optional<Exam> getExamById(Long id) {
        return examRepo.findById(id);
    }

    public Exam updateExam(Long id, Exam updatedExam) {
        return examRepo.findById(id)
                .map(exam -> {
                    exam.setTitle(updatedExam.getTitle());
                    exam.setDescription(updatedExam.getDescription());
                    exam.setDuration(updatedExam.getDuration());
                    exam.setPassMarks(updatedExam.getPassMarks());
                    exam.setStartTime(updatedExam.getStartTime());
                    exam.setEndTime(updatedExam.getEndTime());
                    return examRepo.save(exam);
                })
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    public void deleteExam(Long id) {
        examRepo.deleteById(id);
    }
}
