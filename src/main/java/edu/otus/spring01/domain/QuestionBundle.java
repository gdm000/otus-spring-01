package edu.otus.spring01.domain;

import java.util.Collections;
import java.util.List;

public class QuestionBundle {
    private final String question;
    private final List<String> options;
    private final int validOptionIndex;

    public QuestionBundle(String question, int validOptionIndex, List<String> options) {
        this.question = question;
        this.options = Collections.unmodifiableList(options);
        this.validOptionIndex = validOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getValidOptionIndex() {
        return validOptionIndex;
    }
}