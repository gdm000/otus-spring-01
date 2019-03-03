package edu.otus.spring01.validator;

import edu.otus.spring01.domain.QuizBundle;

public class QuizValidatorImpl implements QuizValidator {
    public static final int minQuestionsCount = 5;
    @Override
    public void validate(QuizBundle bundle) {
        if (bundle.getQuestions().size() < minQuestionsCount) {
            throw new IllegalArgumentException(String.format("Less than %d  questions", minQuestionsCount));
        }

        if (bundle.getQuestions().stream().filter(q -> q.getValidOptionIndex() < 0 || q.getOptions().size() < q.getValidOptionIndex() + 1).count() > 0) {
            throw new IllegalArgumentException("Bad question options data");
        }
    }
}
