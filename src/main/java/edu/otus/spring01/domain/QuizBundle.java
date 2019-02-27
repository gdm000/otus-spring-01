package edu.otus.spring01.domain;

import java.util.Collections;
import java.util.List;

public class QuizBundle {
    private List<QuestionBundle> questions;

    public QuizBundle(List<QuestionBundle> questions) {
        this.questions = Collections.unmodifiableList(questions);
    }

    public List<QuestionBundle> getQuestions() {
        return questions;
    }
}