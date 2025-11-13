package com.onlineexam.online_exam_backend.service;

import com.onlineexam.online_exam_backend.model.Exam;
import com.onlineexam.online_exam_backend.model.Question;
import com.onlineexam.online_exam_backend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getQuestionsByExam(Exam exam) {
        return questionRepository.findByExam(exam);
    }

    public Question updateQuestion(Long id, Question questionDetails) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (!optionalQuestion.isPresent()) {
            throw new RuntimeException("Question not found with id " + id);
        }
        Question question = optionalQuestion.get();
        question.setQuestionText(questionDetails.getQuestionText());
        question.setQuestionType(questionDetails.getQuestionType());
        question.setOptions(questionDetails.getOptions());
        question.setCorrectAnswer(questionDetails.getCorrectAnswer());
        question.setMarks(questionDetails.getMarks());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
