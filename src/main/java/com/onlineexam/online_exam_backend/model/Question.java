package com.onlineexam.online_exam_backend.model;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType; // MCQ or ESSAY

    @Column(columnDefinition = "TEXT")
    private String options; // JSON string for MCQ options

    private String correctAnswer; // for MCQ

    private int marks;

    // Constructors
    public Question() {}

    public Question(Exam exam, String questionText, QuestionType questionType, String options, String correctAnswer, int marks) {
        this.exam = exam;
        this.questionText = questionText;
        this.questionType = questionType;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Exam getExam() { return exam; }
    public void setExam(Exam exam) { this.exam = exam; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public QuestionType getQuestionType() { return questionType; }
    public void setQuestionType(QuestionType questionType) { this.questionType = questionType; }

    public String getOptions() { return options; }
    public void setOptions(String options) { this.options = options; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}
