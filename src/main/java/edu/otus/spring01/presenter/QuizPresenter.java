package edu.otus.spring01.presenter;

import edu.otus.spring01.domain.QuizBundle;
import edu.otus.spring01.domain.QuizResult;

import java.io.IOException;

public interface QuizPresenter {
    QuizResult present(QuizBundle quiz) throws IOException;
}
