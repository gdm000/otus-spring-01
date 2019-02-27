package edu.otus.spring01.validator;

import edu.otus.spring01.domain.QuizBundle;

public interface QuizValidator {
    void validate(QuizBundle bundle) throws Exception;
}
