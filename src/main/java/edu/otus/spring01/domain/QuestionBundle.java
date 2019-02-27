package edu.otus.spring01.domain;

import java.util.Collections;
import java.util.List;

public class QuestionBundle {
    private final String question;
    private final List<String> options;
    private final int validOptIdx;

    public QuestionBundle(String question, int validOptIdx, List<String> options) {
        this.question = question;
        this.options = Collections.unmodifiableList(options);
        this.validOptIdx = validOptIdx;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getValidOptIdx() {
        return validOptIdx;
    }

    public boolean isValid(int idx) {
        return idx == validOptIdx;
    }
}