package com.onlineexam.online_exam_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlineexam.online_exam_backend.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
