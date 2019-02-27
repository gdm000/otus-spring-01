package edu.otus.spring01.runner;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;

public interface QuizRunner {
    QuizResult runQuiz(QuizBundle quiz) throws Exception;
}
