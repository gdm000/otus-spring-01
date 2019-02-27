package edu.otus.spring01.service;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.loader.QuizLoader;
import edu.otus.spring01.validator.QuizValidator;

public class QuizServiceImpl implements QuizService {
    private final QuizLoader loader;
    private final QuizValidator validator;

    public QuizServiceImpl(QuizLoader loader, QuizValidator validator) {
        this.loader = loader;
        this.validator = validator;
    }

    @Override
    public QuizBundle getQuiz() throws Exception {
        QuizBundle bundle = loader.load();
        validator.validate(bundle);
        return bundle;
    }
}
